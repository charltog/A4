package cs414.a4.gcharl;

import java.util.HashSet;

public class ExitGate {

	HashSet<Sale> Sales = new HashSet<Sale>();
	private int Id;
	private Garage garage;
	
	public ExitGate(int id, Garage garage) {
		this.Id = id;
		this.garage = garage;
	}

	public HashSet<Sale> getSales() {
		// TODO Auto-generated method stub
		return Sales;
	}

}
