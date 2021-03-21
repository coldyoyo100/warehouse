package com.example.warehouse;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.example.warehouse.dto.InsertActionContainer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WarehouseTest {
	
//	@Test
	public String jsonString() {
		String retval = null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("../warehouse/src/main/resources/json/InsertWarehouse.json"));
			JSONObject jsonObj = (JSONObject)obj;
//			System.out.println( jsonObj.toJSONString());
			
			retval = jsonObj.toJSONString();
			System.out.println(retval);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return retval; 
	}
	
	@Test
	public void jsonToDto() {
		String json = jsonString();
		ObjectMapper mapper = new ObjectMapper();
		try {
			InsertActionContainer jsonDto = mapper.readValue(json, InsertActionContainer.class);
			System.out.println("a");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
