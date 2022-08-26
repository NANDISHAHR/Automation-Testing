package ui;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.basetest;

public class ReportTest extends basetest {

	@Test
	public void reporttest1() {

		System.out.println("this is test1");
		driver.get("https://salesforce.com");
		Assert.assertTrue(false);
	}

	@Test
	public void reporttest2() {

		Reporter.log("this is test2");
		System.out.println("this is test2");
	}

	@Test
	public void reporttest3() {

		System.out.println("this is test3");
	}

	@Test
	public void reporttest4() {

		System.out.println("this is test4");
	}
}
