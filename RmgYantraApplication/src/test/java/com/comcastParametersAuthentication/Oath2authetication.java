package com.comcastParametersAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oath2authetication {
	
	@Test
	 public void oauth2coop() {
		//provide the client id and client secret to generate the token
		Response resp = given()
		.formParam("client_id", "Bulti")
		.formParam("client_secret", "43a1ad28516544812fdb37203f5d5650")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		// generate the token
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.asString());
		String myToken = resp.jsonPath().get("access_token");
		System.out.println(myToken);

		// use this token in any api
		given()
		.auth()
		.oauth2(myToken)
		.pathParam("USER_ID", "2115")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
		.log()
		.all();
		
		
		
		
		
	}

}
