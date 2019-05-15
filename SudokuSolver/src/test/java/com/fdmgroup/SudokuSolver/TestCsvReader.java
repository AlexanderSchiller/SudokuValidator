package com.fdmgroup.SudokuSolver;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestCsvReader {

	Records records1 = new Records();
	Records records2 = new Records();
	Records records3 = new Records();
	Records records4 = new Records();
	Records records5 = new Records();
	CsvReader csvReader;
	
	@Before
	public void beforeTest() {
		
		String string1 = "9,,4,,6,,7,,1";
		String string2 = ",2,,4,,3,,8,";
		String string3 = "8,,,,,,,,4";

		String string4 = ",,1,8,4,9,6,,";
		String string5 = ",,,,,,,,";
		String string6 = ",,3,2,5,7,9,,";
		
		String string7 = "4,,,,,,,,7";
		String string8 = ",8,,6,,4,,5,";
		String string9 = "5,,6,,8,,2,,3";
		
		records1.addLineAsString(string1);
		records1.addLineAsString(string2);
		records1.addLineAsString(string3);
		records1.addLineAsString(string4);
		records1.addLineAsString(string5);
		records1.addLineAsString(string6);
		records1.addLineAsString(string7);
		records1.addLineAsString(string8);
		records1.addLineAsString(string9);
		
		String string11 = ",,,,,,,,";
		String string21 = ",,,,,3,,8,5";
		String string31 = ",,1,,2,,,,";
		String string41 = ",,,5,,7,,,";
		String string51 = ",,4,,,,1,,";
		String string61 = ",9,,,,,,,";
		String string71 = "5,,,,,,,7,3";
		String string81 = ",,2,,1,,,,";
		String string91 = ",,,,4,,,,9";
		
		records3.addLineAsString(string11);
		records3.addLineAsString(string21);
		records3.addLineAsString(string31);
		records3.addLineAsString(string41);
		records3.addLineAsString(string51);
		records3.addLineAsString(string61);
		records3.addLineAsString(string71);
		records3.addLineAsString(string81);
		records3.addLineAsString(string91);
		
		records4.addLineAsString(string21);
		records4.addLineAsString(string31);
		records4.addLineAsString(string41);
		records4.addLineAsString(string51);
		records4.addLineAsString(string61);
		records4.addLineAsString(string71);
		records4.addLineAsString(string81);
		records4.addLineAsString(string91);
		
		String string12 = ",,A,,A,,,,";
		
		records5.addLineAsString(string12);
		records5.addLineAsString(string21);
		records5.addLineAsString(string31);
		records5.addLineAsString(string41);
		records5.addLineAsString(string51);
		records5.addLineAsString(string61);
		records5.addLineAsString(string71);
		records5.addLineAsString(string81);
		records5.addLineAsString(string91);
	}
	
//	@Test
//	public void testCsvReader() {
//		
//    	csvReader = new CsvReader("C:/Users/Alexander.Schiller/Desktop/folder/sudoku2.csv");
//    	records2 = csvReader.returnRecords();
//		
//    	String number1 = records2.getRecordsString(5,2);
//    	String number2 = records1.getRecordsString(5,2);
//    	
//    	assertEquals(number1,number2);
//	}

//	@Test
//	public void testCsvReader2() {
//		
//    	csvReader = new CsvReader("C:/Users/Alexander.Schiller/Desktop/folder/sudoku5.csv");
//    	records2 = csvReader.returnRecords();
//		
//    	String number1 = records2.getRecordsString(8,8);
//    	String number2 = records3.getRecordsString(8,8);
//    	
//    	assertEquals(number1,number2);
//	}
	
	
	@Test
	public void testCorrectLength() {
		
		String validateSize = records4.validateSize();
		
    	assertEquals(validateSize,"Error: The File Is 8 Lines Long. 9 Lines Are Required.");
	}
	
	
	@Test
	public void testValidIdentifiers() {
		
		String validateIdentifiers = records5.validateIdentifiers();
		
    	assertEquals(validateIdentifiers,"Error: File Includes Invalid Identifiers.");
	}
	
	@Test
	public void testValidString() {
		
		Records records = new Records();
		String string21 = ",,,,,,8,5";
		
		String validateString = records.validateString(string21);
		
    	assertEquals(validateString,"Error: Not Each Line Has Correct Length.");
	}
	
}
