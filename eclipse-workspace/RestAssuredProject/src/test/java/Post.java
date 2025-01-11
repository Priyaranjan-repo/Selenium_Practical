import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;




public class Post {
	
 
	
	@Test(enabled = false)
	public void test03() {
		
	JSONObject jsonData = new JSONObject();
	
	jsonData.put("name", "akash");
	jsonData.put("job", "Lead");
	  RestAssured.baseURI="https://reqres.in/api/users";
	RestAssured.given().header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString())
	.when().post()
	.then()
	.statusCode(201).log().all();


	}
	@Test(enabled = false)
	public void patchMethod() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Ranjan");
		jsonData.put("job", "Enginner");
		
		RestAssured.baseURI="https://reqres.in/api/users/51";
		RestAssured.given().header("Content-type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when()
           .patch()
		.then()
		     .statusCode(200)
		     .log().all();

	}
	@Test
	public void deleteMethod() {

		
		RestAssured.baseURI="https://reqres.in/api/users/51";
		RestAssured.given()
		.when()
           .delete()
		.then()
		     .statusCode(204)
		     .log().all();

}
}
//204 No Content