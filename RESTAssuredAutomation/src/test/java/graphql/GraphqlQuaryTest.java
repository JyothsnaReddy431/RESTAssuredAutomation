package graphql;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class GraphqlQuaryTest {

	@Test
	
	
	public void getallFilimsTest(){
		baseURI="";
		
		given().relaxedHTTPSValidation().log().all();
		
		
	}
	
	
	
}
