package ui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderdemotest {

	@Test(dataProvider = "dataset")
	public void test(String Username, String Paasword) {
		System.out.println(Username + "=====" + Paasword);

	}

	@Test(dataProvider = "create")
	public void test1(String Username, String Paasword , String test) {
		System.out.println(Username + "=====" + Paasword+"===="+test);

	}

	@DataProvider(name= "create")
	public Object[][] dataset1() {

		return new Object[][] { { "username", "password", "test1" }, { "username1", "password1", "test2" },
				{ "username2", "pssword2", "test3" } };
	}
	@DataProvider
	public Object[][] dataset() {

		Object[][] dataset = new Object[4][2];
		// first row
		dataset[0][0] = "user1";
		dataset[0][1] = "password1";

		// second row
		dataset[1][0] = "user2";
		dataset[1][1] = "password2";

		// Third row
		dataset[2][0] = "user3";
		dataset[2][1] = "password3";

		// fourth row
		dataset[3][0] = "user4";
		dataset[3][1] = "password4";

		return dataset;
	}

	
}
