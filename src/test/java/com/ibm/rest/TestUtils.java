package com.ibm.rest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestUtils {
	
	
	public APIInfo populateRestInputData(String API_NAME) {
		// Standard code to call REST API and compare TXT or JSON output
		String propertyFileName = API_NAME + ".properties";
		String propertyResturl = "rest.url";
		String propertyProduces = "rest.produces";
		
		APIInfo apiInfo = new APIInfo();
		Properties apiProperties = apiInfo.getApiProperties();
		apiInfo.setApiName(API_NAME);
		
		try {
			System.out.println("Reading properties file: " + propertyFileName);
			InputStream propertyFile = this.getClass().getResourceAsStream(propertyFileName);
			if(propertyFile == null) {
				Assert.fail("Test failed : " + "could not read properties file " + propertyFileName);
			}
			apiProperties.load(propertyFile);
			
			// Set the REST API URL
			apiInfo.setResturl(apiProperties.getProperty(propertyResturl));
			if(apiInfo.getResturl() == null) {
				Assert.fail("Test failed : " + "could not read property rest.url from " + propertyFileName);
			}
			
			// Set the output type TXT or JSON. Default is JSON
			String outputFileName = API_NAME + "_output.json";
			String restOutputType = apiProperties.getProperty(propertyProduces);
			if(restOutputType!= null && (restOutputType.toLowerCase().contains("txt") || restOutputType.toLowerCase().contains("text"))) {
				outputFileName = API_NAME + "_output.txt";
				apiInfo.setRestOutputType(APIInfo.TYPE_TXT);
			}		
			
			// Set the expected output
			String expected_output = IOUtils.toString(this.getClass().getResourceAsStream(outputFileName));
			if(expected_output == null) {
				Assert.fail("Test failed : " + "could not read expected output from " + outputFileName);
			}
			apiInfo.setExpectedOutput(expected_output);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Test failed : " + e.getMessage());
		}
		return apiInfo;
	}
	
	
	public ResponseEntity<String> validateOutputResponse(RestTemplate restTemplate, APIInfo apiInfo) {
		ResponseEntity<String> response = restTemplate.getForEntity(apiInfo.getResturl(), String.class);
		System.out.println(response);
		if(apiInfo.getRestOutputType().equalsIgnoreCase(APIInfo.TYPE_TXT)) {
			assertEquals(apiInfo.getExpectedOutput(), response.getBody());
		} else {
			JSONObject json = new JSONObject(response.getBody());
			System.out.println(json);
			JSONAssert.assertEquals(apiInfo.getExpectedOutput(), json, false);
		}
		return response;
	}


}
