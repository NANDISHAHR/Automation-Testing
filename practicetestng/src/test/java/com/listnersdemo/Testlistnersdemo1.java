package com.listnersdemo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

@Listeners({iTestlisnersclass.class})
public class Testlistnersdemo1 {

	@Test
	public void test1() {
		
		System.out.println("Test1");
		assertTrue(false);
	}
	@Test
	public void test2() {
		
		System.out.println("Test2");
	}
	@Test(timeOut = 1000)
	public void test3() throws Exception {
		
		System.out.println("Test3");
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = "test3")
	public void test4() {
		
		System.out.println("Test4");
	}
}
