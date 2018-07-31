import java.util.Scanner;

public class metarAbbrev {

	public static void main(String[] args) {
		// Create a scanner to take an input
		// Use nextLine () to read the next line of input, and save it
	
		Scanner in = new Scanner(System.in);
		System.err.print("Enter a METAR abbreviation: ");
		String abbreviation = in.nextLine( ).toUpperCase();
		
		// Declare and initialize meaning
		String meaning = "";
		
		// Created a boolean to ensure that when an unknown abbreviation is caught
		// The print statement after the switch statement won't print as well
		boolean meaningPrint = true;
		
		// Use switch statements to check for valid abbreviation inputs
		// Then set the meaning of accordingly based on the abbreviation
		switch (abbreviation) {
			case  "+" :
				meaning = "heavy intensity";
				break;
			case  "-" :
				meaning = "low intensity";
				break;
			case  "B" :
				meaning = "began at time";
				break;
			case  "E" :
				meaning = "ended at time";
				break;
			case  "RA" :
				meaning = "rain";
				break;
			case  "DZ" :
				meaning = "drizzle";
				break;
			case  "HZ" :
				meaning = "haze";
				break;
			case  "SN" :
				meaning = "snow";
				break;
			default :
				System.out.println("Unknown abbreviation"); // If none of the above cases occur, output this
				meaningPrint = false;
		}
		// Only print this line when meaningPoint is true
		if (meaningPrint) {
			System.out.println("The abbreviation means " + meaning);
		}
        in.close( ); // Closes the Scanner
	}
}
