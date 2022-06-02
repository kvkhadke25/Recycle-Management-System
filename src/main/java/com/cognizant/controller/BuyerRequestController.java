package com.cognizant.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.BuyerRequest;
import com.cognizant.service.BuyerRequestService;

@Controller
public class BuyerRequestController {

	@Autowired
	BuyerRequestService service;

	@RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
	public String viewOrders(ModelMap model) {
		List<BuyerRequest> orders = new ArrayList<>();
		orders = service.viewBuyerOrders();
		List<Integer> due = new ArrayList<>();
		List<Boolean> editToReady = new ArrayList<>();
		List<Boolean> editToShip = new ArrayList<>();
		for (BuyerRequest order : orders) {
			boolean ship = false;
			boolean ready = false;
			if ((order.getPaidAmount() - order.getAmount()) == 0
					&& !(order.getStatus().equalsIgnoreCase("Order Shipped"))) {
				due.add(0);
				ship = true;
			} else if ((order.getPaidAmount() - order.getAmount()) != 0) {
				LocalDate orderDate = order.getRequestDate();
				LocalDate today = LocalDate.now();
				Period period = Period.between(orderDate, today);
				int days = period.getDays();
				int quantity = order.getQuantity();
				if (quantity < 10) {
					due.add(0);
					ready = true;
				} else if (quantity >= 10 && quantity < 20) {
					if (days >= 2) {
						due.add(0);
						ready = true;
					} else
						due.add(2 - days);
				} else {
					if (days >= 4) {
						ready = true;
						due.add(0);
					} else {
						due.add(4 - days);
					}
				}
			} else {
				due.add(0);
			}
			editToReady.add(ready);
			editToShip.add(ship);
		}
		model.put("editToShip", editToShip);
		// System.out.println(editToShip);
		model.put("orders", orders);
		model.put("due", due);
		// System.out.print(due);
		model.put("editToReady", editToReady);
		return "buyerOrders";
	}

	@RequestMapping(value = "/editStatus", method = RequestMethod.GET)
	public String editStatus(@RequestParam("requestId") int requestId, @RequestParam("orderStatus") int status) {
		if (status == 1) {
			// System.out.println(status);
			service.update(requestId, "Order Ready");
		} else {
			service.update(requestId, "Order Shipped");
		}
		return "redirect:/viewOrders";
	}

}
