package cs414.a4.gcharl;

public class Administrator {
	private Garage garage;
	private int Id = -1;
	private String password = "";
	private boolean finished = false;
	
	public Administrator(int id, Garage g1) {
		this.Id = id;
		this.garage = g1;
		this.finished = false;
	}

	public boolean isDone() {
		return this.finished;		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean adminLogin(int id, String password) {
		boolean result = false;
		if (this.Id == id && this.password == password) {
			result = true;
			
		}
		return result;
	}
}
