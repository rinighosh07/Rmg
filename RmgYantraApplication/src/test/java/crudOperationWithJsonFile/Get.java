package crudOperationWithJsonFile;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class Get {
	@Test
	public void GetTheProjectFromJsonFile() {
	given()
	.get("./Sample.json")
	.then()
	.log()
	.all()
	.assertThat().statusCode(200);
	
		
	}

}
