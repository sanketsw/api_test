package com.ibm.rest;

import java.util.Properties;

public class APIInfo {
	
	public static final String TYPE_TXT = "TXT";
	public static final String TYPE_JSON = "JSON";
	
	private String apiName = null;
	private String resturl = null;;
	private String restOutputType = TYPE_JSON;
	private String expectedOutput = null;
	private Properties apiProperties = new Properties();
	/**
	 * @return the apiName
	 */
	public String getApiName() {
		return apiName;
	}
	/**
	 * @param apiName the apiName to set
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	/**
	 * @return the resturl
	 */
	public String getResturl() {
		return resturl;
	}
	/**
	 * @param resturl the resturl to set
	 */
	public void setResturl(String resturl) {
		this.resturl = resturl;
	}
	/**
	 * @return the restOutputType
	 */
	public String getRestOutputType() {
		return restOutputType;
	}
	/**
	 * @param restOutputType the restOutputType to set
	 */
	public void setRestOutputType(String restOutputType) {
		this.restOutputType = restOutputType;
	}
	/**
	 * @return the expectedOutput
	 */
	public String getExpectedOutput() {
		return expectedOutput;
	}
	/**
	 * @param expectedOutput the expectedOutput to set
	 */
	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}
	/**
	 * @return the apiProperties
	 */
	public Properties getApiProperties() {
		return apiProperties;
	}
	/**
	 * @param apiProperties the apiProperties to set
	 */
	public void setApiProperties(Properties apiProperties) {
		this.apiProperties = apiProperties;
	}
	
	

}
