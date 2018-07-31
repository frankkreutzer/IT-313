/**
 * Create Transactions of lumber
 *
 * @author   Frank Kreutzer 
 * @version  1.0 2/27/2018   
 */

package it313.kreutzer;

public class LumberTransaction extends Transaction{
	private static final long serialVersionUID = 1L;

	/** Holds the String value of the LumberTransactionTransaction wood type. */
	private String _woodType;
	
	/** Holds the integer value of the LumberTransactionTransaction wood grade. */
	private int _woodGrade;
	
	/**
	 * Parameterized constructor.
	 *                 
	 * @param  theWoodType (required) the type of wood 
	 * @param  theWoodGrade (required) the grade of the wood (1-4)
	 */
	public  LumberTransaction(String theWoodType, int theWoodGrade) {
		this._woodType = theWoodType;
		this._woodGrade = theWoodGrade;
	}

	/** Non-parameterized constructor. */
	public LumberTransaction() {}
	
	/** 
     * Return the type of wood passed to the constructor.
     * 
     * @return String wood type value of the transaction
	 */
	public String getWoodType() {
		return _woodType;
	}
	
	/** 
     * Return the grade of the wood passed to the constructor.
     * 
     * @return integer wood grade value of the transaction
	 */
	public int getWoodGrade () {
		return _woodGrade;
	}
	
	/** 
	  * Return a formated String of the objects parameter values.
	  * 
	  * @return String with all the object parameter values
	  */
	@Override
    public String toString() {
        return String.format("woodType=%s woodGrade=%d" , _woodType, _woodGrade);
    }

}
