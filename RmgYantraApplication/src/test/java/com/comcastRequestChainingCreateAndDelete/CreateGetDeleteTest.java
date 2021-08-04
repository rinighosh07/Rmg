package com.comcastRequestChainingCreateAndDelete;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateGetDeleteTest {
	@Test
	public void createGetDelete() {
		baseURI = "http://localhost";
		port = 8084;
		Response response = when()
				.get("/projects");
	
		 HashMap map = new HashMap();
		map.put("createdBy", "RiniGhosh12");
		map.put("projectName", "Demo4");
		map.put("status", "Completed");
		map.put("teamSize", 17);

		Response response1 = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				
				.post("/addProject");                       

		//capture any project id for created project
		String myProj = response1.jsonPath().get("projectId");
		System.out.println(myProj);
		//delete that project created by project id
				given()
				.pathParam("projId",myProj )
				.when()
				.delete("/projects/{projId}")
				.then()
				.log()
				.all()
				.assertThat().statusCode(204);
}
}
