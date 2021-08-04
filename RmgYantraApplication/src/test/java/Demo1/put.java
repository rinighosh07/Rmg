package Demo1;

import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class put {
	
	@Test
	public void UpdateProject() {
		JSONObject jObject = new JSONObject();
		jObject.put("createdBy", "rini234");
		jObject.put("projectName", "abcde");
		jObject.put("status", "Completed");
		jObject.put("teamSize", 19);
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1005")
		.then()
		.log()
		.all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	
	}

}
