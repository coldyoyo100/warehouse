package com.example.warehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.sun.tools.javac.util.StringUtils;

import org.junit.Test;

public class WordSearchTest {
	
	@Test
	public void main() {
		Scanner userInput = new Scanner(System.in);
		try {
			System.out.println("Please enter test case: ");
			int totalCaseRun = userInput.nextInt();
			int countCase = 0;
			List<Integer> listGridY = new ArrayList<Integer>();
			List<Integer> listGridX = new ArrayList<Integer>();
			List<String> puzzleList = new ArrayList<String>();
			List<String> searchList = new ArrayList<String>();
			while (countCase < totalCaseRun ) {
				int inputY = userInput.nextInt();
				int inputX = userInput.nextInt();
				
				StringBuilder temp = new StringBuilder();
				if(inputX > 0 && inputY > 0 && inputX <= 100 && inputY <=100) {
					int loop = 0;
					while(loop < inputY) {
						String inputStr = userInput.next();
						if(!inputStr.isEmpty() && inputStr.length() <= inputX) 
							temp.append(inputStr);
						else {
							System.out.println("Jumlah Karakter Melebihi batas [0-100]");
							break;
						}
						loop++;
					}
				}else {
					System.out.println("Inputan Melebihi batas [0-100]");
					break;
				}
//				
				String inputSearch = userInput.next();
				if(!inputSearch.isEmpty() && inputSearch.length() <=100) {
				
					listGridY.add(inputX);
					listGridX.add(inputY);
					puzzleList.add(temp.toString());
					searchList.add(inputSearch);
//					if(countCase == 64 || countCase == 63 || countCase == 81 || countCase == 82 || countCase == 85 ||countCase == 72) System.out.println("case" + countCase + ": " +inputSearch);
				}else {
					System.out.println("Pencarian karakter melebihi batas [0-100]");
				}
				
				countCase++;
			}
			
			int index = 0;
			for(String puzzleInput : puzzleList) {
				int totalGridY = listGridX.get(index);
				int totalGridX = listGridY.get(index);
				String searchWord = searchList.get(index);
				
				int foundWord = startSearchWord(totalCaseRun, totalGridY, totalGridX, puzzleInput.toLowerCase(), searchWord.toLowerCase());
				
				System.out.println("Case " + (index+1) + ": " + foundWord);
				
				index++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("End of Search Word Game");
	}
		
	public int startSearchWord(int totalCaseRun, int totalGridY, int totalGridX, String puzzleInput, String searchWord) {
		int totalWordFound = 0;
		
		if(checkInput(totalCaseRun, totalGridX, totalGridY, puzzleInput)) {
			
			String[][] wordArr = buildWordGrid(totalGridX, totalGridY, puzzleInput);
			String[] searchArr = searchWord.split("");
			
			List<String> firstList = getFirstLetterLocation(searchArr, wordArr);
			
			if(firstList.size() > 0) {
				totalWordFound = searchByAxis(searchArr, wordArr, firstList);
				//System.out.println("Word Found Case : " + totalWordFound);
			}else {
				System.out.println("Huruf pertama tidak ditemukan!");
			}
		}else {
			System.out.println("Format Input Salah!");
		}
		
		return totalWordFound;
	}
	
	
	public int searchByAxis(String[] searchWord, String[][] wordArr, List<String> firstList) {
		int total = 0;
		String[] pinnedCoor = new String[]{};
		for(String coordinate : firstList) {
			pinnedCoor = coordinate.split(","); //tempCoor[y][x]
			total += countAxisX(searchWord, pinnedCoor, wordArr);
			total += countAxisY(searchWord, pinnedCoor, wordArr);
			total += countAxisDiagonal(searchWord, pinnedCoor, wordArr);
		}
		
		return total;
	}
	
	public int countAxisDiagonal(String[] searchWord, String[] pinnedCoor, String[][]wordArr) {
		int index = 0;
		int count = 0;
		int retval = 0;
		
		int y = Integer.valueOf(pinnedCoor[0]);
		int x = Integer.valueOf(pinnedCoor[1]);
		int lengthX = wordArr[0].length;
		int depthY = wordArr.length;
		String temp = null;
		
		//Diagonal Right-Up
		for(String word : searchWord) {
			int countX = x + index;
			int countY = y - index;
			if(countX < lengthX && countY < depthY && countX >= 0 && countY >= 0) { //count X Long & Y depth
				temp = wordArr[countY][countX];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		
		//diagonal Left-Up
		index = 0;
		count = 0;
		temp = null;
		for(String word : searchWord) {
			int countX = x - index;
			int countY = y - index;
//			if(countX > 0 && countY > 0) { //count X Long & Y depth
			if(countX < lengthX && countY < depthY && countX >= 0 && countY >= 0) { //count X Long & Y depth
				temp = wordArr[countY][countX];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		//Diagonal Right-Down
		index = 0;
		count = 0;
		temp = null;
		for(String word : searchWord) {
			int countX = x + index;
			int countY = y + index;
//			if(countY < wordArr.length && countX < wordArr[countY].length ) { //count Y Long & X depth
			if(countX < lengthX && countY < depthY && countX >= 0 && countY >= 0) { //count X Long & Y depth
				temp = wordArr[countY][countX];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		
		//diagonal Left-Down
		index = 0;
		count = 0;
		temp = null;
		for(String word : searchWord) {
			int countY = y + index;
			int countX = x - index;
//			if(countY > 0 && countX > 0) {
			if(countX < lengthX && countY < depthY && countX >= 0 && countY >= 0) { //count X Long & Y depth
				temp = wordArr[countY][countX];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		return retval;
	}
	
	public int countAxisY(String[] searchWord, String[] pinnedCoor, String[][]wordArr) {
		int index = 0;
		int count = 0;
		int retval = 0;
		
		int y = Integer.valueOf(pinnedCoor[0]);
		int x = Integer.valueOf(pinnedCoor[1]);
		String temp = null;
		
		//Axis Y-Down
		for(String word : searchWord) {
			int countY = y + index;
			if(countY < wordArr.length) { //count Y depth
				temp = wordArr[countY][x];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		//Axis Y-Up
		index = 0;
		count = 0;
		temp = null;
		for(String word : searchWord) {
			int countY = y - index;
			if(countY >= 0 && countY < wordArr.length) {
				temp = wordArr[countY][x];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		return retval;
	}
	
	public int countAxisX(String[] searchWord, String[] pinnedCoor, String[][]wordArr) {
		int index = 0;
		int count = 0;
		int retval = 0;
		
		int y = Integer.valueOf(pinnedCoor[0]);
		int x = Integer.valueOf(pinnedCoor[1]);
		String temp = null;
		
		//X-Right
		for(String word : searchWord) {
			int countX = x + index;
			if(countX < wordArr[y].length) { //count X Long
				temp = wordArr[y][countX];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			
			index++;
		}
		if(count == searchWord.length ) retval += 1;
		
		
		//X-Left
		index = 0;
		count = 0;
		temp = null;
		for(String word : searchWord) {
			int countX = x - index;
			if(countX >= 0 && countX < wordArr[y].length) {
				temp = wordArr[y][countX];
				if(word.equals(temp)) count++;
			}else {
				break;
			}
			
			index++;
		}
		if(count == searchWord.length ) retval += 1;

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
	
	public List<String> getFirstLetterLocation(String[] letter, String[][] wordArr) {
		int indexY = 0 ;
		int indexX = 0;
		List<String> retval = new ArrayList<String>();
		
		for(String[] strY : wordArr)  {
			indexX = 0;
			for(String strX : strY) {
				if(strX.equals(letter[0])) retval.add(indexY + "," + indexX) ;
				indexX++; 
			}
			indexY++;
		}
		
		return retval;
	}
	
//	@Test
	public void testing() {
		
		Scanner userInput = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("Please enter input:");
				String input = userInput.nextLine();
				System.out.println("input: " + input);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		int y = 5;
		int x = 5;
//		String str = "qwertyasdfgg";
//		String str = "cattaatatatc";
		String str = "gogog"
				+ "ooooo"
				+ "godog"
				+ "ooooo"
				+ "gogog";
		String[][] arr = new String[y][x];
		
		String[] searchArr = new String[]{"d","o","g"};
		String[] pinnedCoor = new String[] {"2","2"};
		
		int index = 0;
		for(int a = 0; a < y; a++) {
			String temp = str.substring(index, index + x);
			arr[a] = temp.split("");
			
			index = index + x;
		}
		
		System.out.println(Arrays.deepToString(arr));
		System.out.println(arr.length);
		
		for(String[] strArr : arr) {
			System.out.println(strArr.length);
			System.out.println(Arrays.toString( strArr));
		}
		
		
		int total = 0;
		total += countAxisX(searchArr, pinnedCoor, arr);
		total += countAxisY(searchArr, pinnedCoor, arr);
		total += countAxisDiagonal(searchArr, pinnedCoor, arr);
		
		System.out.println(total);
	}
	
}
