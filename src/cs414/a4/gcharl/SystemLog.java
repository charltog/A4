package cs414.a4.gcharl;

import java.util.HashSet;

public class SystemLog {
	public HashSet<SystemLogEvent> log = new HashSet<SystemLogEvent>();
	
	public void addLogEvent(SystemLogEvent event) {
		this.log.add(event);
	}
	
	public HashSet<String> displayLog() {
		HashSet<String> logStrings = new HashSet<String>();
		for (SystemLogEvent e : this.log) {
			logStrings.add(e.toString());
		}
		return logStrings;
	}
	
}
