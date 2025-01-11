package com.restAssureddemo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateJson {

	@Test
	public void getPost() {

		String json = "'{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"dog\"\r\n" + "  },\r\n" + "  \"name\": \"cat\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n"
				+ "}'";
		System.out.println(json);

		RestAssured.baseURI = "https://petstore.swagger.io/";

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(json).when().get("v2/pet/findByStatus?status=available");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

		response.then().body("category.id", equals("dog")).body("category.name", equals("cat"))
				.body("tags[0].id", equals(0)).body("tags[0].id", equals("string")).and()
				.body("status", equals("available"));

	}

}
