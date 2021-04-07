package com.example.warehouse;

import org.junit.Test;

public class Testing {
	
	@Test
	public void testing() {
		String input = "09823";
		
		String[] strArr = input.split("");  
		
		int temp = strArr.length % 2;
		int mid = 0; 
		int first = 0;
		int second = 0;
		
		
		first = Integer.valueOf( input.substring((strArr.length / 2) - 1), strArr.length / 2) ;
//		second = input.substring();
		
		
		int total = first + second;
		
		System.out.println(total);
		
		
	}
	
}
