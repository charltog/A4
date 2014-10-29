package cs414.a4.gcharl;

public class GarageDescription {
	
	

	private SystemStatus status = SystemStatus.ShutDown;
	private int maxOccupancy = 200;
	private int currentOccupancy = 0;

	public SystemStatus getSystemStatus() {
		calculateSystemStatus();
		return status;
	}

	private void calculateSystemStatus() {
		if (maxOccupancy>currentOccupancy) {
			status = SystemStatus.Vacancy;
		} else {
			status = SystemStatus.NoVacancy;
		}
		
	}

}
