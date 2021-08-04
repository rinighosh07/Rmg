package BDD;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Put {
	@Test
	public void updateProject() {
		JSONObject jObject = new JSONObject();
		jObject.put("createdBy", "rini12");
		jObject.put("projectName", "TYSS782");
		jObject.put("status", "Created");
		jObject.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1005")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.assertThat().contentType(ContentType.JSON);
		
		
	}

}





