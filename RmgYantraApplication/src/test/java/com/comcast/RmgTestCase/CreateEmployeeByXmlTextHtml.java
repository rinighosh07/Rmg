package com.comcast.RmgTestCase;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateEmployeeByXmlTextHtml {
	@Test
	public void createEmp(){
		JSONObject jObject =new JSONObject();
		jObject.put("designation", "QA4");
		jObject.put("dob", "01/11/1111");
		jObject.put("email", "john123@gmail.com");
		
		jObject.put("empName", "john4");
		jObject.put("experience", 2);
		jObject.put("mobileNo", "1234567890");
	
		jObject.put("project", "rmg4");
		jObject.put("role", "QA");
		jObject.put("username", "john4");
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.when()
		.post("http://localhost:8084/employees")
		.then()
		.log()
		.all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
	}

		

}
