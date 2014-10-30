package cs414.a4.gcharl;

import java.util.HashSet;

public class ExitGate {

	HashSet<Sale> Sales = new HashSet<Sale>();
	private int Id;
	private Garage garage;
	private gateStatus status;
	
	public ExitGate(int id, Garage garage) {
		this.Id = id;
		this.garage = garage;
		status = gateStatus.Closed;
	}

	public HashSet<Sale> getSales() {
		// TODO Auto-generated method stub
		return Sales;
	}

	public void openExitGate() {
		setStatus(gateStatus.Open);		
	}

	public void closeExitGate() {
		setStatus(gateStatus.Closed);
	}
	
	public gateStatus getStatus() {
		return status;
	}

	private void setStatus(gateStatus status) {
		this.status = status;
	}

	public void requestExit(Ticket t1, FormOfPayment FOP) {
		if (!t1.isValid()) {
			//Ticket not valid, charge default fee and allow exit
		} else {
			Sale s1 = createSale(t1);
			Sales.add(s1);
			Payment p1 = createPayment(s1.getTotal(), FOP);
			confirmTotal();
			p1.processPayment();
			this.garage.decreaseCurrentOccupancyByOne();
			t1.retire();
		}
		
	}

	private Payment createPayment(double total, FormOfPayment FOP) {
		SystemLogEvent event = new SystemLogEvent(this.garage, "Payment by " + FOP + " for " + total + " Created", ExitGate.class.getName(), this.garage.getDateTime());
		this.garage.systemLog.addLogEvent(event);
		return new Payment(total, FOP);
	}

	private Sale createSale(Ticket t1) {
		SystemLogEvent event = new SystemLogEvent(this.garage, "Sale for Ticket " + t1 + " Created", ExitGate.class.getName(), this.garage.getDateTime());
		this.garage.systemLog.addLogEvent(event);
		return new Sale(t1);		
	}

	private void confirmTotal() {
		// TODO Auto-generated method stub
		
	}


}
