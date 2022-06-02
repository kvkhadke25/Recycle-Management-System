package com.cognizant.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Manager;
import com.cognizant.model.VendorRequest;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// return -1 if email already exist
	@Override
	public int saveManager(Manager m) {
		String checkEmail = "select count(*) from manager where email='" + m.getEmail() + "'";
		int i = jdbcTemplate.queryForObject(checkEmail, Integer.class);
		if (i < 1) {
			String insertQuery = "insert into manager (first_name, last_name, email, phone_number, password, gender, skills) values (?, ?, ?, ?, ?, ?, ?)";
			int executed = jdbcTemplate.update(insertQuery, m.getFirstName(), m.getLastName(), m.getEmail(),
					m.getContact(), m.getPassword(), m.getGender(), m.getSkill());
			return executed;
		} else {
			return -1;
		}
	}

	@Override
	public boolean checkManagerCredentials(String email, String password) {
		String selectQuery = "select count(*) from manager where email='" + email + "' and password='" + password
				+ "' and approved='yes'";
		int i = jdbcTemplate.queryForObject(selectQuery, Integer.class);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List getVendorRequests() {
		List<VendorRequest> requests = new ArrayList<>();

		String selectQuery = "select request_id, vendor_email, type_of_org, amount, location, request_date, required_date, status, time from vendor_request";

		requests = jdbcTemplate.query(selectQuery,
				(rs, rowNum) -> new VendorRequest(rs.getInt("request_id"), rs.getString("vendor_email"),
						rs.getString("type_of_org"), rs.getInt("amount"), rs.getString("location"),
						LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("request_date"))),
						LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("required_date"))),
						rs.getString("status"), rs.getString("time")));

		return requests;
	}

	@Override
	public int changeStatus(int requestId, String status) {
		String updateQuery = "update vendor_request set status='" + status + "' where request_id =" + requestId;

		int affectedRows = jdbcTemplate.update(updateQuery);

		return affectedRows;

	}

	@Override
	public List getManagerDetails() {

		List<Manager> managerDetails = new ArrayList<>();

		String selectQuery = "select first_name, last_name, email, phone_number, password ,gender, skills, approved from manager";

		managerDetails = jdbcTemplate.query(selectQuery,
				(rs, rowNum) -> new Manager(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getString("phone_number"), rs.getString("password"),
						rs.getString("gender"), rs.getString("skills"), rs.getString("approved")));

		return managerDetails;
	}

	@Override
	public int changeApproval(String email, String approve) {

		String updateQuery = "update manager set approved='" + approve + "' where email ='" + email + "'";
		int affectedRows = jdbcTemplate.update(updateQuery);
		return affectedRows;
	}

}
