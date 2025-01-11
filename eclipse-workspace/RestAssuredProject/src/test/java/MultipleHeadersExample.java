import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MultipleHeadersExample {
		  public static void main(String[] args) {
			  
			  
		    RestAssured.baseURI = "https://reqres.in/api/register/";
		    
		    RequestSpecification request = RestAssured.given()
		     	.header("Authorization", "BearerToken")
		     	.header("Content-Type", "application/json");

		    Response response = request.get("/users");

		    System.out.println(response.getStatusCode());
		  }
		}
	
//
//email": "eve.holt@reqres.in",
//"password": "pistol"