package Test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestExamplesPractice {
	
	
	@Test
	public void GetSingleUser(){
		baseURI="https://reqres.in/";
		given().
		get("api/users/2")
		.then().
		statusCode(200).
		body("data.id",equalTo(2)).
		log().
		all();
		
	}
	@Test
	
	public void SingleUserNotFound() {
		baseURI="https://reqres.in/";
		given().
		get("api/users/23").
		then().
		statusCode(404);
		
	}
	@Test
	public void ListUsers() {
		baseURI="https://reqres.in/";
		
		given().
		   get("api/unknown").
		then().
		  statusCode(200).
		body("data[3].id",equalTo(4)).
		log().
		all();
		
		
		
	}
	
	
	
	
	
	

}
