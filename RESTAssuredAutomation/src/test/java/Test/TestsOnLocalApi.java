package Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestsOnLocalApi {
	
	
	//@Test
	public void get() {
		baseURI="http://localhost:3000";
		given().
		  get("/users").
		then().
		   statusCode(200).
		    log().all(); 
		
	}
	//@Test
	public void post() {
		
		JSONObject request=new JSONObject();
		request.put("FirstName", "Jyothsna");
		request.put("LastName", "Reddy");
		request.put("subjectid", "1");
		//System.out.println(request.toJSONString());
		baseURI="http://localhost:3000";
		given().
		    header("Content_Type","application/Json").
		    contentType(ContentType.JSON).accept(ContentType.JSON).
		    body(request.toJSONString()).
		when().
		    post("/user").
		then().
		   statusCode(201).
		   log().all();
	
		
	}
	@Test
	public void Put() {
		JSONObject response=new JSONObject();
		response.put("firstname", "jan");
		response.put("lastname", "Reddy");
		response.put("subjectid", "2");
		System.out.println(response.toJSONString());
		baseURI="http://localhost:3000";
				
		given().
		header("ContentType_Type","application/Json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
		put("/users/4").
		then().
		statusCode(200).
		log().all();
		
	}
	@Test
	public void Patch() {
		JSONObject response=new JSONObject();
		response.put("lastname", "Reddy");
		System.out.println(response.toJSONString());
		baseURI="http://localhost:3000";
				
		given().
		header("ContentType_Type","application/Json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
		patch("/users/4").
		then().
		statusCode(200).
		log().all();
		
	}
	@Test
	public void Delete() {
		
		baseURI="http://localhost:3000";

		when().
		delete("/users/4").
		then().
		statusCode(200).
		log().all();
}
}
