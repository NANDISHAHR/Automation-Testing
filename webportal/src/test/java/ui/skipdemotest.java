package ui;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class skipdemotest {

	Boolean datasetup = false;

	@Test(enabled = false)
	public void skiptest1() {

		System.out.println("Skipping this test case as test1 case is in progress");
	}

	@Test
	public void skiptest2() {

		System.out.println("Skipping this test case as test2 forcefully");
		throw new SkipException("Skipping this test");
	}

	@Test
	public void skiptest3() {
		System.out.println("Skipping this test case as test3 based on condition");
		if (datasetup == true) {

			System.out.println("Exceute test case");
		} else {
			System.out.println("Do not exceute test cases");
			throw new SkipException("Do not exceute test cases");
		}
	}
}
