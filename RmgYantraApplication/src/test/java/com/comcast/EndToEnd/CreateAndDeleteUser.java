package com.comcast.EndToEnd;


	

	import static io.restassured.RestAssured.*;

	import java.util.HashMap;

	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;
import io.restassured.response.Response;

	public class CreateAndDeleteUser {
		@Test
		public void createProjAndAllocateUser() {
			baseURI = "http://localhost";
			port = 8084;
	
			 //create body
			HashMap map = new HashMap();
			map.put("designation", "SDET891");
			map.put("dob", 25/06/1999);
			map.put("email", "nitesh@gmail.com");
			map.put("empName", "nitesh3");
			map.put("experience", 15);
			map.put("mobileNo", "9888777657");
			map.put("project", "abc");
			map.put("role", "ROLE_ADMIN");
			map.put("username", "niteshM");
			
		Response response = given()
			.contentType(ContentType.JSON)
			.body(map)
			.when()
			//create empl
			.post("/employees");
		response.then()
			.log()
			.all();
		//jsonpath
		String path = response.jsonPath().get("employeeId");
		System.out.println(path);
given()
.pathParam("Emp_Id", path)
.when()
.get("/employees/{Emp_Id}")
.then().log().all()
		.assertThat().statusCode(200);
			 
			
			
			
		}

	}



