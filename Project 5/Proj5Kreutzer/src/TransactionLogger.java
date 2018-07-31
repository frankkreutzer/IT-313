// Source code file TransactionLogger.java
// For Project 5.
// To be modified.

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;
public class TransactionLogger implements Observer{
    PrintWriter _log;
    
    public TransactionLogger(String fileName) 
        throws FileNotFoundException {
        _log = new PrintWriter(fileName);
    }

	@Override
	public void update(Observable obs, Object info) {
		_log.println(info); //prints the object to the log file
		//System.out.println("test"); //testing line
		_log.flush();
	}
}