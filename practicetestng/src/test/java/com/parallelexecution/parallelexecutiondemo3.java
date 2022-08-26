package com.parallelexecution;

import org.testng.annotations.Test;

public class parallelexecutiondemo3 {

	@Test
	public void Test8() {
		System.out.println("Test calss3 >> Testmethod8 >> "+Thread.currentThread().getId());
	}
	@Test
	public void Test9() {
		System.out.println("Test calss3 >> Testmethod9 >> "+Thread.currentThread().getId());
	}
	@Test
	public void Test10() {
		System.out.println("Test calss3 >> Testmethod10 >> "+Thread.currentThread().getId());
	}
	@Test
	public void Test11() {
		System.out.println("TestClaa3 >> TestMethod11 >> " +Thread.currentThread().getId());
	}
}
