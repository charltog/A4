package cs414.a4.gcharl;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntryGateTest {

	@Test
	public void testOpenEntryGate() {
		Garage g1 = new Garage(1);
		g1.getEntryGate().openEntryGate();
		assertEquals(g1.getEntryGate().getStatus(), gateStatus.Open);		
	}
	
	@Test
	public void testCloseEntryGate() {
		Garage g2 = new Garage(2);
		g2.getEntryGate().closeEntryGate();
		assertEquals(g2.getEntryGate().getStatus(), gateStatus.Closed);
	}
	@Test
	public void testIncrementTicketCount() {
		Garage g3 = new Garage(3);
		g3.getEntryGate().incrementTicketCount();
		assertEquals(g3.getEntryGate().getTicketCount(), 2);
	}
	@Test
	public void testRequestEntry() {
		Garage g4 = new Garage(4);
		Ticket t4 = g4.getEntryGate().requestEntry();
		assertTrue(t4.isValid());
		
	}


}
