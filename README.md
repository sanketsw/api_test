# REST API Test Suite
REST API Integration tests in Junit. Validates the expected output JSON file against the JSON reponse of the live REST API using jsonassert. Also tests the REST API that return plain text output.

## Build and run on localhost
maven build with goals : `clean package`: generates target/api_test-0.0.1-SNAPSHOT.war (Runs the Junit Test Cases as part of the build process)

To run the test cases: right click on the test case and run as Junit Test Case

## Running on IBM Bluemix
`cf push api-test-sanket -p target/api_test-0.0.1-SNAPSHOT.war`
Bluemix app: http://api-test-sanket.mybluemix.net

## How to write new testcase
- Determine a label for your REST API e.g. getData
- create two files -  getData.properties and getData_output.JSON in src/test/resources/com/ibm/rest
- Specify rest URL and expected output format in getData.properties
```
    rest.url=http://api-springboot.mybluemix.net/operate/add/51/56
    rest.produces=JSON
```
- Paste the expected output JSON in getData_output.JSON
`{"result":"107","imeplementation":"Java_SpringBoot"}`

- Create a Junit Test Case in ApiTestApplicationTests.java in src/test/java/com/ibm/rest
```
	@Test
	public void testApiGetData() {		
		apiInfo = new TestUtils().populateRestInputData("getData");
		// --- Your additional code logic goes here
		// Read more properties from apiInfo.getApiProperties() and set them to restTemplate in apiInfo as you like
		
		ResponseEntity<String> response = new TestUtils().validateOutputResponse(restTemplate, apiInfo);		
		// --- Your additional assertions can go here
	}
```
All you need to do is pass `getData` as an argument here. That will tell the test case where to read properties and output files from. Everything else is just copied and pasted. 

- Done. Right click on the test case and run as Junit Test


**For the REST API with Plain Text Output**

- The ouptut file name will be *.txt:  `getData_output.txt` instead of *.json in src/test/resources/com/ibm/rest
- rest.produces in getData.properties will be TXT or TEXT in stead of JSON
```
    rest.url=http://api-springboot.mybluemix.net/hello
    rest.produces=TXT
```
- Paste the expected output Text in getData_output.txt as plain text
`Hello World from Java_SpringBoot`
