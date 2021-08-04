package crudOperationWithHashmap;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class post {
	
	@Test
	public void CreatProjects() {
		HashMap map = new HashMap();
		map.put("createdBy", "Rini5");
		map.put("projectName", "hashmap");
		map.put("status", "Completed");
		map.put("teamSize", 12);
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
	}

}
