package ui;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.commondatasetup;

@Test(groups = "user-regestration")
public class groupdemotesting extends commondatasetup {

	@BeforeClass
	public void btest4() {
		System.out.println("Run this before class");

	}

	@AfterClass
	public void btes5() {
		System.out.println("Run this after class");

	}

	@BeforeGroups(value = "regression")
	public void beforeGroup() {
		System.out.println("Run this before regression");

	}

	@AfterGroups(value = "regression")
	public void afterGroup() {
		System.out.println("Run this after regression");

	}

	@Test(priority = 1, groups = "regression")
	public void btest1() {
		System.out.println("test1");

	}

	@Test(priority = 2, groups = "regression")
	public void atest2() {
		System.out.println("test2");
		Assert.assertTrue(false);
	}

	@Test(groups = { "regression", "bvt" })
	public void atest3() {
		System.out.println("test3");
	}

	@Test(groups = "bvt")
	public void atest4() {
		System.out.println("test4");
	}
}
