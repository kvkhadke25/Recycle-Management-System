package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.BuyerRequestDao;
import com.cognizant.model.BuyerRequest;

@Service
public class BuyerRequestService {

	@Autowired
	BuyerRequestDao buyerRequest;

	public List<BuyerRequest> viewBuyerOrders() {
		List<BuyerRequest> orders = buyerRequest.viewBuyerOrders();
		return orders;
	}

	public void update(int requestId, String status) {
		buyerRequest.update(requestId, status);
	}
}
