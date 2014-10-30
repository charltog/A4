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

	private boolean processPayment(double total2, FormOfPayment FOP) {
		// charge, debit, credit accounts as needed
		//
		boolean result = false;
		if ((FOP == FormOfPayment.CreditCard) || (FOP == FormOfPayment.Cash)) {
			return true;
		}
		return result;
	}

}
