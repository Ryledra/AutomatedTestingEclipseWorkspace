package com.qa.SwaggerPersonExample;

import static org.junit.Assert.*;

import org.junit.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class SwaggerPersonTests {
	
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Ignore
	@Test
	public void putAddTest()	{
		
		RestAssured.baseURI = Constants.URL;
		
		JSONObject address = new JSONObject();
		
		address.put("city", "Manchester");
		address.put("id", 0);
		address.put("line1", "9 Hello World");
		address.put("line2", "World Street");
		address.put("state", "Greater Manchester");
		address.put("zip", "M50 5WW");
		
		JSONArray addresses = new JSONArray();
		
		addresses.put(address);
		
//		JSONObject gender = new JSONObject();
//		gender.put("gender", "M");
//		gender.put("sexuality", "Hetro");
		
		JSONObject params = new JSONObject();
		
		params.put("addresses", addresses);
		params.put("dateOfBirth", "2018-09-25T11:06:38.537Z");
		params.put("firstName", "Bob");
		params.put("gender", "M");
		params.put("id", 0);
		params.put("lastName", "Bobson");
		params.put("middleName", "Robert");
		
		System.out.println(params.toString());
		
		request = given().body(params.toString()).
				header("Content-Type", "application/json").header("userId", "00000000");
		response = request.when().put("/");
		json = response.then().statusCode(200);
	}
	
	@Ignore
	@Test
	public void putUpdateTest()	{
		fail();
		
	}

	//@Ignore
	@Test
	public void getSingleTest()	{
		json = given().header("Content-Type", "application/json").
				when().get(Constants.URL+"/1").
				then().statusCode(200);
		
	}

	//@Ignore
	@Test
	public void getAllTest()	{
		json = given().header("Content-Type", "application/json").
				when().get(Constants.URL+"s?size=10&page=0").
				then().statusCode(200);
	}

}
