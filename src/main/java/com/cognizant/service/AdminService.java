package com.cognizant.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.AdminDao;
import com.cognizant.model.BuyerRequest;
import com.cognizant.model.VendorRequest;

@Component
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public AdminService(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public boolean validateAdmin(String username, String password) {
		int check = adminDao.validate(username, password);
		if (check >= 1)
			return true;
		else
			return false;
	}

	public List<VendorRequest> getTodayRequests(LocalDate localDate) {
		List<VendorRequest> vRequests = adminDao.getVendorRequestsForToday(localDate);
		return vRequests;

	}

	public List<VendorRequest> getCollections(LocalDate localDate) {
		List<VendorRequest> vRequests = adminDao.getVendorCollections(localDate);
		return vRequests;

	}

	public List<VendorRequest> getVendorCollectionsBetweenTwoDates(LocalDate startdate, LocalDate enddate) {
		List<VendorRequest> vRequestsBetweenTwoDates = adminDao.getVendorCollectionsBetweenTwoDates(startdate, enddate);
		return vRequestsBetweenTwoDates;
	}

	public void generateReportForVendor(LocalDate date1, LocalDate date2) throws Exception {
		adminDao.generateReportForVendor(date1, date2);

	}

	public void generateReportForBuyer(LocalDate date1, LocalDate date2) throws Exception {
		adminDao.generateReportForBuyer(date1, date2);
	}

	public List<BuyerRequest> viewReportForBuyer(LocalDate date1, LocalDate date2) {
		List<BuyerRequest> orders = adminDao.viewReportForBuyer(date1, date2);
		return orders;
	}

}
