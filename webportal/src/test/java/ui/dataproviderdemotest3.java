package ui;

import org.testng.annotations.Test;

public class dataproviderdemotest3 {

	@Test(dataProvider = "create", dataProviderClass = Dataproviderdemo2.class)
	public void test(String Username, String Paasword) {
		System.out.println(Username + "=====" + Paasword);

	}

	@Test(dataProvider = "create",dataProviderClass = Dataproviderdemo2.class)
	public void test1(String Username, String Paasword , String test) {
		System.out.println(Username + "=====" + Paasword+"===="+test);

	}
	@Test(dataProvider = "create",dataProviderClass = Dataproviderdemo2.class)
	public void test2(String Username, String Paasword , String test , String test1) {
		System.out.println(Username + "=====" + Paasword+"===="+test+"===="+test1);

	}
}
