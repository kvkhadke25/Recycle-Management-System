package com.cognizant.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.UserService;

@Controller
@SessionAttributes({ "User", "BuyerRequest" })
public class UserController {
	@Autowired
	private UserService service;

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ModelAttribute("genderList")
	public List<String> genderList() {
		List<String> list = new ArrayList<>();
		list.add("----Select----");
		list.add("Male");
		list.add("Female");
		return list;
	}

	@RequestMapping(value = "/userHomePage", method = RequestMethod.GET)
	public String userHomePage(ModelMap model) {
		return "user";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registrationPage(@ModelAttribute("user") User user) {
		return "userRegistration";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registrationValidation(@Valid @ModelAttribute("user") User user, BindingResult result,
			ModelMap model) {
		LOGGER.info("Start");
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			LOGGER.info("end");
			return "userRegistration";

		} else {
			// System.out.print("Controller"+service.insertIntoDb(user));
			if (service.insertIntoDb(user) == -1) {
				return "userRegistrationFailed";
			} else {
				return "userRegistrationSuccessful";
			}
		}
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		// model.put("name",name);
		return "loginUsers";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @ModelAttribute("user") User user) {
		LOGGER.info("Start");
		boolean isValidUser = service.validateUser(user.getEmail(), user.getPassword());
		if (!isValidUser) {
			model.put("message", "Invalid Credentials/Please Register first");
			LOGGER.info("End");
			return "loginUsers";
		}

		// model.put("name",email);
		// model.put("password",password);
		model.put("User", user);
		LOGGER.info("End");
		return "welcomeUser";
	}

	@RequestMapping(value = "/buyer", method = RequestMethod.GET)
	public String buyerHomePage1(@ModelAttribute("buyerRequest") BuyerRequest buyerRequest, ModelMap model) {
		LOGGER.info("Start");
		LocalDate date = LocalDate.now();
		model.put("date", date);
		LOGGER.info("End");
		return "buyerHomePage";
	}

	@RequestMapping(value = "/viewPastOrders", method = RequestMethod.GET)
	public String viewOrders(@ModelAttribute("buyerRequest") BuyerRequest buyerRequest, ModelMap model) {
		LOGGER.info("Start");
		User user = (User) model.get("User");
		String email = user.getEmail();
		List<BuyerRequest> records = service.fetchRecords(email);
		if (records.isEmpty()) {
			model.put("msg", "NO ORDERS");
			LOGGER.info("End");
			return "buyerPastNoOrders";
		} else {
			model.put("records", records);
			List<String> statusList = new ArrayList<>();
			List<Boolean> payList = new ArrayList<>();
			for (BuyerRequest request : records) {
				String status = service.checkStatus(request.getRequestId());
				boolean pay = false;
				if (status.equalsIgnoreCase("Order Ready")) {
					pay = true;
					payList.add(pay);
					statusList.add("Order Ready");
				} else if (status.equalsIgnoreCase("Order Received")) {
					payList.add(pay);
					statusList.add("Order Placed");
				} else if (status.equalsIgnoreCase("Order Shipped")) {
					payList.add(pay);
					statusList.add("Order Shipped");
				}
				model.put("statusList", statusList);
				model.put("payList", payList);
			}
			LOGGER.info("End");
			return "buyerPastOrders";
		}
	}

	@RequestMapping(value = "/buyer", method = RequestMethod.POST)
	public String buyerHomePage(@ModelAttribute("buyerRequest") BuyerRequest buyerRequest, ModelMap model) {
		LOGGER.info("Start");
		User user = (User) model.get("User");
		String message;
		int days = 0;
		if (buyerRequest.getQuantity() < 10) {
			message = "We can serve your request today.";
		} else if (buyerRequest.getQuantity() >= 10 && buyerRequest.getQuantity() < 20) {
			days = 2;
			message = "We can serve your request in 2 days.";
		} else {
			days = 4;
			message = "We can serve your request in 4 days.";
		}
		LocalDate orderDate = buyerRequest.getRequiredDate();
		LocalDate today = LocalDate.now();
		Period period = Period.between(today, orderDate);
		int availableDays = period.getDays();
		System.out.print(availableDays);
		if (availableDays < days) {
			model.put("sorry", true);
			model.put("sorryMsg",
					"We won't be able to serve your request by the date choosen by you. Please select another date.");
		} else {
			model.put("msg", message);
			int quantity = buyerRequest.getQuantity();
			// System.out.print("Qty"+quantity);
			int amount = quantity * 50;
			buyerRequest.setAmount(amount);
			model.put("amount", buyerRequest.getAmount());
			if (quantity < 10)
				model.put("pamount", buyerRequest.getAmount());
			else
				model.put("pamount", buyerRequest.getAmount() * 0.4);
			model.put("BuyerRequest", buyerRequest);
			LOGGER.info("End");
		}
		return "displayBuyerDetails";
	}

	@RequestMapping(value = "/vendorRequest", method = RequestMethod.GET)
	public String vendorRequestPage(@ModelAttribute("request") VendorRequest request, ModelMap model) {
		LOGGER.info("Start");
		LocalDate date = LocalDate.now();
		model.put("date", date);
		LOGGER.info("End");
		return "vendorRequestForm";
	}

	@RequestMapping(value = "/welcomeUser", method = RequestMethod.POST)
	public String vendorRequestToDB(@ModelAttribute("request") VendorRequest request, ModelMap model) {
		LOGGER.info("Start");
		User user = (User) model.get("User");
		service.insertVendorRequest(request, user.getEmail());
		LOGGER.info("End");
		return "welcomeUser";

	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String paymentPage(ModelMap model) {
		BuyerRequest buyerRequest = (BuyerRequest) model.get("BuyerRequest");
		if (buyerRequest.getQuantity() < 10) {
			model.put("paidAmount", (buyerRequest.getAmount()));
		} else {
			model.put("paidAmount", (0.4 * buyerRequest.getAmount()));
		}
		return "payment";
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(ModelMap model, @RequestParam String paidAmount) {
		LOGGER.info("Start");
		Double amount1 = Double.parseDouble(paidAmount);
		int amount = (int) Math.round(amount1);

		BuyerRequest buyerRequest = (BuyerRequest) model.get("BuyerRequest");

		User user = (User) model.get("User");
		service.insertBuyerRequest(buyerRequest, user.getEmail(), amount);
		String message = "Payment Successful";
		model.put("msg", message);
		LOGGER.info("End");
		return "welcomeUser";

	}

	@RequestMapping(value = "/payForOrder", method = RequestMethod.GET)
	public String paymentPage2(ModelMap model, @RequestParam int requestId, @RequestParam int amount,
			@RequestParam int paidamount) {
		LOGGER.info("Start");
		int pamount = amount - paidamount;
		model.put("payamount", pamount);
		model.put("totamount", amount);
		model.put("requestId", requestId);
		LOGGER.info("End");
		return "payment2";
	}

	@RequestMapping(value = "/pay2", method = RequestMethod.POST)
	public String pay2(ModelMap model, @RequestParam int paidAmount, @RequestParam int totamount,
			@RequestParam int requestId) {

		LOGGER.info("Start");
		// BuyerRequest buyerRequest = (BuyerRequest) model.get("BuyerRequest");

		service.updatePayment2(requestId, totamount);
		model.put("paySuccess", "Payment Successful");
		return "welcomeUser";
	}

	@RequestMapping(value = "/userOptions")
	public String openAdmin() {
		return "welcomeUser";
	}

}
