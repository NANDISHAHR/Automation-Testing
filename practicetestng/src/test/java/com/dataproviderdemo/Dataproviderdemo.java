package com.dataproviderdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderdemo {

	@Test(dataProvider = "Objectcollection")
	public void datalogin(Object[] s) {
		//System.out.println(s);
		System.out.println(s[0]+ " >> "+s[1]);
		// System.out.println(username+ " >> "+password);
		/*
		 * for (int i = 0; i < s.length; i++) { System.out.println(s[i]); }
		 * System.out.println("<<<<");
		 */
	}

	// String Array
	@DataProvider(name = "login")
	public String[] data() {
		String[] data = new String[] { "abcd", "xyz", "ysd" };
		return data;

		// data[0] = "abcd";
		// data[1] = "cdef";

	}

	// Intergar Array
	@DataProvider(name = "Integardata")
	public Integer[] intdata() {
		Integer[] data1 = new Integer[] { 1, 2, 3 };
		return data1;
	}

	// Combination of String,Float and Integer
	@DataProvider(name = "multiple")
	public Object[] multipledata() {
		Object[] data2 = new Object[] { 1, "Hello", 3, 4.2

		};
		return data2;
	}

	// 2D String Array

	@DataProvider(name = "2dString")
	public String[][] string2d() {
		String[][] data3 = new String[][] { { "hye", "anc" }, { "bcd", "efg" }, { "hij", "lmn" } };
		return data3;
	}

	// 2d Integer
	@DataProvider(name = "2dInteger")
	public Integer[][] integer2d() {
		Integer[][] data4 = new Integer[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		return data4;
	}

	// OBject Array 2d
	@DataProvider(name = "2dmultiple")
	public Object[][] mutiple2d() {
		Object[][] data5 = new Object[][] { { "HYR", 5 }, { 2.3, "abcd" }, { 4, "lgh" } };
		return data5;
	}

	// Jagged array
	@DataProvider(name = "2dmultiple1")
	public Object[][] mutiple1d() {
		Object[][] data6 = new Object[][] { { "HYR", 5, "567", "abcd" }, { 2.3, "abcd" }, { 4, "lgh", 9, "abcd" } };
		return data6;
	}

	@DataProvider(name = "listtypedata")
	public Iterator<String> listtype() {
		List<String> data7 = new ArrayList<>();

		data7.add("Nandish");
		data7.add("ABCD");
		
		return  data7.iterator();
	}
	
	@DataProvider(name= "Listtypedata")
	public Iterator<String> setdatatype() {
		Set<String> data8 = new HashSet<>();
		
		data8.add("ABCDEF");
		data8.add("xyz");
		return data8.iterator();
	}
	
	@DataProvider(name= "Stringcollection")
	public Iterator<String[]> arraystring() {
		
		List<String[]> data9 = new ArrayList<>();
		data9.add(new String[] {"ABc", "def"});
		data9.add(new String[] {"ghI","LMN"});
		
		return data9.iterator();
	}
	
	@DataProvider(name= "Objectcollection")
	public Iterator<Object[]> Objectstring() {
		
		List<Object[]> data10 = new ArrayList<>();
		data10.add(new Object[] {"ABc", "123"});
		data10.add(new Object[] {234,"LMN"});
		
		return data10.iterator();
	}
}
