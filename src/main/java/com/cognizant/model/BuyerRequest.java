package com.cognizant.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BuyerRequest {
	private Integer requestId;
	private String buyerEmail;
	private Integer amount;
	private Integer quantity;
	private String location;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requestDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requiredDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	private String status;
	private Integer paidAmount;

	public Integer getRequestId() {
		return requestId;
	}

	@Override
	public String toString() {
		return "BuyerRequest [requestId=" + requestId + ", buyerEmail=" + buyerEmail + ", amount=" + amount
				+ ", quantity=" + quantity + ", location=" + location + ", requestDate=" + requestDate
				+ ", requiredDate=" + requiredDate + ", paymentDate=" + paymentDate + ", status=" + status
				+ ", paidAmount=" + paidAmount + "]";
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
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

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public BuyerRequest(Integer requestId, String buyerEmail, Integer amount, Integer quantity, String location,
			LocalDate requestDate, LocalDate requiredDate, LocalDate paymentDate, String status, Integer paidAmount) {
		super();
		this.requestId = requestId;
		this.buyerEmail = buyerEmail;
		this.amount = amount;
		this.quantity = quantity;
		this.location = location;
		this.requestDate = requestDate;
		this.requiredDate = requiredDate;
		this.paymentDate = paymentDate;
		this.status = status;
		this.paidAmount = paidAmount;
	}

}