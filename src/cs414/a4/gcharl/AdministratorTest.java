package cs414.a4.gcharl;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdministratorTest {

	@Test
	public void testIsDone() {
		Garage g1 = new Garage(1);
		Administrator a1 = new Administrator(1, g1);
		a1.setFinished(true);
		assertTrue(a1.isDone());
	}

	@Test
	public void testGetPassword() {
		Garage g2 = new Garage(2);
		Administrator a2 = new Administrator(2, g2);
		a2.setPassword("CS414");
		assertEquals(a2.getPassword(), "CS414");
	}

	@Test
	public void testGetId() {
		Garage g3 = new Garage(3);
		Administrator a3 = new Administrator(3, g3);
		assertEquals(a3.getId(), 3);
	}
	
	@Test
	public void testAdminLogin() {
		Garage g4 = new Garage(4);
		Administrator a4 = new Administrator(4, g4);
		a4.setPassword("CS414");
		a4.adminLogin(a4.getId(), a4.getPassword());
		assertTrue(!a4.isDone());
	}

}
