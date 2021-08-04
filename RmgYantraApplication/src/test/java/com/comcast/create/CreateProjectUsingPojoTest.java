package com.comcast.create;

import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLiabrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojoTest {
	@Test
	public void createUsingPojo() {
		ProjectLiabrary projectLiabrary =new ProjectLiabrary("Tyss12", "PojoPOJO", "Completed", 10);
	given()
	.contentType(ContentType.JSON)
	.body(projectLiabrary)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.log()
	.all();
	
	
		
		
		
		
		
		
	}
 
}
