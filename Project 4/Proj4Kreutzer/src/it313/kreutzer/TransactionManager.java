/**
 * Manage Transaction objects
 *
 * @author   Frank Kreutzer 
 * @version  1.0 2/27/2018   
 */

package it313.kreutzer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class TransactionManager extends Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** An ArrayList collection of PurchaseReceipts. */
	private ArrayList<PurchaseReceipt> _col;
	
	/** Non-parameterized constructor for an ArrayList collection of PurchaseReceipts. */
	public TransactionManager() {
		this._col = new ArrayList<PurchaseReceipt>();
	}

	/** 
	 * Add a PurchaseReceipt to the collection. 
	 * 
	 * @param theTransaction (required) the Transaction object that's to be added to the collection
	 */
	public void add(Transaction theTransaction) {
        _col.add(theTransaction);
    }

	/** Return the amount of PurchaseReceipt objects in the collection. 
	 * 
	 * @return Integer of the amount of objects in the collection
	 */
	public int count() {
		return _col.size();
	}
	
	/** Display all of the PurchaseReceipt objects in the collection, then sorts them by their ID. 
	 * 
	 * @return ArrayList of of the PurchaseReceipts
	 */
	public ArrayList<PurchaseReceipt> displayAll() {
		ArrayList <PurchaseReceipt> transactions = new ArrayList <PurchaseReceipt>();
		for(PurchaseReceipt pr : _col) {
			transactions.add(pr);
		}
		Collections.sort(transactions);
		return transactions;
	}
	
	/** Find specific buyers, add them to an ArrayList, then sorts them by their ID. 
	 * 
	 * @param theBuyer (required) the name of the buyer
	 * @return ArrayList of of the buyers sorted by their ID
	 */
	public ArrayList<PurchaseReceipt> findBuyer(String theBuyer) {
		ArrayList <PurchaseReceipt> buyers = new ArrayList <PurchaseReceipt>();
		for(PurchaseReceipt pr : _col) {
			if (pr.getBuyer().equals(theBuyer)) {
				buyers.add(pr);
			}
		}
		Collections.sort(buyers);
		return buyers;
	}
	
	/** Find specific sellers, add them to an ArrayList, then sorts them by their ID. 
	 * 
	 * @param theSeller (required) the name of the seller
	 * @return ArrayList of of the sellers sorted by their ID
	 */
	public ArrayList<PurchaseReceipt> findSeller(String theSeller) {
		ArrayList <PurchaseReceipt> sellers = new ArrayList <PurchaseReceipt>();
		for(PurchaseReceipt pr : _col) {
			if (pr.getSeller().equals(theSeller)) {
				sellers.add(pr);
			}
		}
		Collections.sort(sellers);
		return sellers;
	}
	
	/** Find specific PurchaseReceiptbased on its ID. 
	 * 
	 * @param theId (required) the ID of the TransactionReceipt
	 * @return PurchaseReceipt object based on the PurchaseReceipt's ID
	 */
	public PurchaseReceipt findId(int theId) {
		for(PurchaseReceipt pr : _col) {
			if (theId == pr.getId()) {
		        return pr;
			}
		}
		return null;
	}
	
	/** Remove a specific PurchaseReceipt object based on it's index. 
	 * 
	 * @param theIndex (required) the index of the desired PurchaseReceipt to be removed from the collection
	 */
	public void remove(int theIndex) {
		 _col.remove(theIndex);
	    }
	
	/** 
	 * Deserialize _col from Transactions.ser. 
	 * 
	 * @throws IOException if an I/O exception of some sort has occurred
	 * @throws ClassNotFoundException if if a CNF exception of some sort has occurred
	 */
	@SuppressWarnings("unchecked")
    public void load() throws IOException, 
        ClassNotFoundException {
        ObjectInputStream inStream = 
            new ObjectInputStream(new FileInputStream("transactions.ser"));
        _col = (ArrayList<PurchaseReceipt>)
        		inStream.readObject( );
        inStream.close( );
    }
	
	
	/** Serialize _col to transactions.ser file. 
	 *
	 * @throws IOException if an I/O exception of some sort has occurred
	 */
	public void save() throws IOException {
        ObjectOutputStream outStream = 
        		new ObjectOutputStream(new FileOutputStream("transactions.ser"));
        outStream.writeObject(_col);
        outStream.close( );
	}
}
