package com.grouptest;

import org.testng.annotations.Test;

@Test(groups = {"all"})
public class newtest2 {

	@Test(groups = {"Windows.Smoke", "Sanity", "Ios.Sanity"})
	public void Test4() {
		System.out.println("Test4");
	}
	@Test(groups = {"Regression", "Functional", "Ios.Functional"})
	public void Test5() {
		System.out.println("Test5");
	}
	@Test
	public void Test6() {
		System.out.println("Test6");
	}
	@Test(groups = {"Smoke", "Regression" , "Functional"})
	public void Test7() {
		System.out.println("Test7");
	}

}
