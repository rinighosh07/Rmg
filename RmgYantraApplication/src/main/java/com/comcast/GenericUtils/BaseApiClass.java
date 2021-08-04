package com.comcast.GenericUtils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseApiClass {
	
	@BeforeSuite
	public void configBeforeSuite() throws SQLException {
		baseURI = "http://localhost";
		port = 8084;
		
		DataBaseUtilities.connectToDB();
	}
	
	@AfterSuite
	public void configAfterSuite() throws SQLException {
		DataBaseUtilities.closeDB();
	}

}
