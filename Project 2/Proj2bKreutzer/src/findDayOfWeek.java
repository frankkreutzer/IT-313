/*
 * Project 2b
 * Have the user enter in a date
 * The program will output the day of the week 
 * Of that date entered using the Calendar class
 */

import java.util.Calendar;
import java.util.Scanner;

public class findDayOfWeek {

	public static void main(String[] args) {    
		Calendar c = Calendar.getInstance(); //Creating a Calendar object with the system time
	    Scanner s = new Scanner (System.in);
	    try {
	        do {	        		
		        	//Enter the Month
		        	System.out.println("Enter the Month as a number:");
		        	int month= s.nextInt( );
		        	//c.set(Calendar.MONTH, month); //Overwrite the calendar object's month
	
		        	//Enter the Day
		        	System.out.println("Enter the Day as a number:");
		        	int dayIn= s.nextInt();
		        	//c.set(Calendar.DAY_OF_MONTH, dayIn); //Overwrite the calendar object's day
	
		        	//Enter the Year
		        	System.out.println("Enter the Year in as a number:");
		        	int year= s.nextInt( );
		        	//c.set(Calendar.YEAR, year); //Overwrite the calendar object's year
		        	
		        	c.set(year, month - 1, dayIn);
		            //System.out.println(c); //prints the entire c Calendar object info (testing purpose only)
	
		        	//Determine which day of the week the for the Calendar object
		        	int day =  c.get(Calendar.DAY_OF_WEEK);
		        	
		        	switch (day) {
		        		case Calendar.SUNDAY:
		        			System.out.println("Sunday");
		        			break;
		        		case Calendar.MONDAY:
		        			System.out.println("Monday");
		        			break;
		        		case Calendar.TUESDAY:
		        			System.out.println("Tuesday");
		        			break;
		        		case Calendar.WEDNESDAY:
		        			System.out.println("Wednesday");
		        			break;
		        		case Calendar.THURSDAY:
		        			System.out.println("Thursday");
		        			break;
		        		case Calendar.FRIDAY:
		        			System.out.println("Friday");
		        			break;
		        		case Calendar.SATURDAY:
		        			System.out.println("Saturday");
		        			break;
		        		default:
		        			System.out.println("Not a valid date");
		        	}
		        	
		        	System.out.println("To exit press CTRL+Z or any key to continue");
		        	s.nextLine();
	        }
	        while (s.hasNextLine());
	    }
	    finally {
	    	s.close();
	    	System.out.println("exiting");
	    }   
	}
}