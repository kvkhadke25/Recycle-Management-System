package com.cognizant.model;

import javax.validation.constraints.NotNull;

public class Admin {

	@NotNull(message = "Username cannot be empty")
	private String username;

	@NotNull(message = "Password cannot be empty")
	private String password;

	public Admin(@NotNull(message = "Username cannot be empty") String username,
			@NotNull(message = "Password cannot be empty") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
