package com.dataproviderdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderdemo3 {

	
	@Test(dataProvider = "Data")
	public void dataproviderindices(String s) {

		System.out.println(s);
	}

	@DataProvider(name = "Data",indices = {0,2} )
	public String[] data() {
		String[] data1 = new String[] { "Nandish", "ABCD", "Dayana", "ABCD" };
		return data1;
	}
}
