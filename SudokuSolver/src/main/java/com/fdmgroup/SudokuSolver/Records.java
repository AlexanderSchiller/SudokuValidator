package com.fdmgroup.SudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//Class To Save Sudoku Game
public class Records {

	private List<List<String>> records = new ArrayList<List<String>>();

	public List<List<String>> getRecords() {
		return records;
	}
	
	public String getRecordsString(Integer i, Integer j) {
		return records.get(i).get(j); 
	}
	
	public List<String> get(Integer i){
		return records.get(i);
	}

	public void setRecords(List<List<String>> records) {
		this.records = records;
	}
	
	public void addLine(String[] values){
		records.add(Arrays.asList(values));
	}
	
	public void addLineAsList(ArrayList<String> values){
		records.add(values);
	}
	
	//Add New Line
	public void addLineAsString(String data){
		
		String validateString = validateString(data);
			
		if (! validateString.equals("")){
			System.out.println(validateString);
			System.out.println("non-zero (INVALID)");
			System.exit(0);
		}
		
        String[] thisData = data.split(",", 9);       
        List<String> arrayData = new ArrayList<String>(Arrays.asList(thisData));
        records.add(arrayData);
		
	}
	
	//Validate Initial String Line
	public String validateString(String data){
		
		String validateString = "";
		
		int count = data.length() - data.replaceAll(",", "").length();
		
		if (count != 8){
			validateString = ("Error: Not Each Line Has Correct Length.");
		}
		
		return validateString;
	}
	
	//Validate ArrayList Size
	public String validateSize(){
		
		String validateSize = "";
		
		int mySize = records.size();
		
		if (mySize != 9){
			validateSize = ("Error: The File Is " + records.size() + " Lines Long. 9 Lines Are Required.");
		}
		
		return validateSize;
	
	}
	
	//Check For Invalid Identifiers
	public String validateIdentifiers(){
		
		String validateIdentifiers = "";
		
		String string1 = "123456789";
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(! getRecordsString(i, j).equals("")){
					if(! string1.contains(getRecordsString(i, j))) {
						validateIdentifiers = ("Error: File Includes Invalid Identifiers.");
					}
				}
			}
		}
	
		return validateIdentifiers;
		
	}
}
