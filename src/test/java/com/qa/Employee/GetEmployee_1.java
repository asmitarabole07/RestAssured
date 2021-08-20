package com.qa.Employee;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetEmployee_1 {
	
	static Response response;
	
	@BeforeMethod
	public void setUp() {
		
		response=RestAssured.get("http://dummy.restapiexample.com/api/v1/employee/1");
	}
	
	@Test
	public void responseBodyValidation() {
		
		String body=response.getBody().asString();
		System.out.println(body);
		Assert.assertTrue(body!=null);
	}
	
	@Test
	public void StatusCodeValidation() {
		
		int statusCode=response.getStatusCode();
		System.out.println("status code "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void responseTimeValidation() {
		long time=response.getTime();
		System.out.println("response time "+time);
		Assert.assertTrue(time<2000);
	}
	
	@Test
	public void contentTypeValidation() {
		String contentType=response.header("Content-Type");
		System.out.println("ContentType is "+contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	} 
}
