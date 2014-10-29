package cs414.a4.gcharl;

import java.util.Date;

public class EntryGate {

	private int Id;
	private gateStatus status;
	private Garage garage;
	private int ticketCount;

	public EntryGate(int Id, int initialTicketCount, Garage g1) {
		this.Id = Id;
		this.ticketCount = initialTicketCount;
		this.garage = g1;
		this.status = gateStatus.Closed;
	}

	void openEntryGate() {
		setStatus(gateStatus.Open);
	}
	
	void closeEntryGate() {
		setStatus(gateStatus.Closed);		
	}

	public gateStatus getStatus() {
		return this.status;
	}

	private void setStatus(gateStatus status) {
		this.status = status;
	}

	public void incrementTicketCount() {
		this.ticketCount++;		
	}

	public int getTicketCount() {
		return this.ticketCount;
	}

	public Garage getGarage() {
		return this.garage;
	}

	public Ticket requestEntry() {
		Ticket t1 = new Ticket();
		Date startTime;
		if(!this.garage.isGarageAcceptingVehicles()) {
			//Deny Entry
		} else {			
			startTime = this.garage.getDateTime();
			t1 = new Ticket(startTime, this.ticketCount, this.garage);	
			this.incrementTicketCount();
			this.garage.increaseCurrentOccupancyByOne();
		}
		return t1;
	}
	

}
