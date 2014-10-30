package cs414.a4.gcharl;

import static org.junit.Assert.*;

import org.junit.Test;

public class SystemLogTest {

	@Test
	public void testAddLogEvent() {
		Garage g1 = new Garage(1);
		SystemLog log1 = g1.getSystemLog();
		SystemLogEvent event1 = new SystemLogEvent(g1, this.getClass().getName(), "Test Description", g1.getDateTime());
		log1.addLogEvent(event1);		
		assertTrue(log1.log.contains(event1));
	}

}
