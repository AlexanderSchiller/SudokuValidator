package com.fdmgroup.SudokuSolver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestGameLogic {
	
	Records records1 = new Records();
	Records records2 = new Records();
	Records records3 = new Records();
	Records records4 = new Records();
	
	@Before
	public void beforeTest() {
		
		String string1 = "9,,4,,6,,7,,1";
		String string11 = "9,,4,,6,,7,9,1";
		String string2 = ",2,,4,,3,,8,";
		String string3 = "8,,,,,,,,4";
		String string33 = "8,2,,,,,,,4";
		
		String string4 = ",,1,8,4,9,6,,";
		String string5 = ",,,,,,,,";
		String string6 = ",,3,2,5,7,9,,";
		
		String string7 = "4,,,,,,,,7";
		String string8 = ",8,,6,,4,,5,";
		String string9 = "5,,6,,8,,2,,3";
		String string99 = "5,4,6,,8,,2,,3";
		
		records1.addLineAsString(string1);
		records1.addLineAsString(string2);
		records1.addLineAsString(string3);
		records1.addLineAsString(string4);
		records1.addLineAsString(string5);
		records1.addLineAsString(string6);
		records1.addLineAsString(string7);
		records1.addLineAsString(string8);
		records1.addLineAsString(string9);
		
		records2.addLineAsString(string11);
		records2.addLineAsString(string2);
		records2.addLineAsString(string3);
		records2.addLineAsString(string4);
		records2.addLineAsString(string5);
		records2.addLineAsString(string6);
		records2.addLineAsString(string7);
		records2.addLineAsString(string8);
		records2.addLineAsString(string9);
		
		records3.addLineAsString(string1);
		records3.addLineAsString(string2);
		records3.addLineAsString(string33);
		records3.addLineAsString(string4);
		records3.addLineAsString(string5);
		records3.addLineAsString(string6);
		records3.addLineAsString(string7);
		records3.addLineAsString(string8);
		records3.addLineAsString(string9);
		
    	records4.addLineAsString(string1);
    	records4.addLineAsString(string2);
    	records4.addLineAsString(string3);
    	records4.addLineAsString(string4);
    	records4.addLineAsString(string5);
    	records4.addLineAsString(string6);
    	records4.addLineAsString(string7);
    	records4.addLineAsString(string8);
    	records4.addLineAsString(string99);
		
	}
	
	@Test
	public void checkValidSudoku() {
		Logic logic = new Logic(records1);
		
        String myTest = logic.doTests();
		
        assertEquals("0 (VALID)",myTest);
	}
	
	@Test
	public void checkInvalidRow() {
		Logic logic = new Logic(records2);
		
        Boolean myTest = logic.checkRow(0,0);
		
        assertEquals(true,myTest);	
	}
	
	@Test
	public void checkInvalidRowDoesNotShowInvalidColumn() {
		Logic logic = new Logic(records2);
		
        Boolean myTest = logic.checkColumn(0,0);
		
        assertEquals(false,myTest);	
	}
	
	@Test
	public void checkInvalidColumn(){
		Logic logic = new Logic(records3);
		
        Boolean myTest = logic.checkColumn(1,1);
		
        assertEquals(true,myTest);	
	}
	
	@Test
	public void checkInvalidColumnDoesNotShowInvalidRow(){
		Logic logic = new Logic(records3);
		
        Boolean myTest = logic.checkRow(1,1);
		
        assertEquals(false,myTest);	
	}
	
	@Test
	public void checkInvalidField(){
		Logic logic = new Logic(records4);
		
        Boolean myTest = logic.checkSquare(6,0);
		
        assertEquals(true,myTest);	
	}
	
	@Test
	public void checkInvalidFieldDoesNotShowInvalidRow(){
		Logic logic = new Logic(records4);
		
        Boolean myTest = logic.checkRow(6,0);
		
        assertEquals(false,myTest);	
	}
	
	@Test
	public void checkInvalidFieldDoesNotShowInvalidColumn(){
		Logic logic = new Logic(records4);
		
        Boolean myTest = logic.checkColumn(6,0);
		
        assertEquals(false,myTest);	
	}
	
	@Test
	public void checkInvalidSudoku() {
		Logic logic = new Logic(records2);
		
        String myTest = logic.doTests();
		
        assertEquals("non-zero (INVALID)",myTest);
	}
	
	@Test
	public void checkInvalidSudoku2() {
		Logic logic = new Logic(records3);
		
        String myTest = logic.doTests();
		
        assertEquals("non-zero (INVALID)",myTest);
	}
	
	@Test
	public void checkInvalidSudoku3() {
		Logic logic = new Logic(records4);
		
        String myTest = logic.doTests();
		
        assertEquals("non-zero (INVALID)",myTest);
	}

}
