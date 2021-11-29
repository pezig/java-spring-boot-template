package com.zendesk.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.springboot.model.Forecast;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
    private ObjectMapper objectMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void getWeather() throws Exception {
        List<Forecast> list = new ArrayList<>();
        Forecast f = new Forecast();
        String summary = "The weather forecast is for Java and Angular!";
        f.setDate("1/1/2022");
        f.setSummary(summary);
        f.setTemperatureC(1.0);
        f.setTemperatureF(33.0);
        list.add(f);		
		final String expectedResponseContent = objectMapper.writeValueAsString(list);

		mvc.perform(MockMvcRequestBuilders.get("/weather").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getWeatherToday() throws Exception {
        Forecast f = new Forecast();
        String summary = "The weather forecast is for Java and Angular!";
        f.setDate("1/1/2022");
        f.setSummary(summary);
        f.setTemperatureC(1.0);
        f.setTemperatureF(33.0);
		final String expectedResponseContent = objectMapper.writeValueAsString(f);

		mvc.perform(MockMvcRequestBuilders.get("/weathertoday").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResponseContent));
	}



}