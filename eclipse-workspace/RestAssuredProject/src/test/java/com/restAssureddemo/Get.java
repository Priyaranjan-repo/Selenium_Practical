package com.restAssureddemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {

	@Test
	public void getRequest() {

		String url = "https://reqres.in/api/register";

		RequestSpecification http_req = RestAssured.given();

		Response response = http_req.get(url);

		int statusCode = response.getStatusCode();

		System.out.println("status code  ---------:" + statusCode);

		System.out.println("response body---------:" + response.body().asString());

		System.out.println("status code  ---------:" + response.statusLine());
	}

//
//email": "eve.holt@reqres.in",
//"password": "pistol"

	@Test
	public void testO2() {

		RestAssured.baseURI = "https://reqres.in/api/users";

		RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);

	}
}