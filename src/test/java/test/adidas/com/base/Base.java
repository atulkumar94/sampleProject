package test.adidas.com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;


import test.adidas.com.constants.APIEndPoints;
import test.adidas.com.constants.Constants;
import test.adidas.com.constants.JsonPath;
import test.adidas.com.utils.PropertyHolder;
import test.adidas.com.utils.Utility;

public class Base {
	public static Properties properties = new Properties();

	static {
		readPropertyFile();
		init();
	}

	/**
	 * Initialize config.property available under resource folder
	 * 
	 */
	public static void init() {
		try {			
			Utility.putVariablesInMap(APIEndPoints.class);
			Utility.putVariablesInMap(JsonPath.class);
			Utility.putVariablesInMap(Constants.class);
		} catch (Exception e) {
			Assert.assertTrue("Error while reading properties file: " + e.getMessage(), false);
		}
	}

	public static void readPropertyFile() {
		try {
			FileInputStream stream = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/configFiles/propertiesFile/config.properties");
			properties.load(stream);
			if (properties.size() > 0) {
				Set<Object> keys = properties.keySet();
				for (Object object : keys) {
					PropertyHolder.setProperty(object.toString(), properties.getProperty(object.toString()));
				}
			}
		} catch (IOException e) {
			org.junit.Assert.assertTrue("Error on reading queries config file", false);
		}
	}

}
