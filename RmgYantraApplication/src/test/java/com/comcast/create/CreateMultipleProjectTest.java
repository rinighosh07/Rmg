package com.comcast.create;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLiabrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*; 

public class CreateMultipleProjectTest {
	
	@Test(dataProvider= "getData")
	public void createMultipleProjects(String createdBy, String projectName,int teamSize) {
		
		
		baseURI = "http://localhost";
		port= 8084;
		
		ProjectLiabrary projectLiabrary =new ProjectLiabrary( createdBy,  projectName, "Completed", teamSize);
		
		 given()
		 .contentType(ContentType.JSON)
		.body(projectLiabrary)
		.when()
		.post("/addproject")
		.then()
		.log()
		.all()
		.assertThat().contentType(ContentType.JSON);
		
	}
	@DataProvider
	public Object [] [] getData()
	{
		Object[] [] obj = new Object[4][3];
		{
			obj[0][0]="rini";
			obj[0][1]="tyss";
			obj[0][2]=10;
			
			
			obj[1][0]="payal";
			obj[1][1]="prothon";
			obj[1][2]=10;
			
			
			obj[2][0]="neelam";
			obj[2][1]="nikon";
			obj[2][2]=10;
			
			
			
			obj[3][0]="sayy";
			obj[3][1]="hp";
			obj[3][2]=10;
			return obj;
	
			
		}
	}
	

}
