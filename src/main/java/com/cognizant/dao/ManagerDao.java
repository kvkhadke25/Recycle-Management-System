package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Manager;

public interface ManagerDao {

	public int saveManager(Manager m);

	public boolean checkManagerCredentials(String email, String password);

	public List getVendorRequests();

	public int changeStatus(int requestId, String status);

	public List getManagerDetails();

	public int changeApproval(String email, String approve);
}
