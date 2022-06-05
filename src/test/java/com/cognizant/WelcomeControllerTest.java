package com.cognizant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.controller.WelcomeController;

public class WelcomeControllerTest {

	private MockMvc mockMvcWelcome;

	@BeforeEach
	public void setup() {
		this.mockMvcWelcome = MockMvcBuilders.standaloneSetup(new WelcomeController()).build();
	}

	// Test App Home Page
	@Test
	public void testAppHomePage() throws Exception {
		this.mockMvcWelcome.perform(get("/recycleManagementHomePage")).andExpect(status().isOk())
				.andExpect(view().name("homePage")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

}
