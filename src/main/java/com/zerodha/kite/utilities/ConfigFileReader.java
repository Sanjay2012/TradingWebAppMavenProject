package com.zerodha.kite.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	 private static ConfigFileReader instance;
	    private static final Object lock = new Object();
	private static String propertyFilePath = "C:\\Users\\Dell\\eclipse-workspace\\TraidingWebApp\\configs\\configuration.properties";
	private static String url;
	private static String validUsername;
	private static String validPassword;
	private static String driverPath;
	private static String invalidUsername;
	private static String validPIN;
	private static String validProfileName;
	
	
	//Create a Singleton instance. We need only one instance of Property Manager.
    public static ConfigFileReader getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new ConfigFileReader();
                instance.loadData();
            }
        }
        return instance;
    }

	private void loadData() {
		// Declare a properties object
		Properties prop = new Properties();
		// Read configuration.properties file
		try {
			prop.load(new FileInputStream(propertyFilePath));
			// prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}
		// Get properties from configuration.properties
		driverPath=prop.getProperty("driverPath");
		url = prop.getProperty("url");
		validUsername = prop.getProperty("validUsername");
		invalidUsername = prop.getProperty("invalidUsername");
		validPassword = prop.getProperty("validPassword");
		validPIN = prop.getProperty("validPIN");
		validProfileName = prop.getProperty("validProfileName");
	}
	
	public String getDriverPath() {
		return driverPath;
	}

	public String getURL() {
		return url;
	}

	public String getValidUsername() {
		return validUsername;
	}

	public String getValidPassword() {
		return validPassword;
	}
	
	public String getInvalidUsername() {
		return invalidUsername;
	}
	public String getValidPIN() {
		return validPIN;
	}
	
	public String getValidProfileName() {
		return validProfileName;
	}
	
	

}
