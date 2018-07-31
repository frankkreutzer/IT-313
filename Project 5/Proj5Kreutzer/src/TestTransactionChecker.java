import java.io.FileNotFoundException;

public class TestTransactionChecker {

	public static void main(String[] args) throws FileNotFoundException {
		TransactionChecker tc = new TransactionChecker("transactions.txt"); //TransactionChecker object
		TransactionLogger tl = new TransactionLogger("log.txt"); //TransactionLogger object
		tc.addObserver(tl);
		tc.checkTransactions();
	}

}
