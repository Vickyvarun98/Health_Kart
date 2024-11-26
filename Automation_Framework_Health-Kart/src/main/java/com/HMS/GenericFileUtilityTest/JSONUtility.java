package com.HMS.GenericFileUtilityTest;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	
	public String getDataFromJSONFile(String Key) throws FileNotFoundException, IOException, ParseException {
		JSONParser Parser=new JSONParser();
		Object obj = Parser.parse(new FileReader("./CommonData/HMS.json"));
		JSONObject map=(JSONObject)obj;
		String Value = map.get(Key).toString();
		
		return Value;
	}

}
