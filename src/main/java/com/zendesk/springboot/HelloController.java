package com.zendesk.springboot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zendesk.springboot.model.Forecast;
import com.zendesk.springboot.services.HttpRequests;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public static void main(String[] args){
        HelloController hello = new HelloController();
        System.out.println(hello.dummyPOST());
    }

	@GetMapping("/")
	public String index() {
		return "Hello World!";
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

    @GetMapping("weathertoday")
	public ResponseEntity<Forecast> weatherToday() {
        System.out.println("Returning weather forecast");
        Forecast f = new Forecast();
        String summary = "The weather forecast is for Java and Angular!";
        f.setDate("1/1/2022");
        f.setSummary(summary);
        f.setTemperatureC(1.0);
        f.setTemperatureF(33.0);
        return new ResponseEntity<>(f, HttpStatus.OK);
	}

    @PostMapping("dummyPOST")
    public ResponseEntity<String> dummyPOST() {
        try{
            Map<String, String> map = new HashMap<>();
            map.put("body", "bar");
            map.put("id", "1");
            map.put("title", "foo");
            String response = HttpRequests.sendPOST("https://jsonplaceholder.typicode.com/posts", map);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("An error occured", HttpStatus.BAD_REQUEST);
        }
    }

}

