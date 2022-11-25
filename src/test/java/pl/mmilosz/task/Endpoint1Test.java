package pl.mmilosz.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pl.mmilosz.task.endpoint1.StatusPingController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RestController.class)
@AutoConfigureMockMvc
@Slf4j
public class Endpoint1Test {
	
	@Autowired
	private StatusPingController controller;
	
	@Autowired
	private MockMvc mvc;
		
	@DisplayName("Controller is not null")
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@DisplayName("/status/ping is 200 and returns 'pong'")
	@Test
	void statusPing_shouldReturn200andPong() throws Exception {
		MvcResult mvcResult = mvc.perform(get("/status/ping")
				.contentType(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("pong")))
				.andReturn();
		
		String actualResponse = mvcResult.getResponse().getContentAsString();
		String expectedResponse = "pong";
		int statusCode = mvcResult.getResponse().getStatus();
		
		assertThat(actualResponse).isEqualTo(expectedResponse);
		
		log.debug("/status/ping ({}) - expected body was '{}', received '{}'",
				statusCode, expectedResponse, actualResponse);
	}
	
}
