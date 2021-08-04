package crudOperationWithHashmap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Delete {
	@Test
	public void DeleteProject() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1006")
		.then()
		.log()
		.all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
		
	}

}
