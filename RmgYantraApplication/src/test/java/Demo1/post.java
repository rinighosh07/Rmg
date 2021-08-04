package Demo1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class post {
	
	@Test
	public void CreateSingleProject() {
JSONObject jObject = new JSONObject();
jObject.put("createdBy", "rini23");
jObject.put("projectName", "abcd");
jObject.put("status", "rini23");
jObject.put("teamSize", 12);
given()
.contentType(ContentType.JSON)
.body(jObject)
.when()
.post("http://localhost:8084/addProject")
.then()
.log()
.all()
.assertThat().statusCode(201)
.assertThat().contentType(ContentType.JSON);



		
	}
	

}
