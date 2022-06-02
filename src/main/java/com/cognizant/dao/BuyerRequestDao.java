package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.BuyerRequest;

public interface BuyerRequestDao {

	public List<BuyerRequest> viewBuyerOrders();

	public int update(int requestId, String status);
}
