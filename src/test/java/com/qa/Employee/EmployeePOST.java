package com.qa.Employee;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeePOST {

	static Response response;
	
	@BeforeClass
	public void creatData() {

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("name", "AAAb4489uhuih74jbjh");
		json.put("salary", "12447623kjn433234");
		json.put("age", "2251324522");

		request.body(json.toString());

		response = request.post("http://dummy.restapiexample.com/api/v1/create");
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
		Assert.assertTrue(time<6000);
	}
	
	@Test
	public void contentTypeValidation() {
		String contentType=response.header("Content-Type");
		System.out.println("ContentType is "+contentType);
		Assert.assertEquals(contentType, "application/json");
	} 
	
}
