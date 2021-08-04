package com.comcast.GenericUtils;

import io.restassured.response.Response;


/**
 * Restassured specific generic methods
 * @author Rini
 *
 */

public class RestAssuredUtility {
	/**
	 * returns json data with json path
	 * @param response
	 * @param jsonxpath
	 * @return 
	 * @return
	 */
	public String jsonPathConstant(Response response,String jsonxpath) {
		String jsondata = response.jsonPath().get(jsonxpath);
		return jsondata;
		
	}

}
