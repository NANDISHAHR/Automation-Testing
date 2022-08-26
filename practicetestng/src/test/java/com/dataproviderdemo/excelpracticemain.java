package com.dataproviderdemo;

import org.testng.annotations.Test;

import io.netty.util.internal.SystemPropertyUtil;

public class excelpracticemain {

	@Test(dataProvider = "data", dataProviderClass = practiceworkbook.class)
	public void excelmain(String[] s) {
		System.out.println(s);
	}
}
