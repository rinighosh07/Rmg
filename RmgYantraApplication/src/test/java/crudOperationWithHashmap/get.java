package crudOperationWithHashmap;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class get {
	
	@Test
	public void GetProject() {
		
		HashMap map = new HashMap();
		when()
		.get("http://localhost:8084/projects")
		.then()
		.log()
		.all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
		
		
		
		

	
		
		
	}

}
