package cs414.a4.gcharl;

public class Garage {

	private int Id;
	private EntryGate entryGate;
	private ExitGate exitGate;
	
	public Garage(int id) {
		this.Id = id;
		entryGate = createEntryGate();
	}

	private EntryGate createEntryGate() {
		return createEntryGate(this.Id);
	}

	private EntryGate createEntryGate(int id) {
		int initialTicketCount = 1;
		return new EntryGate(id, initialTicketCount);		
	}

	public EntryGate getEntryGate() {
		return entryGate;
	}

	public ExitGate getExitGate() {
		return exitGate;
	}

}
