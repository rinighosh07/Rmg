package com.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comcast.GenericUtils.IConstraintsAndPath;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilities {
	
	static Connection con=null;
	static ResultSet result = null;
	
	/**
	 * this method will establish connection with database
	 * @throws SQLException 
	 */
	public static void connectToDB() throws SQLException
	{
		Driver driverRef;
		try
		{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstraintsAndPath.dbUrl, IConstraintsAndPath.dbUsername,IConstraintsAndPath.dbPassword);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close database connection
	 * @throws SQLException 
	 */
	public static void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method helps to verify data in database
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws SQLException
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verfied in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verfied");
			return expData;
		}
	}

}
