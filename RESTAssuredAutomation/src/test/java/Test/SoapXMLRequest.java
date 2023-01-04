package Test;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class SoapXMLRequest {
	@Test

	public void validateSoapXML() throws IOException {
		File file= new File("./SoapRequest/add.xml");
		if(file.exists())
			System.out.println("  >>>> file exist");
		FileInputStream sourceFile= new FileInputStream(file);
		String Requestbody=IOUtils.toString(sourceFile, "UTF-8");
		
		baseURI="https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
		given().
		   contentType("txt/xml").
		   body(Requestbody).
		when().
		   post("/Calc.asmx").
		then().
		   statusCode(200).
		   log().all();
		
		
	}
	
	
	
	
	
}
