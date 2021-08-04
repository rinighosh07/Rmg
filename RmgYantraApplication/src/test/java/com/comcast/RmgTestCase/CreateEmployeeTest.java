package com.comcast.RmgTestCase;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateEmployeeTest {
	@Test
	public void createEmployee() {
	HashMap map = new HashMap();
		
	map.put("designation", "payal");
	map.put("dob", "01/11/1111");
	map.put("email", "paul@gmail.com");
	map.put("empId", "123");
	map.put("empName", "payal1");
	map.put("experience", 2);
	map.put("mobileNo", "1234567890");
	map.put("password", "paul@1");
	map.put("project", "rmg6");
	map.put("role", "QA");
	map.put("username", "john9h");
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/employees")
		.then()
		.log()
		.all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
				
				
			
		
		
		
		
	}

}
