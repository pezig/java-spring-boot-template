package com.zendesk.springboot;
// package com.example.springboot;

// import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.ResponseEntity;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.util.List;

// import com.zendesk.springboot.model.Forecast;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class HelloControllerIT {

// 	@Autowired
// 	private TestRestTemplate template;

//     @Test
//     public void getHello() throws Exception {
//         ResponseEntity<String> response = template.getForEntity("/", String.class);
//         assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
//     }

//     // @Test
//     // public void getWeather() throws Exception {
//     //     ForecastList list = new ForecastList();
//     //     ResponseEntity<List<Forecast>> response = template.getForEntity("weather", list.getClass());
//     //     assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
//     // }

//     public class ForecastList {
//         public List<Forecast> list;

    
//         // standard constructor and getter/setter
//     }
// }
