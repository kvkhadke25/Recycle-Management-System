package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.controller.ManagerController;
import com.cognizant.dao.ManagerDao;
import com.cognizant.model.Manager;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.ManagerService;

public class ManagerControllerTest {

	private ManagerService managerServiceMock;

	private ManagerDao managerDaoMock = mock(ManagerDao.class);

	private MockMvc mockMvcManager;

	@BeforeEach
	public void setup() {
		this.mockMvcManager = MockMvcBuilders.standaloneSetup(new ManagerController()).build();
		managerServiceMock = new ManagerService(managerDaoMock);
	}

	// Test Manager Home Page - US4 US5
	@Test
	public void testManagerHomePage() throws Exception {
		this.mockMvcManager.perform(get("/manager")).andExpect(status().isOk())
				.andExpect(view().name("managerLoginReg")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test Manager Edit Vendor Request - US8
	@Test
	public void testManagerEditStatus() throws Exception {
		this.mockMvcManager.perform(get("/editstatus")).andExpect(status().isOk())
				.andExpect(view().name("managerEditStatus")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test Manager Login Page - US5
	@Test
	public void testManagerLogin() throws Exception {
		this.mockMvcManager.perform(get("/loginmanager")).andExpect(status().isOk())
				.andExpect(view().name("managerLogin")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// Test Adding New Manager To Database - US4
	@Test
	public void saveManagerDetailsSuccess() {
		Manager manager = new Manager("Sam", "Nolan", "samnolan@gmail.com", "1234567890", "qwerty", "Male",
				"Skill1,Skill2", "");
		when(managerDaoMock.saveManager(manager)).thenReturn(1);
		assertEquals(managerServiceMock.saveManager(manager), 1);
	}

	// Test Adding Already Existing Manager To Database - US4
	@Test
	public void saveManagerDetailsFail() {
		// samlee@gmail.com already exists in database
		Manager manager = new Manager("Sam", "Lee", "samlee@gmail.com", "1234567890", "qwerty", "Male", "Skill1,Skill2",
				"");
		when(managerDaoMock.saveManager(manager)).thenReturn(0);
		assertEquals(managerServiceMock.saveManager(manager), 0);
	}

	// Test Existing Manager Approved by Admin Tries To Login - US5
	@Test
	public void testManagerCheckManagerCredentialsSuccess() throws Exception {
		when(managerDaoMock.checkManagerCredentials("am@gmail.com", "qwerty")).thenReturn(true);
		assertEquals(managerServiceMock.checkManagerCredentials("am@gmail.com", "qwerty"), true);
	}

	// Test Non Existing Manager Tries To Login - US5
	@Test
	public void testManagerCheckManagerCredentialsFail() throws Exception {
		when(managerDaoMock.checkManagerCredentials("abc@gmail.com", "123abc")).thenReturn(false);
		assertEquals(managerServiceMock.checkManagerCredentials("abc@gmail.com", "123abc"), false);
	}

	// Test Retrieve All Vendor Request From Database - US8
	@Test
	public void testGetVendorRequests() throws ParseException {
		String reqDate1 = "2020-12-12";
		String whenDate1 = "2020-12-24";
		LocalDate requestDate1 = LocalDate.parse(reqDate1);
		LocalDate requiredDate1 = LocalDate.parse(whenDate1);

		String reqDate2 = "2020-11-13";
		String whenDate2 = "2020-11-20";
		LocalDate requestDate2 = LocalDate.parse(reqDate2);
		LocalDate requiredDate2 = LocalDate.parse(whenDate2);

		VendorRequest vr1 = new VendorRequest(10, "vr1@gmail.com", "hostel", 20, "delhi", requestDate1, requiredDate1,
				"New", "12:00:00");
		VendorRequest vr2 = new VendorRequest(11, "vr2@gmail.com", "restaurant", 15, "delhi", requestDate2,
				requiredDate2, "New", "15:00:00");

		ArrayList<VendorRequest> list = new ArrayList<VendorRequest>();

		list.add(vr1);
		list.add(vr2);

		when(managerDaoMock.getVendorRequests()).thenReturn(list);
		assertEquals(managerServiceMock.getVendorRequests(), list);
	}

	// Test Manager Edit Existing Vendor Request Status - US8
	@Test
	public void testChangeStatusSuccess() {
		when(managerDaoMock.changeStatus(12, "Recieved")).thenReturn(1);
		assertEquals(managerServiceMock.changeStatus(12, "Recieved"), 1);
	}

	//// Test Manager Edit Non Existing Vendor Request Status - US8
	@Test
	public void testChangeStatusFail() {
		// Request id 15 does not exist
		when(managerDaoMock.changeStatus(15, "Recieved")).thenReturn(0);
		assertEquals(managerServiceMock.changeStatus(12, "Recieved"), 0);
	}

	// Test Retrieve All Manager Details From Database - US6
	@Test
	public void testGetManagerDetails() {
		Manager m1 = new Manager("abc", "xyz", "9876567987", "abc@gmail.com", "pass1", "skill1", "male", "No");
		Manager m2 = new Manager("dfg", "lnm", "9896754345", "dfg@gmail.com", "pass2", "skill2", "female", "Yes");

		ArrayList<Manager> lst = new ArrayList<Manager>();

		lst.add(m1);
		lst.add(m2);

		when(managerDaoMock.getManagerDetails()).thenReturn(lst);
		assertEquals(managerServiceMock.getManagerDetails(), lst);

	}

	// Test Admin Edit Existing Manager Approval Status - US6
	@Test
	public void testChangeApprovalSuccess() {
		when(managerDaoMock.changeApproval("am@gmail.com", "Yes")).thenReturn(1);
		assertEquals(managerServiceMock.changeManagerApproval("am@gmail.com", "Yes"), 1);
	}

	// Test Admin Edit Non Existing Manager Approval Status - US6
	@Test
	public void testChangeApprovalFail() {
		// ammm@gmail.com does not exist in database
		when(managerDaoMock.changeApproval("ammm@gmail.com", "Yes")).thenReturn(0);
		assertEquals(managerServiceMock.changeManagerApproval("am@gmail.com", "Yes"), 0);
	}

}
