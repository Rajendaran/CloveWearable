package com.clovewearable.cove.rest.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.clovewearable.cove.model.User;

/**
 * @author Rajendaran
 *
 */
public class RestClientTest {
	
	public void createUser() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/createuser";
		User user = new User();
		user.setName("Rajendaran");
		user.setEmail("rajendren@gmail.com");
		user.setPincode("123456");
		HttpEntity<User> requestEntity = new HttpEntity<User>(user, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());

	}
	 
}
