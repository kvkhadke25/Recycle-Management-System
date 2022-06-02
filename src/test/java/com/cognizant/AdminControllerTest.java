
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

import com.cognizant.controller.AdminController;
import com.cognizant.dao.AdminDao;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.AdminService;

public class AdminControllerTest {
	private AdminService adminServiceMock;

	private AdminDao adminDaoMock = mock(AdminDao.class);

	private MockMvc mockMvcAdmin;

	@BeforeEach
	public void setup() {
		this.mockMvcAdmin = MockMvcBuilders.standaloneSetup(new AdminController()).build();
		adminServiceMock = new AdminService(adminDaoMock);
	}

	// Admin Home Page Testing
	@Test
	public void testAdminHomePage() throws Exception {
		this.mockMvcAdmin.perform(get("/adminHomePage")).andExpect(status().isOk()).andExpect(view().name("loginAdmin"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// US-1 Admin Authentication
	@Test
	public void testAdminValidateAdmin() throws Exception {
		when(adminDaoMock.validate("admin", "admin")).thenReturn(1);
		assertEquals(true, adminServiceMock.validateAdmin("admin", "admin"));
	}

	// US-9 Today's Requests
	@Test
	public void testAdminGetTodayRequests() throws Exception {
		VendorRequest r2 = new VendorRequest();
		r2.setAmount(1000);
		r2.setLocation("Delhi");
		r2.setRequestDate(LocalDate.parse("2020-11-10"));
		r2.setRequestId(12345);
		r2.setRequiredDate(LocalDate.parse("2020-10-30"));
		r2.setStatus("New");
		r2.setTime("09:10:11");
		r2.setTypeOfOrg("Hostel");
		r2.setVendorEmail("abc@gmail.com");
		List<VendorRequest> list1 = new ArrayList<VendorRequest>();
		list1.add(r2);
		when(adminDaoMock.getVendorRequestsForToday(LocalDate.parse("2020-11-10"))).thenReturn(list1);
		assertEquals(1, adminServiceMock.getTodayRequests(LocalDate.parse("2020-11-10")).size());
	}

	// US-9 Collections on a particular date
	@Test
	public void testAdminGetVendorCollectionsOnADate() throws Exception {
		VendorRequest r2 = new VendorRequest();
		r2.setAmount(1000);
		r2.setLocation("Delhi");
		r2.setRequestDate(LocalDate.parse("2020-10-10"));
		r2.setRequestId(12345);
		r2.setRequiredDate(LocalDate.parse("2020-10-30"));
		r2.setStatus("New");
		r2.setTime("09:10:11");
		r2.setTypeOfOrg("Hostel");
		r2.setVendorEmail("abc@gmail.com");
		List<VendorRequest> list1 = new ArrayList<VendorRequest>();
		list1.add(r2);
		when(adminDaoMock.getVendorCollections(LocalDate.parse("2020-10-30"))).thenReturn(list1);
		assertEquals(0, adminServiceMock.getCollections(LocalDate.parse("2020-10-10")).size());
	}

	// US-9 Collections Within a range of dates
	@Test
	public void testAdminGetVendorCollectionsBetweenTwoDates() throws Exception {
		VendorRequest r2 = new VendorRequest();
		r2.setAmount(1000);
		r2.setLocation("Delhi");
		r2.setRequestDate(LocalDate.parse("2020-10-10"));
		r2.setRequestId(12345);
		r2.setRequiredDate(LocalDate.parse("2020-10-30"));
		r2.setStatus("New");
		r2.setTime("09:10:11");
		r2.setTypeOfOrg("Hostel");
		r2.setVendorEmail("abc@gmail.com");
		List<VendorRequest> list1 = new ArrayList<VendorRequest>();
		list1.add(r2);
		when(adminDaoMock.getVendorCollectionsBetweenTwoDates(LocalDate.parse("2020-10-10"),
				LocalDate.parse("2020-10-30"))).thenReturn(list1);
		assertEquals(1, adminServiceMock
				.getVendorCollectionsBetweenTwoDates(LocalDate.parse("2020-10-10"), LocalDate.parse("2020-10-30"))
				.size());
	}

	// US-16 Buyer Report
	@Test
	public void testViewReportForBuyer() throws Exception {
		this.mockMvcAdmin.perform(get("/viewReportForBuyer")).andExpect(status().isOk())
				.andExpect(view().name("buyerReport")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	// US-15 Wastage Report
	@Test
	public void testWastageReport() throws Exception {
		this.mockMvcAdmin.perform(get("/wastageReport")).andExpect(status().isOk())
				.andExpect(view().name("wastageReportHome")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

}
