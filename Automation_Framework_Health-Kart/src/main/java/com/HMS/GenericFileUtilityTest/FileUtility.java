package com.HMS.GenericFileUtilityTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropFile(String Key) throws IOException {

		FileInputStream fis = new FileInputStream("./CommonData/HMS.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Value = prop.getProperty(Key);
		return Value;
	}

}
