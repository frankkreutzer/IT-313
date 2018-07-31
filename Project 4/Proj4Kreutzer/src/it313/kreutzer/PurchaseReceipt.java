/**
 * Interface for Transactions
 *
 * @author   Frank Kreutzer 
 * @version  1.0 2/27/2018   
 */

package it313.kreutzer;

public interface PurchaseReceipt extends Comparable<PurchaseReceipt> {
    public int getId( );
    public String getBuyer( );
    public String getSeller( );
    public double getPrice( );
    public String toString( );
}
