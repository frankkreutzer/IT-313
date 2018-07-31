/**
 * Create Transactions of gold
 *
 * @author   Frank Kreutzer 
 * @version  1.0 2/27/2018   
 */

package it313.kreutzer;

public class GoldTransaction extends Transaction {
	private static final long serialVersionUID = 1L;

	/** Holds the double value of the GoldTransaction karat amount. */
	private int _karats;
	
	/** Holds the double value of the GoldTransaction weight (in ounces). */
	private double _weight;
	
	/**
	 * Parameterized constructor.
	 *                 
	 * @param  theKarats (required) the amount of karats of gold.   
	 * @param  theWeight (required) the weight of the gold (in ounces). 
	 */
	public GoldTransaction(int theKarats, double theWeight) {
		this._karats = theKarats;
		this._weight = theWeight;
	}

	/** Non-parameterized constructor. */
	public GoldTransaction() {}
	
	/** 
     * Return the amount of karats of gold passed to the constructor.
     * 
     * @return double karats value of the transaction
	 */
	public int getKarats() {
		return _karats;
	}
	
	/** 
     * Return the weight passed to the constructor.
     * 
     * @return double weight value (in ounces) of the transaction
	 */

	public double getWeight () {
		return _weight;
	}
	
	 /** 
	  * Return a formated String of the objects parameter values.
	  * 
	  * @return String with all the object parameter values
	  */
	@Override
    public String toString() {
        return String.format("karats=%d weight=%.1f" , _karats, _weight);
    }
}
