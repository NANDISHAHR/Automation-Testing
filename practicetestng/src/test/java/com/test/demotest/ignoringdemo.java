package com.test.demotest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ignoringdemo {

	
	@Test(enabled = true)
	public void Test1() {
		System.out.println("Test1");
	}

	
	public void Test2() {
		System.out.println("Test2");
	}
	
	@Test
	public void Test3() {
		System.out.println("Test3");
	}
}

