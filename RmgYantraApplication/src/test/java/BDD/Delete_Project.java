package BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Delete_Project {
	
	@Test
	public void delete_Project() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1003")
		.then()
		.log()
		.all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
		
	}

}
