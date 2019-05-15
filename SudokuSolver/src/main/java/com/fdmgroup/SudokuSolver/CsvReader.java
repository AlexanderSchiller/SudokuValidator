package com.fdmgroup.SudokuSolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Reads In CSV-Document -> File Is Saved In Records Class
public class CsvReader {
	
    private Records records;
    private String path;
    
    public  CsvReader(String path){
    	this.path = path;
    	records = new Records();
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	records.addLineAsString(line);
    	    }
    		} catch (FileNotFoundException e1) {
    	    	System.out.println("Error: File Not Found");
    	    	System.exit(0);
    	    	e1.printStackTrace();
    		} catch (IOException e2) {
    		e2.printStackTrace();
    		}
    }
    
    public Records returnRecords(){
    	return records;
    }
	
}