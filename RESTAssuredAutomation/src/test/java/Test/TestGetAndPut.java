package Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class TestGetAndPut {
	
	
	//@Test
	
	public void TestGet() {
		baseURI="https://reqres.in/api";
		given().
		   get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name",equalTo("George"));
		//body("data.first_name",hasitems("George","Rachel"));
	
	}
//@Test
	public void Testpost() {
	
	//Map<String,Object> map=new HashMap<String,Object>();
	//map.put("name", "Jyothsna");
	//map.put("job", "software");
	//System.out.println(map);
	
	JSONObject requst=new JSONObject();
	requst.put("name", "Jyothsna");
	requst.put("job", "software");
	System.out.println(requst.toJSONString());
	
	baseURI="https://reqres.in/api";
	given().
	   header("Content_Type","application/Json").
	   contentType(ContentType.JSON).
	   accept(ContentType.JSON).
	   body(requst.toJSONString()).
	when().
	   post("/users").
	then().
	   statusCode(201).
	   log().all();
	
}
@Test
public void TestPostmethod() {
	JSONObject response=new JSONObject();
	response.put("Email", "Jyothsna123@gmail.com");
	response.put("Password", "Tester");
	
	System.out.println(response.toJSONString());
	
	baseURI="https://reqres.in/api";
	given().header("Content_Type","application/Json").
	contentType(ContentType.JSON).
	accept(ContentType.JSON).
	body(response.toJSONString()).
	when().
	post("/register").
	then().
	statusCode(201).
	log().all();
	
	
	
	
	
	
	}
	
}
