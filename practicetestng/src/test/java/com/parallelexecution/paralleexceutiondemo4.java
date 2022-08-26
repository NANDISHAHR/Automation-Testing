package com.parallelexecution;

import org.testng.annotations.Test;

public class paralleexceutiondemo4 {

	@Test
	public void Test9() {
		System.out.println("TEST Class4>> TestMethod >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void Test8() {
		System.out.println("Test calss4 >> Testmethod8 >> "+Thread.currentThread().getId());
	}

	@Test
	public void Test10() {
		System.out.println("Test calss4 >> Testmethod8 >> "+Thread.currentThread().getId());
	}
}
