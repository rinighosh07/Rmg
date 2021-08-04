package com.ty.Rmg.Projects;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreateTest {
	@Test
	public void createTest() throws SQLException {

		baseURI="http://localhost";
		port= 8084;
		//expected data initialization
		String expectedData= "Rini145";
		//getting the resource from the server
		Response response= when()
				.get("/projects");
		// verification of status code
		response.then().statusCode(200)
		.log()
		.all();
		// capture the project id 
		String firstProjectId = response.jsonPath().get("[0].projectId");
		System.out.println(firstProjectId);
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		given()
		.pathParam("ProjId",firstProjectId)
		.when()
		// delete the project from the project id created
		.delete("/projects/{ProjId}")
		.then()
		//to get all response time from 200 - 500 series Matchers are used
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
		.log().all()
		.assertThat().statusCode(204);
		// get connection with the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//issue create statement

		Statement statement = conn.createStatement();

		//execute querry
		ResultSet result = statement.executeQuery("select * from project");
		String expData = null;
		while(result.next()){

			if(result.getString(1).equals(firstProjectId)) {


				expData= result.getString(1);
				System.out.println("project is successfully deleted");

				break;

			}
		}
		conn.close();

	}

}
