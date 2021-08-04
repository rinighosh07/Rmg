package com.comcast.ComplexData;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class ValidateStaticResponseTest {
	@Test
	public void staticResponse() {
		//expected data initialization
		String expectedData= "Rini1";
		//getting the resource from the server
		Response response= when()
				.get("http://localhost:8084/projects");
		// verification of status code
		response.then().statusCode(200)
		.log()
		.all();
		//capture the specific data from response body
		String actualData = response.jsonPath().get("[0].projectName");
		System.out.println("expected data is : " +expectedData);
		System.out.println("actual data is : " +actualData);
		//testng assertion for actual and excepted data
		Assert.assertEquals(actualData, expectedData);

	}

}
