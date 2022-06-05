package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;

public interface UserDao {

	public int insertIntoDb(User user);

	public int validate(String email, String password);

	public int insertVendorRequest(VendorRequest request, String email);

	public int insertBuyerRequest(BuyerRequest buyerRequest, String email, int amount);

	public List<BuyerRequest> fetchRecords(String email);

	public String checkStatus(int requestId);

	// public int updatePayment(BuyerRequest buyerRequest, String email,int amount);
	public int updatePayment2(int requestId, int amount);
}