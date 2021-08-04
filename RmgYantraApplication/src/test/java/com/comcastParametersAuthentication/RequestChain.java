package com.comcastParametersAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class RequestChain {
	@Test
	public void requestChaining() {
		baseURI = "http://localhost";
		port = 8084;
		
		 Response response = when()
				.get("/projects");
		//capture any project id
		String firstProjectId = response.jsonPath().get("[0].projectId");
		System.out.println(firstProjectId);				
		//delete that project
		given()
		.pathParam("ProjId", firstProjectId)
		.when()
		.delete("/projects/{ProjId}") 
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
		
	}

}
