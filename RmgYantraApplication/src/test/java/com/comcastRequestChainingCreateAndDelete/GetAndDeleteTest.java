package com.comcastRequestChainingCreateAndDelete;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndDeleteTest {
	@Test
	public void getAndDelete() {
		baseURI = "http://localhost";
		port = 8084;
		 Response response = when()
				 .get("/projects");
			//capture any project id
		String firstProjectId = response.jsonPath().get("[0].projectId");
		System.out.println(firstProjectId);	
	
		JSONObject jObject = new JSONObject();
		jObject.put("createdBy", "RiniGho");
		jObject.put("projectName", "Demo1");
		jObject.put("status", "Completed");
		jObject.put("teamSize", 12);
		//delete that project
		given()
		
		.pathParam("ProjId", firstProjectId)
		.when()
		.delete("/projects/{ProjId}")
		.then()
		.assertThat().statusCode(204)
		.log()
		.all();
		
		
	}

}
