package com.restAssureddemo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class CheckValidResponse {

	@Test(enabled = false)
	public void getSingleUser() {

		// RestAssured.baseURI="//reqres.in/api/users/2";

		// RequestSpecification reqSpec = RestAssured.given();

		// Response res = reqSpec.get();

//		int statusCode= res.getStatusCode();
//		
//		//validate 
//		Assert.assertEquals(statusCode/* actual status code*/,200 );
//		
//		String statusLine = res.statusLine();
//		Assert.assertEquals(statusLine, 200);
//	}

	}

	@Test
	public void get_BDDStyle() {

		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).statusLine("HTTP/1.1 200 OK");

	}
}
