package cs414.a4.gcharl;

import java.util.Date;
import java.math.*;

public class Sale {
	
	private Ticket ticket;
	

	private double total;
	public int roundedTotal=0;

	public Sale(Ticket t1) {
		this.ticket = t1;
		Date entryTime = this.ticket.getEntryTime();
		Date exitTime = this.ticket.getGarage().getDateTime();
		double parkingRate = this.ticket.getGarage().getParkingRate();		
		this.total = calculateTotal(entryTime, exitTime, parkingRate);
		this.roundedTotal = (int)(Math.floor(total) +1);
	}

	public double getTotal() {		
		return this.total;
	}

	private double calculateTotal(Date entryTime, Date exitTime, double parkingRate) {
		double timeParked = exitTime.getTime() - entryTime.getTime();
		double subtotal = (timeParked/3600000)*parkingRate;
		return subtotal;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public int getRoundedTotal() {
		return roundedTotal;
	}
}
