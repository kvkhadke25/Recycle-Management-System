package com.cognizant.dao;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.VendorRequest;

public interface AdminDao {

	public int validate(String username, String password);

	public List<VendorRequest> getVendorCollections(LocalDate localDate);

	public List<VendorRequest> getVendorRequestsForToday(LocalDate localDate);

	public void generateReportForBuyer(LocalDate date1, LocalDate date2) throws Exception;

	public List<BuyerRequest> viewReportForBuyer(LocalDate date1, LocalDate date2);

	public List<VendorRequest> getVendorCollectionsBetweenTwoDates(LocalDate startdate, LocalDate enddate);

	public void generateReportForVendor(LocalDate date1, LocalDate date2) throws Exception;
}
