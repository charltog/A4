package cs414.a4.gcharl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class SaleTest {

	@Test
	public void testGetTotal() {
		Garage g1 = new Garage(1);
		Date exitDate = g1.getDateTime();
		long entryTime = exitDate.getTime()-36000000;
		Date entryDate = new Date(entryTime);
		double pRate = g1.getParkingRate();
		double total = 10 * pRate;
		
		Ticket t1 = new Ticket(entryDate, 1, g1);
		Sale s1 = new Sale(t1);
		double saleTotal = s1.getTotal();
		
		assertEquals((int)saleTotal, (int)total);
	}

}
