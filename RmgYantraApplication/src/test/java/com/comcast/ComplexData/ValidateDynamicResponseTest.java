package com.comcast.ComplexData;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class ValidateDynamicResponseTest {
	@Test
	public void dynamicResponse() {

		String expectedData = "Rini1";
		String actualData = null;
		Response response = when()
				.get("http://localhost:8084/projects");
		response.then().statusCode(200)
		.log()
		.all();
		List<String> list = response.jsonPath().get("createdBy");
		boolean flag = false;
		for(String data:list) {
			if(data.equals(expectedData)) {
				actualData= data;
				flag=true;
				//System.out.println("value is present :"+actualData);
				break;	
			}
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(actualData, expectedData);

	}

}














