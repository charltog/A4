package cs414.a4.gcharl;

public class Payment {

	private double total;
	private FormOfPayment FOP;

	public Payment(double total, FormOfPayment FOP) {
		this.total = total;
		this.FOP = FOP;
	}

	public boolean processPayment() {
		return processPayment(this.total, this.FOP);
	}

	private boolean processPayment(double total2, FormOfPayment FOP2) {
		// charge, debit, credit accounts as needed
		// 
		return true;
	}

}
