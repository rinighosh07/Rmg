package com.ty.Rmg.Projects;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.GenericUtils.BaseApiClass;
import com.comcast.GenericUtils.DataBaseUtilities;
import com.comcast.GenericUtils.EndPoint;
import com.comcast.GenericUtils.JavaUtility;
import com.comcast.GenericUtils.RestAssuredUtility;
import com.comcast.POJOClass.ProjectLiabrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectWithCreatedStatusAndValidate extends BaseApiClass {
	
	@Test
	public void createProjectWithCreateStatusAndValidateTest() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		RestAssuredUtility rLib = new RestAssuredUtility();
		DataBaseUtilities dLib = new DataBaseUtilities();
		
		
		//Create project with created status using POJO class
		ProjectLiabrary projectLibrary = new ProjectLiabrary("Jackson", "Casonoa"+jLib.randomNumber(), "Created", 25);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		.when()
		.post(EndPoint.addProject);
		
		//Capture the project id
		String firstProjectId=rLib.jsonPathConstant(response, "projectId");
		
		String actProjName = rLib.jsonPathConstant(response, "projectName");
		System.out.println(firstProjectId);
		System.out.println(actProjName);
		
		//verify the project id in the data base
		
		String Query = "select * from project";
		String expData = dLib.executeQueryAndGetData(Query, 1, firstProjectId);
		
		String expPName = dLib.executeQueryAndGetData(Query, 4, actProjName);
        
        //validation
        Assert.assertEquals(firstProjectId, expData);
        
        Assert.assertEquals(actProjName, expPName);
        
		

	}
}
