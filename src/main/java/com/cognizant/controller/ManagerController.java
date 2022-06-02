package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.model.Manager;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	Manager man;

	@Autowired
	ManagerService service;

	// ManagerRegistration
	@RequestMapping(value = "/managerRegForm")
	public String managerRegForm(Model m) {
		m.addAttribute("manager", man);
		return "managerRegForm";
	}

	@RequestMapping(value = "/submitForm")
	public String saveManagerDetails(@Valid @ModelAttribute("manager") Manager manager, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return "managerRegForm";
		} else {
			if (service.saveManager(manager) == -1) {
				return "managerAddedFail";
			} else {
				return "managerAddedSuccess";
			}
		}

	}

	// Manager Login
	@RequestMapping(value = "/loginmanager")
	public String managerLogin() {
		return "managerLogin";
	}

	@RequestMapping(value = "/validatemanager")
	public String managerCredentialValidation(HttpServletRequest req) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		if (service.checkManagerCredentials(email, pass)) {
			String name = service.getManagerNameWithEmail(email);
			req.setAttribute("name", name);
			return "managerLoginSuccess";
		} else {
			return "managerIncorrectCredentials";
		}
	}

	// ManagerViewVendorRequests
	@RequestMapping(value = "/viewrequests")
	public String viewRequests(HttpServletRequest req) {
		List<VendorRequest> requests = service.getVendorRequests();
		req.setAttribute("requestsList", requests);
		return "viewVendorRequests";
	}

	// First View
	@RequestMapping(value = "/manager")
	public String managerLoginRegister() {
		return "managerLoginReg";
	}

	// Edit Status
	@RequestMapping(value = "/editstatus")
	public String editStatus() {
		return "managerEditStatus";
	}

	@RequestMapping(value = "/submitstatus")
	public String submitStatus(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("requestid"));
		String newStatus = req.getParameter("status");
		service.changeStatus(id, newStatus);
		List<VendorRequest> requests = service.getVendorRequests();
		req.setAttribute("requestsList", requests);
		return "viewVendorRequests";
	}

	// ManagerApproval
	@RequestMapping(value = "/managerapproval")
	public String managerApproval(HttpServletRequest req) {
		List<Manager> managerDetails = service.getManagerDetails();
		req.setAttribute("managerdetails", managerDetails);
		return "managerApproval";
	}

	@RequestMapping(value = "/submitapproval")
	public String submitApproval(HttpServletRequest req) {
		String managerEmail = req.getParameter("email");
		String approve = req.getParameter("approve");

		service.changeManagerApproval(managerEmail, approve);

		List<Manager> managerDetails = service.getManagerDetails();

		req.setAttribute("managerdetails", managerDetails);

		return "managerApproval";
	}

}