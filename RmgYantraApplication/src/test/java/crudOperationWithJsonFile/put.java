package crudOperationWithJsonFile;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;



public class put {
	@Test
	public void updateProjectOfJsonFile() {
		File file = new File("./Sample.json");
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
		.assertThat().statusCode(200);
		
		
		
	}
	


}
