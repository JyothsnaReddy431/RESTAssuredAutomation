package Test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestExamples{
	@Test
	
	public void getmethod() {
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int Statuscode=response.getStatusCode();
		
		Assert.assertEquals(Statuscode, 200);
		
	}
	@Test
	public void GetMethod2() {
		baseURI="https://reqres.in";
		
		given().
		get("api/users?page=2").
		then().
		statusCode(200).
		
		body("data[1].id",equalTo(8))
		.log().all();
	}

}

	
	
		
		
		
		
		
		
		
		
		

	


 