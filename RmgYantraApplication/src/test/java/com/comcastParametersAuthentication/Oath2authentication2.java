package com.comcastParametersAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Oath2authentication2 {
	@Test
	public void oauth2() {
		//provide the client id and client secret to generate the token
		 Response resp = given()
		 .formParam("client_id", "Bulti1")
		 .formParam("client_secret", "18eac6f95189d299aa7a2b356724831c")
		 .formParam("grant_type", "client_credentials")
		 .formParam("redirect_uri", "http://example1.com")
		 
		 //generate the token
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		 System.out.println(resp.asString());
		 
		
		 
		
			
	}

}
