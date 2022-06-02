package com.cognizant.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.AdminService;

@Controller
@SessionAttributes("email")
public class AdminController {

	@Autowired
	AdminService adminservice;

	private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
		// model.put("name",name);
		return "loginAdmin";
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String showAdminWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {
		LOGGER.info("Admin Credentials sent for validation ");
		boolean isValidUser = adminservice.validateAdmin(username, password);
		if (!isValidUser) {
			model.put("message", "Invalid Credentials");
			LOGGER.info("Admin Credentials are Invalid , returning to Login Admin page  ");
			return "loginAdmin";
		}
		LOGGER.info("Admin Credentials are Valid , Going to Welcome Admin page  ");
		return "welcomeAdmin";
	}

	/* It provides list of requests in model object */
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public String vendorRequestsDefault(Model m) {
		LOGGER.info("Showing Vendor Requests for today");
		List<VendorRequest> list = adminservice.getTodayRequests(LocalDate.now());
		if (list.isEmpty()) {
			LOGGER.info("No Vendor Requests for today");
		}
		m.addAttribute("list", list);
		m.addAttribute("currentDate", LocalDate.now());
		m.addAttribute("date", LocalDate.now());
		return "viewRequests";
	}

	@RequestMapping(value = "/requestOnDate", method = RequestMethod.GET)
	public String vendorRequestsChosen(Model m,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		LOGGER.info("Showing Vendor Collections for selected date");
		List<VendorRequest> list = adminservice.getCollections(date);
		if (list.isEmpty())
			LOGGER.info("No Vendor Collections for selected date");
		m.addAttribute("list", list);
		m.addAttribute("currentDate", LocalDate.now());
		m.addAttribute("date", date);
		return "viewCollectionOnDate";
	}

	@RequestMapping(value = "/viewReportForBuyer", method = RequestMethod.GET)
	public String generateBuyerReport(ModelMap model) {
		LocalDate today = LocalDate.now();
		model.put("today", today);
		model.put("date1", "");
		model.put("date2", "");
		return "buyerReport";
	}

	@RequestMapping(value = "/viewReportForBuyer", method = RequestMethod.POST)
	public String generateBuyerReport3(@RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,
			@RequestParam("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2, ModelMap model) {
		model.put("date1", date1);
		model.put("date2", date2);
		if (date2.compareTo(date1) <= 0) {
			model.put("status", false);
			model.put("msg", "To date should be greater than From Date");
		} else {
			List<BuyerRequest> orders = adminservice.viewReportForBuyer(date1, date2);
			if (orders.isEmpty()) {
				model.put("msg2", "No Records Found");
			} else {
				model.put("status", true);
				model.put("orders", orders);
			}
		}
		return "buyerReport";
	}

	@RequestMapping(value = "/downloadReportForBuyer", method = RequestMethod.GET)
	public String generateBuyerReport2(ModelMap model,
			@RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,
			@RequestParam("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2, ModelMap mode)
			throws Exception {
		adminservice.generateReportForBuyer(date1, date2);
		model.put("msg",
				"REPORT HAS BEEN DOWNLOADED AS SHEET buyer_report_" + date1 + "-" + date2 + " IN BUYERS_REPORT.xlsx");
		return "downloadReport";
	}

	@RequestMapping(value = "/wastageReport", method = RequestMethod.GET)
	public String wastageReportDateCollection(Model m) {
		m.addAttribute("yesterday", LocalDate.now().minusDays(1));
		return "wastageReportHome";

	}

	@RequestMapping(value = "/wastageReport", method = RequestMethod.POST)
	public String wastageReportCollectionDisplay(
			@RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate enddate, ModelMap model,
			Model m) {
		model.put("startdate", startdate);
		model.put("enddate", enddate);
		m.addAttribute("yesterday", LocalDate.now().minusDays(1));
		if (enddate.compareTo(startdate) <= 0) {
			model.put("status", false);
			model.put("msg", "To date should be greater than From Date");
		} else {
			List<VendorRequest> list = adminservice.getVendorCollectionsBetweenTwoDates(startdate, enddate);
			if (list.isEmpty()) {
				model.put("msg2", "No Records Found");
			} else {
				model.put("status", true);
				model.put("list", list);
			}
		}
		return "wastageReportHome";
	}

	@RequestMapping(value = "/downloadReportForVendor", method = RequestMethod.GET)
	public String generateVendorCollectionReport(ModelMap model,
			@RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate enddate) throws Exception {
		adminservice.generateReportForVendor(startdate, enddate);
		model.put("msg", "REPORT HAS BEEN DOWNLOADED AS VENDORS_REPORT.xlsx.");
		return "downloadReportVendor";
	}

	@RequestMapping(value = "/adminOptions")
	public String openAdmin() {
		return "welcomeAdmin";
	}
}
