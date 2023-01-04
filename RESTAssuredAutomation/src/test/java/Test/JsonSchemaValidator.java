package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class JsonSchemaValidator {
@Test
	
public void TestGet() {
	baseURI="https://reqres.in/api";
	given().header("Content_type","application/Json").
	contentType(ContentType.JSON).accept(ContentType.JSON).
	   get("/users?page=2").
	then().
	assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
	statusCode(200);
	
		
	}
}
