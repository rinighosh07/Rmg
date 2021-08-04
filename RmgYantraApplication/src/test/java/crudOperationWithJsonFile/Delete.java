package crudOperationWithJsonFile;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Delete {
	@Test
	public void deleteProjectUsingJsonFile() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
		.log()
		.all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
		
	}

}
