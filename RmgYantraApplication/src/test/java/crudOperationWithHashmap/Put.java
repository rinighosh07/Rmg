package crudOperationWithHashmap;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Put {
	@Test
	public void UpdateProjects() {
		HashMap map = new HashMap();
		map.put("createdBy", "rini12");
		map.put("projectName", "Hashmapp");
		map.put("status", "Completed");
		map.put("teamSize", 134);
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
		.log()
		.all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	
		 
	}

}
