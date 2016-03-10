# Netflix_Eureka_Client_HelloWorld

## Running on bluemix
`cf push <app_name> -p target/helloworld-0.0.1-SNAPSHOT.war`

Note the Eureka Server URL in application.yml file: serviceUrl: defaultZone: `http://eurekaregistry.mybluemix.net/eureka/`
Change to right server or take it from an environment variable from bluemix

Go to Eureka server: `http://eurekaregistry.mybluemix.net` and verify that your service is registered there

Run `<app_name>.mybluemix.net`

## What does HelloWorld client do

It prints the instance IP and port of the Hellow World. somehting like Hello World: helloWorld6:169.45.162.108:61841

## How to call this API from another API

If you have more than one instances , you can see load balancer in action when another micro service (consumer) calls this api and see the instance ip and port changed on subsequent refresh of consumer call of `<app_name>.mybluemix.net`

Refer to https://github.com/sanketsw/Netflix_Eureka_Client_Consumer for more details on how to consume this API using feign client
