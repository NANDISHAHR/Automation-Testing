package practicetestng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependcy {

	static String tracknumber = null;

	@Test()
	public void CreateShipment() {
		System.out.println(5 / 0);
		System.out.println("CreateShipment");
		tracknumber = "AB15EF";
	}

	@Test(dependsOnMethods = { "CreateShipment" }, alwaysRun = true, ignoreMissingDependencies = true)
	public void Trackshipment() throws Exception {
		if (tracknumber != null)
			System.out.println("Trackshipment");
		else
			throw new Exception("Invalid tracking number");
	}

	@Test(dependsOnMethods = { "CreateShipment" })
	public void CancelShipment() throws Exception {
		if (tracknumber != null)
			System.out.println("Trackshipment");
		else
			throw new Exception("Invalid tracking number");
		System.out.println("CancelShipment");
	}
}
