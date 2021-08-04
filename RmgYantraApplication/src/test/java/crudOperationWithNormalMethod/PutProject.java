package crudOperationWithNormalMethod;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutProject {
	@Test
	public void PutProject() {
		JSONObject jObject = new JSONObject();
		jObject.put("createdBy", "rini");
		jObject.put("projectName", "Board123");
		jObject.put("status", "Created");
		jObject.put("teamSize", 10);
		RequestSpecification resSpec =RestAssured.given();
		resSpec.contentType(ContentType.JSON);
		resSpec.body(jObject);
		Response resp = resSpec.put("http://localhost:8084/projects/TY_PROJ_1003");
		resp.prettyPrint();
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		
		
		
		
		
	}

}
