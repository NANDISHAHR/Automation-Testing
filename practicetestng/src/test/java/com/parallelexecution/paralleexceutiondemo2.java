package com.parallelexecution;

import org.testng.annotations.Test;

public class paralleexceutiondemo2 {

	@Test
	public void Test5() {
		System.out.println("Test calss2 >> Testmethod5 >> "+Thread.currentThread().getId());
	}
	@Test
	public void Test6() {
		System.out.println("Test calss2 >> Testmethod6 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void Test7() {
		System.out.println("TestClass2 >> Test Method7 >> "+Thread.currentThread().getId());
	}
	
}
