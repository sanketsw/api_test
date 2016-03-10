# Java  SpringBoot REST API

## Build and run on localhost
maven build with goals : `clean package`: generates target/helloworld2-0.0.1-SNAPSHOT.war

Right click on HelloworldApplication.java in eclipse - Run as Java Application

## How to execute the REST API
- `http://localhost:12001/hello` : Generate plain text result: Hello World from Java_SpringBoot
- `http://localhost:12001/operate/add/51/56` : Generate JSON object result: {"imeplementation": "Java_SpringBoot", "result": "107"}

## Running on IBM Bluemix
`cf push api-springboot -p target/helloworld2-0.0.1-SNAPSHOT.war`

The REST API URL on Bleumix then becomes 
- http://api-springboot.mybluemix.net/hello
- http://api-springboot.mybluemix.net/operate/add/51/56

## Swagger Integration

Run `http://localhost:12001/swagger-ui.html#/` 
or http://api-springboot.mybluemix.net/swagger-ui.html on bluemix

Swagger.json file: `http://localhost:12001/v2/api-docs?group=springboot`
 
Reference document for swagger integration: http://heidloff.net/article/usage-of-swagger-2-0-in-spring-boot-applications-to-document-apis/
