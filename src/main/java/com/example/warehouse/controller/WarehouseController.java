package com.example.warehouse.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.dto.InsertActionContainer;
import com.example.warehouse.dto.UpdtDelActionContainer;
import com.example.warehouse.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	
	@Autowired
	WarehouseService warehouseService; 
	
	@PostMapping("/test")
	public String warehouseTest() {
		return "warehouseTest";
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertAction (@RequestBody InsertActionContainer insertContainer) throws Exception{
		try {
			Map<String, Object> objList = warehouseService.checkValue(insertContainer); 
			warehouseService.insertData(objList);
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
		return ResponseEntity.ok("suskses insert");
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateAction (@RequestBody Map<String,String> jsonMap) throws Exception{
		try {
			warehouseService.updateData(jsonMap);
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
		return ResponseEntity.ok("sukses Update");
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteAction (@RequestBody String id) throws Exception{
		try {
			warehouseService.deleteData(id);
			return ResponseEntity.ok("sukses Delete");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@PostMapping("/reporting")
	public ResponseEntity<?> generateReport () throws Exception{
		try {
			warehouseService.genereateReport();
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
		return ResponseEntity.ok("sukses Generate Report");
	}
}
