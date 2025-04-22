package com.restAssureddemo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getDetaiils {

	@Test(enabled = false)

	public void getPet() {

		// "https://petstore.swagger.io/";

		RestAssured.baseURI = "https://petstore.swagger.io/";

		Response response = given().header("accept", "application/xml").when()
				.get("v2/pet/findByStatus?status=available");

		// System.out.println(response.asString());
		System.out.println(response.prettyPrint());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

	}

	@Test(enabled = false)
	public void getPost() {

		String json = "'{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n"
				+ "}'";
		System.out.println(json);

		RestAssured.baseURI = "https://petstore.swagger.io/";

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(json).when().post("v2/pet");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

	}

	@Test(enabled = false)
	public void putPets() {

		String json = "{\r\n" + "  \"id\": 9223372016900020000,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}";
		System.out.println(json);

		RestAssured.baseURI = "https://petstore.swagger.io/";

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(json).when().put("v2/pet");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

	}

	@Test(enabled = false)
	public void delete_Pet() {

		String json = "{\r\n" + "  \"id\": 9223372016900020000,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}";
		System.out.println(json);

		RestAssured.baseURI = "https://petstore.swagger.io/";

		Response response = given().header("accept", "application/json").when().delete("v2/pet/9223372016900020000");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

	}

	@Test
	public void postUpdate() {

		String json = "'{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n"
				+ "}'";
		System.out.println(json);

		RestAssured.baseURI = "https://petstore.swagger.io/";

		Response response = given().header("accept", "application/json").header("Content-Type", "multipart/form-data")
				// .formParam("additionalMetadata", "where")
				.formParam("file", "@download.jpg").formParam("type", "image/jpeg").when()
				.post("v2/pet/9223372016900020000/uploadImage");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

	}
}
