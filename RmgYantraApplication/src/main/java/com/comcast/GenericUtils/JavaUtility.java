package com.comcast.GenericUtils;

import java.util.Random;

public class JavaUtility {
	/**
	 * generic methods related to java
	 */
	public int randomNumber()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ran;
	}

}
