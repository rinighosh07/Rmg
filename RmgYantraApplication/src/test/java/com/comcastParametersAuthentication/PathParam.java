package com.comcastParametersAuthentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParam {


	@Test
	public void pathParameter() {

		baseURI = "http://localhost";
		port= 8084;

		given()
		.pathParam("ProjId", "TY_PROJ_1203")
		.when()
		.delete("/projects/{ProjId}")
		.then()
		//to get all response time from 200 - 500 series Matchers are used
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
		.log().all();		


	}

}
