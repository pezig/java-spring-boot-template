package com.zendesk.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zendesk.springboot.model.Forecast;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    @GetMapping("weather")
	public ResponseEntity<List<Forecast>> weather() {
        System.out.println("Returning weather forecast");
        List<Forecast> list = new ArrayList<>();
        Forecast f = new Forecast();
        String summary = "The weather forecast is for Java and Angular!";
        f.setDate("1/1/2022");
        f.setSummary(summary);
        f.setTemperatureC(1.0);
        f.setTemperatureF(33.0);
        list.add(f);
        return new ResponseEntity<>(list, HttpStatus.OK);
	}

}

