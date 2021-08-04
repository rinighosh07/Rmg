package BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_Project {
	
	@Test
	public void getAllProjects(){
when()
.get("http://localhost:8084/projects")
.then()
.log().all()
.and()
.assertThat().statusCode(200)
.and()
.assertThat().contentType(ContentType.JSON);

	
	
		
		

	
		
		
	}

}
