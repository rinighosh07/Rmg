package com.ty.Rmg.Projects;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class GetAllProjectsDeleteAndGetconnFromDBAndExecuteQuerry {
	@Test
	public void getAllProjectsDeleteAndGetconnFromDBAndExecuteQuerry() throws SQLException {
		baseURI = "http://localhost";
		port = 8084;
		//expected data initialization
		String expData = "Rita";
		//getting the resource from the server
		Response response = when()
				.get("/projects");
				response.then().statusCode(200)
				.log().all();
		// capture the project id 
		String firstProjectId = response.jsonPath().get("[0].projectId");
		System.out.println("firstProjectId");
		
		Driver driver = new Driver();
		
		
	}

}
