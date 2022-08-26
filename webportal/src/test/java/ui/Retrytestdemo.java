package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.basetest;

public class Retrytestdemo extends basetest {

	@Test(retryAnalyzer = common.Retry.class)
	public void launchapp1() {
		
		driver.get("https://ebay.com");
		Assert.assertTrue(false);
		
	}
}
