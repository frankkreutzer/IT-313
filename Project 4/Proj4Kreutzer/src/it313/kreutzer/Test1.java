package it313.kreutzer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test1 {
	Transaction t1;
	GoldTransaction gold;
	LumberTransaction lumber;
	
	@BeforeEach
	void setUp() {
		t1 = new Transaction(512, "Cody", "Target", 25.41, "2014-05-14 5:23 PM");
		gold = new GoldTransaction(20, 3);
		lumber = new LumberTransaction("Maple", 2);
	  }
	
	@Test
	public void test() {
		//Transaction class tests
		assertEquals(512, t1.getId());
		assertEquals("Cody", t1.getBuyer());
		assertEquals("Target", t1.getSeller());
		assertEquals(25.41, t1.getPrice());
		assertEquals("2014-05-14 5:23 PM", t1.getTimeStamp());
		assertEquals("id=512 buyer=Cody seller=Target price=25.41 timestamp=2014-05-14 5:23 PM", t1.toString());
		assertEquals(1, t1.compareTo(new Transaction()));
		
		Transaction t2 = new Transaction();
		assertEquals("id=0 buyer=null seller=null price=0.00 timestamp=null", t2.toString());

		
		//GoldTransaction class tests
		assertEquals(20, gold.getKarats());
		assertEquals(3, gold.getWeight());
		assertEquals("karats=20 weight=3.0", gold.toString());
		
		
		//LumberTransaction class tests
		assertEquals("Maple", lumber.getWoodType());
		assertEquals(2, lumber.getWoodGrade());
		assertEquals("woodType=Maple woodGrade=2", lumber.toString());		
	}
}
