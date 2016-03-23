package com.ibm.rest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiTestApplication.class)
@Configuration
public class ApiTestApplicationTests {

	RestTemplate restTemplate = new TestRestTemplate();
	APIInfo apiInfo = null;
	

	@Test
	public void testApiAdd() {		
		apiInfo = new TestUtils().populateRestInputData("add");
		// --- Your additional code logic goes here
		// Read more properties from apiInfo.getApiProperties() and set them to restTemplate in apiInfo as you like
		
		ResponseEntity<String> response = new TestUtils().validateOutputResponse(restTemplate, apiInfo);		
		// --- Your additional assertions can go here
	}


	@Test
	public void testApiHello() {		
		apiInfo = new TestUtils().populateRestInputData("hello");
		// --- Your additional code logic goes here
		// Read more properties from apiInfo.getApiProperties() and set them to restTemplate in apiInfo as you like
		
		ResponseEntity<String> response = new TestUtils().validateOutputResponse(restTemplate, apiInfo);		
		// --- Your additional assertions can go here
	}

}
