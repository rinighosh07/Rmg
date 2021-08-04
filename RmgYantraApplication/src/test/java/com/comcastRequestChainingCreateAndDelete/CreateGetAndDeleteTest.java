package com.comcastRequestChainingCreateAndDelete;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class CreateGetAndDeleteTest {
	@Test
	public void createGetDelete() {
		baseURI = "http://localhost";
		port = 8084;
		String path = null;
	
		 HashMap map = new HashMap();
		map.put("createdBy", "RiniGhosh18");
		map.put("projectName", "Demo4");
		map.put("status", "Completed");
		map.put("teamSize", 17);

		Response resp = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				//create the project
				.post("/addProject");   
		resp.then()
		.statusCode(201);

		//capture any project id for created project
		String myProj = resp.jsonPath().get("projectId");
		System.out.println(myProj);
		//get all project along with created project
		Response  response1= when()
				.get("/projects");
		//capture all the project id's
		List <String> list = response1.jsonPath().get("projectId");
		String expectedpath = myProj;
		for(String data : list)
		{
			if(data.equals(expectedpath))
			{
				path = data;
			
				
				break;
			}
		}

		//delete that project created by project id
		given()
		.pathParam("projectId",myProj )
		.when()
		.delete("/projects/{projectId}")
		.then()
		.log()
		.all()
		.assertThat().statusCode(204);




	}

}
