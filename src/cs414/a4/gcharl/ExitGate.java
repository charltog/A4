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
	
	public void exitGarage()	{
		this.garage.decreaseCurrentOccupancyByOne();
	}

	public Sale requestExit(Ticket t1) {
		Sale s1 = null;
		if (!t1.isValid()) {			
			//Ticket not valid, charge default fee and allow exit
//		} else if (FOP == null) {
//			// need a valid FOP 
//			s1 = createSale(t1);
//			Sales.add(s1);			
		} else {
			s1 = createSale(t1);
			Sales.add(s1);
			//Payment p1 = createPayment(s1.getTotal(), FOP);
			//confirmTotal();
			//p1.processPayment();
			//this.garage.decreaseCurrentOccupancyByOne();
			//t1.retire();
		}
		return s1;
		
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

	public Sale findSaleByTicketId(Ticket t1) {
		Sale s1 = null;
		for (Sale s : garage.getExitGate().Sales) {
			if (s.getTicket() == t1) {
				s1 = s;
			}
		}
		return s1;
	}

	public boolean makePayment(Sale s1, int payAmt, FormOfPayment FOP) {
		boolean result = false;
		if (FOP==FormOfPayment.Cash || FOP == FormOfPayment.CreditCard) {
			int newTotal = s1.getRoundedTotal() - payAmt;
			s1.setTotal((double)newTotal);
			result = true;
		}
		return result;
	}


}
