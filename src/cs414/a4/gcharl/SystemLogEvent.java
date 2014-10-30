package cs414.a4.gcharl;

import java.util.Date;

public class SystemLogEvent {
	
	private String description = "";
	private String sourceClassName = "";
	private Date eventTime = null;
	private Garage garage;
	
	public SystemLogEvent(Garage g1, String description, String className, Date eventTime) {
		this.garage = g1;
		this.description = description;
		this.sourceClassName = className;
		this.eventTime = eventTime;		
	}
	
	public String toString() {
		String result ="";
		result = result + "Garage: " + this.garage.getId() + "  Class: " + this.sourceClassName + "  desc: " + this.description + "  Time: " + this.eventTime + "\n";		
		return result;
	}
	
	
}
