package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ManagerDao;
import com.cognizant.model.Manager;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	public ManagerService(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public int saveManager(Manager manager) {
		return managerDao.saveManager(manager);
	}

	public boolean checkManagerCredentials(String email, String password) {
		return managerDao.checkManagerCredentials(email, password);
	}

	public List getVendorRequests() {
		return managerDao.getVendorRequests();
	}

	public int changeStatus(int requestId, String status) {
		return managerDao.changeStatus(requestId, status);
	}

	public List getManagerDetails() {
		return managerDao.getManagerDetails();
	}

	public int changeManagerApproval(String email, String approve) {
		return managerDao.changeApproval(email, approve);
	}

	public String getManagerNameWithEmail(String email) {
		List<Manager> allManagers = managerDao.getManagerDetails();
		String name = "";
		for (Manager mg : allManagers) {
			if (mg.getEmail().equals(email)) {
				name = mg.getFirstName() + " " + mg.getLastName();
				break;
			}
		}
		return name;
	}
}
