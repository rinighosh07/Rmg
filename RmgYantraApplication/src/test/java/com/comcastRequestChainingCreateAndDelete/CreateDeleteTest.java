package com.comcastRequestChainingCreateAndDelete;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateDeleteTest {
	@Test
	public void createDelete() {
		baseURI = "http://localhost";
		port = 8084;
		String myProject = null;
	
		 HashMap map = new HashMap();
		map.put("createdBy", "RiniGhosh12");
		map.put("projectName", "Demo4");
		map.put("status", "Completed");
		map.put("teamSize", 17);

		Response response = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				//create the project
				.post("/addProject");                       

		//capture any project id for created project
		String myProj = response.jsonPath().get("projectId");
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
