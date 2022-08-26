package practicetestng;

import org.testng.annotations.Test;

public class Flightbooking {

	@Test(priority = -1)
	public void signup() {
		System.out.println("SignUp");
		
	}
	// this will execute first as defalt value is 0
	@Test
	public void Login() {
		System.out.println("Login");
		
	}
	@Test(priority = 3)
	public void Serachfortheflight() {
		System.out.println("Search for the flights to book");
		
	}
	@Test(priority = 3)
	public void Booktheflight() {
		System.out.println("Book flight ticket");
		
	}
	@Test(priority = 5)
	public void saveTheticket() {
		System.out.println("Save the ticket");
		
	}
	@Test(priority = 6)
	public void Logout() {
		System.out.println("Logout");
		
	}
}
