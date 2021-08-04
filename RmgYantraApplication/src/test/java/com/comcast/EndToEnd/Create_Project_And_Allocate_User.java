package com.comcast.EndToEnd;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Create_Project_And_Allocate_User {
	@Test
	public void createProjAndAllocateUser() {
		baseURI = "http://localhost";
		port = 8084;
		
		//create body
		 HashMap map = new HashMap();
		 map.put("createdBy", "Rini860");
		 map.put("projectName", "airte560");
		 map.put("status", "Completed");
		 map.put("teamSize", 12);
		 // create project
		 given()
		 .contentType(ContentType.JSON)
		 .body(map)
		 .when()
		 .post("/addProject")
		 .then()
		 .log().all();
		 
		 //create body
		HashMap map1 = new HashMap();
		map1.put("designation", "SDET99");
		map1.put("dob", 25/06/1999);
		map1.put("email", "nitesh4@gmail.com");
		map1.put("empName", "nitesh3");
		map1.put("experience", 15);
		map1.put("mobileNo", "9888777657");
		map1.put("project", "abch7");
		map1.put("role", "ROLE_ADMIN");
		map1.put("username", "nitesh2");
		
		given()
		.contentType(ContentType.JSON)
		.body(map1)
		.when()
		//create empl
		.post("http://localhost:8084/employees")
		.then()
		.log()
		.all()
		.assertThat().statusCode(201);
		 
		
		
		
	}

}
