package com.fdmgroup.SudokuSolver;

public class Runner 
{

	public static void main( String[] args )
    {
		//Check If Relevant Options For JAR Execution Are Provided
	    String one = null;
	    
	    try {
	        one = args[0];
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	        System.out.println("Syntax Error");
	    }

	    if(one==null){
	    	System.out.println("No File Name Provided");
	    	System.exit(0);
	    }
	    
	    //Read File
    	CsvReader csvReader = new CsvReader(one);
    	Records records = new Records();
    	records = csvReader.returnRecords();
    	
    	//Validate File
    	//Check If Size Is Correct
    	String validateSize = records.validateSize();
    	
	    if(! validateSize.equals("")){
	    	System.out.println(validateSize);
	    	System.out.println("non-zero (INVALID)");
	    	System.exit(0);
	    }
    	
	    //Check For Invalid Identifiers
    	String validateIdentifiers = records.validateIdentifiers();
    	
	    if(! validateIdentifiers.equals("")){
	    	System.out.println(validateIdentifiers);
	    	System.out.println("non-zero (INVALID)");
	    	System.exit(0);
	    }
    	
	    //Start Sudoku Check Logic
    	Logic logic = new Logic(records);
        
    	//Do OverAll Check
        String myTest = logic.doTests();
        
        //Show Result Of OverAll Check
        System.out.println(myTest);
        
    }
}