package it313.kreutzer;

import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TransactionManager tm = new TransactionManager();
		System.out.println(tm.count());
		
		//object 1 (Transaction)
		Transaction t3 = new Transaction(801, "Frank", "Kohls", 85.15, "2018-02-14 11:41 AM");
		tm.add(t3);
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		System.out.println(tm.count()); //test to see if add() and count() work
		
		for(PurchaseReceipt pr : tm.findSeller("Kohls")) {
			System.out.println(pr);
		}
		tm.save(); //save all the transaction into the file
		tm.remove(0); //remove the transaction to check of load() works
		System.out.println(tm.count());
		//testing to see of load() works
		tm.load();
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		
		//object 2 (Transaction)
		Transaction t4 = new Transaction(820, "Luke", "Kohls", 15.99, "2018-02-18 09:20 AM");
		tm.add(t4);
		System.out.println(tm.count());
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		for(PurchaseReceipt pr : tm.findBuyer("Frank")) {
			System.out.println(pr);
		}
		System.out.println("");
		for(PurchaseReceipt pr : tm.findSeller("Kohls")) {
			System.out.println(pr);
		}
		tm.save();
		System.out.println("");

		
		//object 3 (GoldTransaction)
		GoldTransaction g2 = new GoldTransaction(24, 6);
		tm.add(g2);
		System.out.println(tm.count());
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		System.out.println(g2.getKarats());
		System.out.println("");

		
		//object 4 (GoldTransaction)
		GoldTransaction g3 = new GoldTransaction(12, 0.5);
		tm.add(g3);
		System.out.println(tm.count());
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		System.out.println(g3.getWeight());
		tm.save();
		System.out.println("");

		//object 5 (LumberTransaction)
		LumberTransaction l2 = new LumberTransaction("Oak", 3);
		tm.add(l2);
		System.out.println(tm.count());
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		System.out.println(l2.getWoodType());
		System.out.println("");
		
		//object 6 (LumberTransaction)
		LumberTransaction l3 = new LumberTransaction("Cedar", 1);
		tm.add(l3);
		System.out.println(tm.count());
		for(PurchaseReceipt pr : tm.displayAll()) {
			System.out.println(pr);
		}
		System.out.println(l3.getWoodGrade());
		tm.save();

		

		
		
	}

}
