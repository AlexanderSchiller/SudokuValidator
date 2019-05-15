package com.fdmgroup.SudokuSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Game Logic
public class Logic {
	
	private Records records;
	private String overAllTestResult;
	private Boolean rowTestResult;
	private Boolean columnTestResult;
	private Boolean squareTestResult;
	
	public Logic(Records records){
		this.records = records;
	}
	
	public Boolean getFirstBoolean() {
		return rowTestResult;
	}

	public Boolean getSecondBoolean() {
		return columnTestResult;
	}

	public Boolean getThirdBoolean() {
		return squareTestResult;
	}
	
	public String getMyBoolean() {
		return overAllTestResult;
	}

	public Records getRecords() {
		return records;
	}

	public void setRecords(Records records) {
		this.records = records;
	}
	
	//Summaries All Necessary Tests For One Cell
	public void doTestsForCell(Integer i, Integer j){
		this.rowTestResult = checkRow(i,j);
		this.columnTestResult = checkColumn(i,j);
		this.squareTestResult = checkSquare(i,j);	
	}
	
	//Overall Test For Whole Sheet -> Result Is Stored In overAllTestResult Variable
	public String doTests(){

		overAllTestResult = "0 (VALID)" ;
		
		ArrayList<Boolean> rowTester = new ArrayList<Boolean>(Collections.nCopies(9, true));
		ArrayList<Boolean> columnTester = new ArrayList<Boolean>(Collections.nCopies(9, true));
		
		for(int ii=0;ii<9;ii++){
			
			for(int jj=0;jj<9;jj++){
				doTestsForCell(ii, jj);

				rowTestResult = getFirstBoolean();
				columnTestResult = getSecondBoolean();
				squareTestResult = getThirdBoolean();
				
				if(rowTestResult){
					overAllTestResult = "non-zero (INVALID)";
					
					if(rowTester.get(ii)){
						System.out.println("Error: Duplicate Values in Raw " + (ii+1));
						rowTester.set(ii, false);
					}
				}
				
				if(columnTestResult){

					overAllTestResult = "non-zero (INVALID)";
					
					if(columnTester.get(jj)){
						System.out.println("Error: Duplicate Values in Column " + (jj+1));
						columnTester.set(jj, false);
					}
					
				}
				
				if(squareTestResult){
					System.out.println("Error: Duplicate Values in Square (Row:"+ (findSquareRowLower(ii)+1) + "-" + (findSquareRowUpper(ii)) + "/Column:"+ 
					(findSquareColumnLower(jj)+1) + "-" + (findSquareColumnUpper(jj)) + ").");
					System.out.println("Cell (" + (ii+1) + "/" + (jj+1) + ") " + "Appears At Least Twice.");
					overAllTestResult = "non-zero (INVALID)";
				}
			}	
		}
		
		return overAllTestResult;
	}
	
	//Test For One Specific Row
	public Boolean checkRow(Integer i, Integer j){
		rowTestResult = false;
		String myNumber = records.getRecordsString(i, j);
		
		for(int jj=0;jj<9;jj++){
			if((jj != j) && (! myNumber.equals(""))){
			    if( records.getRecordsString(i, jj).equals(myNumber)) {
			    	rowTestResult = true;
			    }
			}
		}
		
		return rowTestResult;
	}
	
	//Test For One Specific Column
	public Boolean checkColumn(Integer i, Integer j){
		columnTestResult = false;
		String myNumber = records.getRecordsString(i, j);
		
		for(int ii=0;ii<9;ii++){
			if((ii != i) && (! myNumber.equals(""))){
			    if( records.getRecordsString(ii, j).equals(myNumber)) {
			    	columnTestResult = true;
			    }
			}	
		}
		
		return columnTestResult;
	}
	
	//Test For One Specific Square
	public Boolean checkSquare(Integer i, Integer j){
		squareTestResult = false;
		String myNumber = records.getRecordsString(i, j);
		
		int ii1 = findSquareRowLower(i);
		int ii2 = findSquareRowUpper(i);
		int jj1 = findSquareColumnLower(j);
		int jj2 = findSquareColumnUpper(j);
		
		for(int ii=ii1;ii<ii2;ii++){
			for(int jj=jj1;jj<jj2;jj++){

				if( (! myNumber.equals(""))){
					if((ii != i) || (jj != j) ){
					    if( records.getRecordsString(ii, jj).equals(myNumber)) {
					    	squareTestResult = true;
					    }
					}	
				}
			}
		}
		
		return squareTestResult;
	}
	
	//Support Find Lower Row Of Square For Specific Cell
	private int findSquareRowLower(int row){
		int rowLower;

		if(row < 3){
			rowLower = 0;
		}else if(row < 6){
			rowLower = 3;
		}else{
			rowLower = 6;
		}
		
		return rowLower;
	}
	
	//Support Find Upper Row Of Square For Specific Cell
	private int findSquareRowUpper(int row){
		int rowUpper;

		if(row < 3){
			rowUpper = 3;
		}else if(row < 6){
			rowUpper = 6;
		}else{
			rowUpper = 9;
		}
		
		return rowUpper;
	}
	
	//Support Find Lower Column Of Square For Specific Cell
	private int findSquareColumnLower(int column){
		int columnLower;		
		
		if(column < 3){
			columnLower = 0;
		}else if(column < 6){
			columnLower = 3;
		}else{
			columnLower = 6;
		}
		
		return columnLower;
	}
	
	//Support Find Upper Column Of Square For Specific Cell
	private int findSquareColumnUpper(int column){
		int columnUpper;
		
		if(column < 3){
			columnUpper = 3;
		}else if(column < 6){
			columnUpper = 6;
		}else{
			columnUpper = 9;
		}
		
		return columnUpper;
	}
	
}
