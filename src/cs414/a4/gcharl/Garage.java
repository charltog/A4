package cs414.a4.gcharl;

import java.util.Date;

public class Garage {

	private int Id = 1;
	private EntryGate entryGate;
	private ExitGate exitGate;
	private GarageDescription garageDescription;
	
	public Garage(int id) {
		this.Id = id;
		entryGate = createEntryGate();
		exitGate = createExitGate();
		garageDescription = new GarageDescription();
	}

	public boolean equals(Object o) {
		boolean result = false;
		if (this.Id == ((Garage)o).getId()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	public int getId() {
		return this.Id;
	}

	private EntryGate createEntryGate() {
		return createEntryGate(this.Id);
	}

	private EntryGate createEntryGate(int id) {
		int initialTicketCount = 1;
		return new EntryGate(id, initialTicketCount, this);		
	}

	private ExitGate createExitGate() {
		return createExitGate(this.Id);
	}

	private ExitGate createExitGate(int id) {
		return new ExitGate(id, this);
	}
	
	public EntryGate getEntryGate() {
		return entryGate;
	}

	public ExitGate getExitGate() {
		return exitGate;
	}

	public Date getDateTime() {
		Date d1 = new Date();
		return d1;
	}

	public boolean isGarageAcceptingVehicles() {
		boolean isAccepting = false;
		if (garageDescription.getSystemStatus() == SystemStatus.Vacancy) {
			isAccepting = true;
		} else {
			isAccepting = false;
		}
		return isAccepting;
	}

	public void increaseCurrentOccupancyByOne() {
		garageDescription.increaseCurrentOccupancyByOne();		
	}

	public double getParkingRate() {
		return garageDescription.getCurrentParkingRate();
	}

	public void decreaseCurrentOccupancyByOne() {
		garageDescription.decreaseCurrentOccupancyByOne();
	}

}
