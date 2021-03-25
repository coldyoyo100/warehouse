package com.example.warehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.sun.tools.javac.util.StringUtils;

public class WordSearchTest {
	
	@Test
	public void main() {
		//input
		int totalCaseRun = 0;
		int totalGridY = 0 ;
		int totalGridX = 0;
		String wordInput = null;
		String searchWord = null;
		
		if(checkInput(totalCaseRun, totalGridX, totalGridY, wordInput)) {
			
			String[][] wordArr = buildWordGrid(totalGridX, totalGridY, StringUtils.toLowerCase(wordInput));
			String[] searchArr = StringUtils.toLowerCase(searchWord).split("");
			
			List<String> firstList = getFirstLetterLocation(searchArr[0], wordArr);
			
			if(firstList.size() > 0) {
				searchByAxis(searchArr, wordArr, firstList); 
			}else {
				System.out.println("Huruf pertama tidak ditemukan!");
			}
		}else {
			System.out.println("Format Input Salah!");
		}
	}
	
	
	public void searchByAxis(String[] searchWord, String[][] wordArr, List<String> firstList) {
		String[] pinnedCoor = new String[]{};
		for(String coordinate : firstList) {
			pinnedCoor = coordinate.split(","); //tempCoor[y][x]
			
		}
	}
	
	
	public void axisX(String[] searchWord, String[] pinnedCoor, String[][]wordArr) {
		int total = 0;
		total += countXRight(searchWord, pinnedCoor, wordArr);
		
	}
	
	public int countXRight(String[] searchWord, String[] pinnedCoor, String[][]wordArr) {
		int index = 0;
		int count = 0;
		int retval = 0;
		
		int y = Integer.valueOf(pinnedCoor[0]);
		int x = Integer.valueOf(pinnedCoor[1]);
		String temp = null;
		
		for(String word : searchWord) {
			int countX = x + index;
			if(countX < wordArr[y].length) {
				temp = wordArr[y][countX];
				if(word.equals(temp)) count++;
			}
			index++;
		}
		if(count == searchWord.length ) retval = 1;
		
		return retval;
	}
	
	public int countXLeft(String[] searchWord, String[] pinnedCoor, String[][]wordArr) {
		int index = 0;
		int count = 0;
		int retval = 0;
		for(String word : searchWord) {
			//X-right
			int y = Integer.valueOf(pinnedCoor[0]);
			int x = Integer.valueOf(pinnedCoor[1]);
			
			String temp = wordArr[y][x];
			
			if(word.equals(temp)) count++;
			
			index++;
		}
		
		if(count == searchWord.length ) retval = 1;
		
		return retval;
	}
	
	
	public Boolean checkInput(int totalCaseRun, int gridX, int gridY, String wordInput) {
		int totalWord = gridX * gridY;
		
		if(totalCaseRun < 1 && totalCaseRun > 100) return false;
		if(gridX < 1 && gridX > 100) return false;
		if(gridY < 1 && gridY > 100) return false;
		if(wordInput.length() != totalWord && wordInput.length() < 1 && wordInput.length() > 100) 
			return false;
		
		return true;
	}
	public String[][] buildWordGrid(int gridX, int gridY, String wordInput) {
		String[][] wordArr = new String[gridY][gridX];
		int index = 0;
		String temp = null;
		for(int y = 0; y < gridY; y++) {
			temp = wordInput.substring(index, index + gridX);
			wordArr[y] = temp.split("");
			index = index + gridX;
		}
		
		return wordArr;
	}
	
	public List<String> getFirstLetterLocation(String letter, String[][] wordArr) {
		int indexY = 0 ;
		int indexX = 0;
		List<String> retval = new ArrayList<String>();
		
		for(String[] strY : wordArr)  {
			for(String strX : strY) {
				if(strX.equals(letter)) retval.add(indexY + "," + indexX) ;
				indexX++; 
			}
			indexY++;
		}
		
		return retval;
	}
	
	@Test
	public void testing() {
		int y = 3;
		int x = 2;
		String str = "qwertyasdfgg";
		String[][] arr = new String[y][x];
		
		int index = 0;
		for(int a = 0; a < y; a++) {
			String temp = str.substring(index, index + x);
			arr[a] = temp.split("");
			
			index = index + x;
		}
		
		
		for(String[] strArr : arr) {
			System.out.println(Arrays.toString( strArr));
		}
		
		
	}
	
}
