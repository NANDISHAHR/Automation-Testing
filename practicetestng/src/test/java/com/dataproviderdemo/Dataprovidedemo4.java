package com.dataproviderdemo;

import org.testng.annotations.Test;

public class Dataprovidedemo4 {

	@Test(dataProvider = "Data", dataProviderClass = DataSupply.class )
	public void test1(String s) {
		System.out.println(s);
	}
}
