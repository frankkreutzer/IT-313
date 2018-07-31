/**
 * Create Transaction objects and get
 * specific details of the objects
 *
 * @author   Frank Kreutzer 
 * @version  1.0 2/27/2018   
 */

package it313.kreutzer;

import java.io.Serializable;

public class Transaction implements PurchaseReceipt, Serializable {
	private static final long serialVersionUID = 1L;

	/** Holds the integer value of the Transaction ID. */
	private int _id;
	
	/** Holds the String value of the Transaction buyer. */
	private String _buyer;

	/** Holds the String value of the Transaction seller. */
	private String _seller;
	
	/** Holds the double value of the Transaction price. */
	private double _price;
	
	/** Holds the String value of the Transaction time stamp. */
	private String _timeStamp;

	/**
	 * Parameterized constructor.
	 *                 
	 * @param  theId (required) the ID of the transaction   
	 * @param  theBuyer (required) the name of the buyer
	 * @param  theSeller (required) the name of the seller  
	 * @param  thePrice (required) the total cost of the transaction
	 * @param  theTimeStamp (required) the time of when the transaction was complete
	 */
	public Transaction(int theId, String theBuyer, String theSeller, double thePrice, String theTimeStamp) {
        this._id = theId;
        this._buyer = theBuyer;
        this._seller = theSeller;
        this._price = thePrice;
        this._timeStamp = theTimeStamp;
    }
	
	/** Non-parameterized constructor. */
	public Transaction() {}
	
	/** 
     * Return ID passed to the constructor.
     * 
     * @return integer id value of the transaction
	 */
	public int getId() {
		return _id;
	}
	
	/** 
	 * Return buyer name passed to the constructor.
	 * 
	 * @return String name of the buyer of the transaction
	 */
	public String getBuyer() {
		return _buyer;
	}
	
	/** 
	 * Return seller name passed to the constructor.
	 * 
	 * @return String name of the seller of the transaction
	 */
	public String getSeller() {
		return _seller;
	}
	
	 /** 
	  * Return price of the transaction passed to the constructor.
	  * 
	  * @return double price of the transaction
	  */
	public double getPrice() {
		return _price;
	}
	
	 /** 
	  * Return time stamp passed to the constructor.
	  * 
	  * @return String time stamp of when the transaction was completed
	  */
	public String getTimeStamp() {
		return _timeStamp;
	}
	
	 /** 
	  * Return a formated String of the objects parameter values.
	  * 
	  * @return String with all the object parameter values
	  */
	@Override
    public String toString() {
        return String.format("id=%d buyer=%s seller=%s price=%.2f timestamp=%s",       		
            _id, _buyer, _seller, _price, _timeStamp);
    }

	 /** 
	  * Return if the id of Transactions are higher or lower.
	  * 
	  * @return integer of the ID values of transactions (1 if larger, -1 is smaller, 0 if the same)
	  */
	@Override
	public int compareTo(PurchaseReceipt other) {
		return new Integer(this.getId()).compareTo(new Integer(other.getId()));   //1 if higher, -1 if lower, 0 if the same
	}
}

