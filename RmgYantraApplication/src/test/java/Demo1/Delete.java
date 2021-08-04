package Demo1;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Delete {
	
	@Test
	public void DeleteProject() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1005")
		.then()
		.log()
		.all()
		.assertThat().statusCode(204)
.assertThat().contentType(ContentType.JSON)	; 
	
		

	}

}
