package cs414.a4.gcharl;

import java.util.Date;

public class Ticket {

	private Date entryTime = null;
	private int Id = -1;
	private Garage garage = null;

	public Ticket(Date startTime, int ticketCount, Garage g1) {
		this.entryTime = startTime;
		this.Id = ticketCount;
		this.garage = g1;
	}

	public Ticket() {
		//Default
	}

	public boolean isValid() {
//		if (garage.getDateTime().after(entryTime) ) {
//			return true;
//		}
		//if (garage.getExitGate().lookupSaleByTicketId(this.Id).exists()) {
		if (this.garage == null) {
			return false;
		} else {
			return true;
		}
	}

	public int getId() {
		return Id;
	}

}
