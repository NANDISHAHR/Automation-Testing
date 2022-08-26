package com.parallelexecution;

import org.testng.annotations.Test;

public class parallelexedemo1 {

	@Test
	public void Test1() {
		System.out.println("Test calss1 >> Testmethod1 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void Test2() {
		System.out.println("Test calss1 >> Testmethod2 >> "+Thread.currentThread().getId());
	}
	@Test
	public void Test3() {
		System.out.println("Test calss1 >> Testmethod3 >> "+Thread.currentThread().getId());
	}
	@Test
	public void Test4() {
		System.out.println("Test calss1 >> Testmethod4 >> "+Thread.currentThread().getId());
	}
}
