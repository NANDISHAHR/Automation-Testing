package ui;

import org.testng.annotations.Test;

import common.commondatasetup;


public class groupdemotesting2 extends commondatasetup {


	@Test(priority = 1, groups = "regression")
	public void btest1() {
		System.out.println("test1");

	}

	@Test(priority = 2, groups = "regression")
	public void atest2() {
		System.out.println("test2");
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
