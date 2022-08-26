package ui;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Dataproviderdemo2 {

	@DataProvider(name ="create")

	public Object[][] dataset1(Method m) {

		Object[][] testdata = null;
		if (m.getName().equals("test")) {

			testdata = new Object[][] { { "username", "password" }, { "username1", "password1" },
					{ "username2", "pssword2" } };
		}
		else if (m.getName().equals("test1")) {

			return new Object[][] { { "username", "password", "test1"}, { "username1", "password1", "test2"},
					{ "username2", "pssword2", "test3"},{"username3", "Password3", "test4"} };
		}

		else if (m.getName().equals("test2")) {

			return new Object[][] { { "username", "password", "test1" , "Fourth"}, { "username1", "password1", "test2" ,"Fourth1" },
					{ "username2", "pssword2", "test3" , "Fourth2"},{"username3", "Password3", "test4","Fourth4"} };
		}
		return testdata;

	}

}
