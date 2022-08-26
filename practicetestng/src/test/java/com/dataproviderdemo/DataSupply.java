package com.dataproviderdemo;

import org.testng.annotations.DataProvider;

public class DataSupply {

	@DataProvider(name = "Data" )
	public String[] data() {
		String[] data1 = new String[] { "Nandish", "ABCD", "Dayana", "ABCD" };
		return data1;
	}
	@DataProvider(name = "Data1" )
	public String[] data2() {
		String[] data1 = new String[] { "Nandish", "ABCD", "Dayana", "ABCD" };
		return data1;
	}
}
