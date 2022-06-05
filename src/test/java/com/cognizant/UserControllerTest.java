package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.controller.UserController;
import com.cognizant.dao.UserDao;
import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.UserService;

public class UserControllerTest {

	private UserService userServiceMock;

	private UserDao userDaoMock = mock(UserDao.class);

	private MockMvc mockMvcUser;

	@BeforeEach
	public void setup() {
		this.mockMvcUser = MockMvcBuilders.standaloneSetup(new UserController()).build();
		userServiceMock = new UserService(userDaoMock);
	}

	// Test User Home Page
	@Test
	public void testUserHomePage() throws Exception {
		this.mockMvcUser.perform(get("/userHomePage")).andExpect(status().isOk()).andExpect(view().name("user"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test User Registration Page - US2
	@Test
	public void testRegistrationPage() throws Exception {
		this.mockMvcUser.perform(get("/registerUser")).andExpect(status().isOk())
				.andExpect(view().name("userRegistration")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test User Login Page - US2
	@Test
	public void testShowLoginPage() throws Exception {
		this.mockMvcUser.perform(get("/loginUser")).andExpect(status().isOk()).andExpect(view().name("loginUsers"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test Buyer Form - US10
	@Test
	public void testUserBuyerHomePage() throws Exception {
		this.mockMvcUser.perform(get("/buyer")).andExpect(status().isOk()).andExpect(view().name("buyerHomePage"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test Vendor Form - US7
	@Test
	public void testVendorRequestPagePage() throws Exception {
		this.mockMvcUser.perform(get("/vendorRequest")).andExpect(status().isOk())
				.andExpect(view().name("vendorRequestForm")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test the addition of user records into database - US2
	@Test
	public void testUserInsertIntoDb() throws Exception {
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setFirstName("Anmol");
		user.setLastName("Goyal");
		user.setGender("Female");
		user.setPassword("abc1@3");
		user.setPhoneNumber("9988776655");
		when(userDaoMock.insertIntoDb(user)).thenReturn(1);
		assertEquals(1, userServiceMock.insertIntoDb(user));
	}

	// User Login Credentials Validation - US6
	@Test
	public void testUserValidateCredentials() throws Exception {
		when(userDaoMock.validate("abc@gmail.com", "abc1@3")).thenReturn(1);
		assertEquals(true, userServiceMock.validateUser("abc@gmail.com", "abc1@3"));
	}

	// Inserting Records in Db for Vendor Requests - US7
	@Test
	public void testInsertVendorRequest() throws Exception {
		VendorRequest request = new VendorRequest(11, "abc@gmail.com", "Hostel", 200, "pune", LocalDate.now(),
				LocalDate.now(), "abc", "101010");
		when(userDaoMock.insertVendorRequest(request, "abc@gmail.com")).thenReturn(1);
		assertEquals(1, userServiceMock.insertVendorRequest(request, "abc@gmail.com"));
	}

	// Inserting Records in Db for Buyer Requests - US10
	@Test
	public void testInsertBuyerRequest() throws Exception {
		BuyerRequest request = new BuyerRequest(11, "abc@gmail.com", 500, 200, "pune", LocalDate.now(), LocalDate.now(),
				LocalDate.now(), "abc", 1010);
		when(userDaoMock.insertBuyerRequest(request, "abc@gmail.com", 200)).thenReturn(1);
		assertEquals(1, userServiceMock.insertBuyerRequest(request, "abc@gmail.com", 200));
	}

	// Fetching buyer requests from Db for a user - US14
	@Test
	public void testFetchRecords() throws Exception {
		List<BuyerRequest> records = new ArrayList<BuyerRequest>();
		BuyerRequest request = new BuyerRequest(11, "abc@gmail.com", 500, 200, "pune", LocalDate.now(), LocalDate.now(),
				LocalDate.now(), "abc", 1010);
		records.add(request);
		when(userDaoMock.fetchRecords("abc@gmail.com")).thenReturn(records);
		assertEquals(1, userServiceMock.fetchRecords("abc@gmail.com").size());
	}

	// Checking status of order for buyer - US12
	@Test
	public void testCheckStatus() throws Exception {

		when(userDaoMock.checkStatus(12)).thenReturn("Order Shipped");
		assertEquals("Order Shipped", userServiceMock.checkStatus(12));
	}

}
