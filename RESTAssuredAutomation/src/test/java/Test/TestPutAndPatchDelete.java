package Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestPutAndPatchDelete {
@Test
	public void TestPUtData() {
		JSONObject request=new JSONObject();
		
		request.put("name", "Jyothsna");
		request.put("job", "manager");
		System.out.println(request.toJSONString());
		
		
		baseURI="https://reqres.in/api";
		given().
		   header("Content_type","application/Json").
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().
		   put("/users/2").
		then().
		   statusCode(200).
		   log().all();
	}
@Test
public void TestPatch() {
	
	JSONObject Responsedata=new JSONObject();
	Responsedata.put("name", "manisha");
	Responsedata.put("Job", "Developer");
	System.out.println(Responsedata.toJSONString());
	
	baseURI="https://reqres.in";
	given().
	header("Content_Type","application/json").
	contentType(ContentType.JSON).accept(ContentType.JSON).
	body(Responsedata.toJSONString()).
	when().
	patch("api/users/2").
	then().
	statusCode(200).
	log().all();
}

@Test
public void TestDelete() {
	baseURI="https://reqres.in";
	when().
	  delete("api/users/2").
	then().
	   statusCode(204).
	   log().all();
	
}
	
	
}
