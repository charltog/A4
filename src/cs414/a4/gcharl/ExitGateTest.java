package cs414.a4.gcharl;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitGateTest {

	@Test
	public void testOpenExitGate() {
		Garage g1 = new Garage(1);
		g1.getExitGate().openExitGate();
		assertEquals(g1.getExitGate().getStatus(), gateStatus.Open);	
	}
		
	@Test
	public void testCloseExitGate() {
		Garage g2 = new Garage(2);
		g2.getExitGate().closeExitGate();
		assertEquals(g2.getExitGate().getStatus(), gateStatus.Closed);
	}
	
	@Test
	public void testRequestExit() {
		Garage g3 = new Garage(3);
		for (int i=0; i<5; i++) {
			g3.increaseCurrentOccupancyByOne();				// should have 5 now
		}
		Ticket t3 = new Ticket(g3.getDateTime(), 3, g3);		
		Sale s3 = g3.getExitGate().requestExit(t3);
		//assertEquals(t3.isValid(), false);
		assertTrue(g3.getExitGate().getSales().contains(s3));
	}

}
