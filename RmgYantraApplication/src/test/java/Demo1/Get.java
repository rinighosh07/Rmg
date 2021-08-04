package Demo1;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get {
	
	@Test 
	public void getAllProjects() {
JSONObject jObject = new JSONObject();
when()
.get("http://localhost:8084/projects")
.then()
.log()
.all()
.assertThat().statusCode(200)
.assertThat().contentType(ContentType.JSON);

	}
	
	

}
