package com.cognizant.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Manager {

	@Size(min = 3, max = 15, message = "number of characters must be >= 3 and <= 15")
	String firstName;

	@Size(min = 3, max = 15, message = "number of characters must be >= 3 and <= 15")
	String lastName;

	@Size(min = 10, max = 10, message = "number of characters must be equal to 10")
	String contact;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "enter a valid email")
	String email;

	@Size(min = 6, message = "there must be alteast 6 characters")
	String password;

	String skill;

	String gender;

	String approval;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public Manager(@Size(min = 3, max = 15, message = "number of characters must be >= 3 and <= 15") String firstName,
			@Size(min = 3, max = 15, message = "number of characters must be >= 3 and <= 15") String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "enter a valid email") String email,
			@Size(min = 10, max = 10, message = "number of characters must be equal to 10") String contact,
			@Size(min = 6, message = "there must be alteast 6 characters") String password,
			@NotNull(message = "select one") String skill, @NotNull(message = "select one") String gender,
			String approval) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.skill = skill;
		this.gender = gender;
		this.approval = approval;
	}

	public Manager() {
		super();
	}

}
