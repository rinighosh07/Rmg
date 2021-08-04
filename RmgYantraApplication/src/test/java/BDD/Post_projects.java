package BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Post_projects {
	
	
	@Test
	public void CreateProject() {
		JSONObject jObject = new JSONObject();
		jObject.put("createdBy", "Rini122");
		jObject.put("projectName", "Abc");
		jObject.put("status", "Completed");
		jObject.put("teamSize", 50);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		
		
		
		
	}
	

}
