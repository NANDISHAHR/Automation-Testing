package com.grouptest;

import org.testng.annotations.Test;

public class newtest1 {
	
	@Test(groups = {"Smoke" , "Regression", "Windows.Snaity"})
	public void Test1() {
		System.out.println("Test1");
	}
	@Test(groups = {"Regression", "Sanity","Functional"})
	public void Test2() {
		System.out.println("Test2");
	}
	@Test(groups = {"Smoke" , "Regression", "Functional"})
	public void Test3() {
		System.out.println("Test3");
	}
}

