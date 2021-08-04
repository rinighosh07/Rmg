package crudOperationWithNormalMethod;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void CreateProject() {
		JSONObject jObject = new JSONObject();
		jObject.put("createdBy", "Rini");
		jObject.put("projectName", "Sdet-18");
		jObject.put("status", "Complete");
		jObject.put("teamSize", 100);
		RequestSpecification resSpec = RestAssured.given();
		resSpec.contentType(ContentType.JSON);
		resSpec.body(jObject);
		Response resp = resSpec.post("http://localhost:8084/addProject");
		resp.prettyPrint();
		Assert.assertEquals(resp.getStatusCode(), 201);
		
		
	}
	
	


}
