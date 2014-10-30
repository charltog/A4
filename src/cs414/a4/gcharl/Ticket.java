package cs414.a4.gcharl;

import java.util.Date;

public class Ticket {

	private Date entryTime = null;
	private int Id = -1;
	private Garage garage = null;
	private boolean valid = false;

	public Ticket(Date startTime, int ticketCount, Garage g1) {
		this.entryTime = startTime;
		this.Id = ticketCount;
		this.garage = g1;
		this.valid = true;
	}

	public Ticket() {
		//Default
	}
	
	public String toString() {
		String ticketString = ""+ this.Id;
		return ticketString;
	}

	public boolean isValid() {
//		if (garage.getDateTime().after(entryTime) ) {
//			return true;
//		}
		//if (garage.getExitGate().lookupSaleByTicketId(this.Id).exists()) {
		//if (this.garage == null) {
		if (this.valid == false) {
			return false;
		} else {
			return true;
		}
	}

	public void retire() {
		setIsValid(false);		
	}

	private void setIsValid(boolean b) {
		this.valid  = b;		
	}

	public Garage getGarage() {
		return garage;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public int getId() {
		return Id;
	}

}
