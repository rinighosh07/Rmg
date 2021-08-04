package com.comcastParametersAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthAuthentication {
	@Test
	public void basicauth() {

		baseURI = "http://localhost";
		port= 8084;

		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then()
		.assertThat().statusCode(202)
		.log().all();		


	}

}
