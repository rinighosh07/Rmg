package com.comcast.RmgTestCase;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateEmployeeByJsonFile {
	@Test
	public void createEmp() {
		File file = new File ("./Sample.json");
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/employees")
		.then()
		.log()
		.all()
		.assertThat().statusCode(201);
	
		
	}
	

}
