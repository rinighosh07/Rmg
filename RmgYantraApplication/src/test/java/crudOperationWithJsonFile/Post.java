package crudOperationWithJsonFile;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;



public class Post {
@Test
public void CreateProjUsinJsonFile() {
	File file = new File("./Sample.json");
	given()
	.contentType(ContentType.JSON)
	.body(file)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201);
	
	
	
}
}
