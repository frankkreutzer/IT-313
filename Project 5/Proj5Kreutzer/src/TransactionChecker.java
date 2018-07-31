// Source Code File: TransactionChecker.java
// For Project 5S.
// To be modified.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Scanner;
public class TransactionChecker extends Observable{
    Scanner _in;
    int id = 1001;
    String name = "";
    String buyer = "";
    double amount = 0.0;
    String time = "";
    
    public TransactionChecker(String fileName) 
        throws FileNotFoundException {
        _in = new Scanner(new File(fileName));
    }
    
    public void checkTransactions( ) {
        while(_in.hasNextLine( )) {
            String line = _in.nextLine( );
            String[ ] fields = line.split(",");
            name = fields[0]; //gets the name field
            buyer = fields[1]; //gets the buyer field
            amount =  Double.parseDouble(fields[2]); //gets the amount field
            time = fields[3]; //gets the time stamp field
            //System.out.printf("%s %s %.2f %s\n", fields[0], fields[1], Double.parseDouble(fields[2]), fields[3]);
            Transaction t = new Transaction(id++, name, buyer, amount, time);
                        
            if (amount > 50000 && name.equals("Eugene Eko")) {
            	setChanged();
            	notifyObservers(t);
            }
        }
        _in.close( );
    }

}