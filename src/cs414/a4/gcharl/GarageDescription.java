package cs414.a4.gcharl;


public class GarageDescription {
	
	

	private SystemStatus status = SystemStatus.ShutDown;
	private int maxOccupancy = 20;
	private int currentOccupancy = 0;
	private double hourlyParkingRate = 1.00;

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

	public void increaseCurrentOccupancyByOne() {
		currentOccupancy++;		
	}

	public double getCurrentParkingRate() {
		return hourlyParkingRate;
	}

	public void decreaseCurrentOccupancyByOne() {
		currentOccupancy--;
	}

}
