package com.cognizant.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class VendorRequest {
	private int requestId;
	private String vendorEmail;
	private String typeOfOrg;
	private int amount;
	private String location;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requestDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requiredDate;
	private String status;
	private String time;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getTypeOfOrg() {
		return typeOfOrg;
	}

	public void setTypeOfOrg(String typeOfOrg) {
		this.typeOfOrg = typeOfOrg;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public VendorRequest(int requestId, String vendorEmail, String typeOfOrg, int amount, String location,
			LocalDate requestDate, LocalDate requiredDate, String status, String time) {
		super();
		this.requestId = requestId;
		this.vendorEmail = vendorEmail;
		this.typeOfOrg = typeOfOrg;
		this.amount = amount;
		this.location = location;
		this.requestDate = requestDate;
		this.requiredDate = requiredDate;
		this.status = status;
		this.time = time;
	}

	public VendorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
