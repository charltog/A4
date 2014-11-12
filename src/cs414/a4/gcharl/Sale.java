package cs414.a4.gcharl;

import java.text.NumberFormat;
import java.util.Date;
//import java.math.*;

public class Sale {
	
	private Ticket ticket;
	

	private double total;
	private Date entryTime;
	private Date exitTime;
	private double parkingRate = 0.00;
	private double amtPaid = 0.00;
	public int roundedTotal=0;
	private double change = 0.00;

	public Sale(Ticket t1) {
		if (t1.isValid()) {
			this.ticket = t1;
			this.entryTime = this.ticket.getEntryTime();
			this.exitTime = this.ticket.getGarage().getDateTime();
			this.parkingRate = this.ticket.getGarage().getParkingRate();
			calculateTotal();
			//this.total = calculateTotal(entryTime, exitTime, parkingRate);
			//this.roundedTotal = (int)(Math.floor(total) +1);
		}
//		} else {
//			this.total = 0.0;
//			this.roundedTotal = 0;
//		}
	}

	public void setTotal(double total) {
		//NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		//this.total = currencyFormatter.format(total);
		this.total = total;
		this.roundedTotal = (int)Math.ceil(total);
	}

	public void setAmtPaid(double amtPaid) {
		this.amtPaid = amtPaid;
	}

	public double getTotal() {		
		return this.total;
	}

	public void calculateTotal() {
		this.total = calculateTotal(this.entryTime, this.exitTime, this.parkingRate);
	}
	
	private double calculateTotal(Date entryTime, Date exitTime, double parkingRate) {
		double timeParked = exitTime.getTime() - entryTime.getTime();
		double subtotal = (timeParked/3600000)*parkingRate - this.amtPaid;
		if (this.ticket.isValid()) {	
			subtotal = Math.ceil(subtotal);			
			this.roundedTotal = (int)subtotal;
		} else {
			subtotal = 0.00;
			this.roundedTotal = 0;
		}
		
		return subtotal;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public int getRoundedTotal() {
		return roundedTotal;
	}

	public void setChange(double newTotal) {
		this.change = newTotal;
	}

	public double getChange() {
		return change;
	}
}
