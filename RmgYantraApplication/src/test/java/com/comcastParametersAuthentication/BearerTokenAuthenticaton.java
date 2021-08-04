package com.comcastParametersAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerTokenAuthenticaton {
	@Test
	public void bearerToken() {
		HashMap map = new HashMap();
		map.put("name", "Rini22");
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when().post("https://api.github.com/user/repos").then()
		.log()
		.all()
		.assertThat().statusCode(201);

	}

}
