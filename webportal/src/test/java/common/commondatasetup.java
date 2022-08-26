package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commondatasetup {

	@BeforeSuite
	public void datasetup() {

		System.out.println("common data setup");
	}

	@AfterSuite
	public void dataTeardown() {

		System.out.println("common data cleanup");
	}
}
