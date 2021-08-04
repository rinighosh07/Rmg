package com.comcastParametersAuthentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class QueryParam {

	@Test
	public void queryParam() {

		baseURI = "https://reqres.in/";
		given()
		.queryParam("page", 2)
		.when()
		.get("/api/users")
		.then()
		//to get all response time from 200 - 500 series Matchers are used
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
		.log().all();	

	}

}
