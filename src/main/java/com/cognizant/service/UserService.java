package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public int insertIntoDb(User user) {
		// System.out.print("Service"+userDao.insertIntoDb(user));
		return userDao.insertIntoDb(user);
	}

	public boolean validateUser(String email, String password) {
		int check = userDao.validate(email, password);
		if (check >= 1)
			return true;
		else
			return false;
	}

	public int insertVendorRequest(VendorRequest request, String email) {
		return userDao.insertVendorRequest(request, email);
	}

	public int insertBuyerRequest(BuyerRequest buyerRequest, String email, int amount) {
		return userDao.insertBuyerRequest(buyerRequest, email, amount);
	}

	public List<BuyerRequest> fetchRecords(String email) {
		List<BuyerRequest> records = userDao.fetchRecords(email);
		return records;
	}

	public String checkStatus(int requestId) {
		String status = userDao.checkStatus(requestId);
		return status;
	}

//        public void updatePayment(BuyerRequest buyerRequest,String email,int amount) {
//		userDao.updatePayment(buyerRequest,email,amount);
//	}

	public void updatePayment2(int requestId, int amount) {
		userDao.updatePayment2(requestId, amount);
	}

}