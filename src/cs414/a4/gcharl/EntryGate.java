package cs414.a4.gcharl;

public class EntryGate {

	private int Id;
	private gateStatus status;
	private int ticketCount;

	public EntryGate(int Id, int initialTicketCount) {
		this.Id = Id;
		this.ticketCount = initialTicketCount;
		this.status = gateStatus.Closed;
	}

	void openEntryGate() {
		setStatus(gateStatus.Open);
	}
	
	void closeEntryGate() {
		setStatus(gateStatus.Closed);		
	}

	public gateStatus getStatus() {
		return status;
	}

	private void setStatus(gateStatus status) {
		this.status = status;
	}

	public void incrementTicketCount() {
		this.ticketCount++;		
	}

	public int getTicketCount() {
		return ticketCount;
	}

}
