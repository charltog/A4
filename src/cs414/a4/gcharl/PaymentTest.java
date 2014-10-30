package cs414.a4.gcharl;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentTest {

	@Test
	public void testProcessPaymentCC() {					// credit card
		double total1 = 7.00;
		FormOfPayment fop1 = FormOfPayment.CreditCard;
		Payment p1 = new Payment(total1, fop1);
		assertTrue(p1.processPayment());
	}

	@Test
	public void testProcessPaymentCash() {					// cash
		double total2 = 7.00;
		FormOfPayment fop2 = FormOfPayment.Cash;
		Payment p2 = new Payment(total2, fop2);
		assertTrue(p2.processPayment());
	}
}
