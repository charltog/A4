package cs414.a4.gcharl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TicketTest {

	@Test
	public void testIsValid() {
		Garage g1 = new Garage(1);
		Ticket t1 = g1.getEntryGate().requestEntry();
		assertTrue(t1.isValid());		
	}

	@Test
	public void testRetire() {
		Garage g2 = new Garage(2);
		Ticket t2 = g2.getEntryGate().requestEntry();
		t2.retire();
		assertTrue(!t2.isValid());
	}

	@Test
	public void testGetGarage() {
		Garage g3 = new Garage(3);
		Ticket t3 = g3.getEntryGate().requestEntry();
		assertEquals(t3.getGarage(), g3);
	}

	@Test
	public void testGetEntryTime() {
		Garage g4 = new Garage(4);
		Date entryTime = g4.getDateTime();
		Ticket t4 = new Ticket(entryTime, 4, g4);		
		assertEquals(t4.getEntryTime(), entryTime);		
	}

}
