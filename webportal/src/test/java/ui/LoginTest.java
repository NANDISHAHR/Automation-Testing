package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.commondatasetup;

public class LoginTest extends commondatasetup {

	@BeforeTest
	public void loginapplication() {

		System.out.println("login to application");

	}
  
	@AfterTest
	public void logoutapplication() {

		System.out.println("logout to application");

	}
	@BeforeMethod
    public void connectToDB() {
    	System.out.println("DB connected");
    	
    }
	@AfterMethod
    public void disconecFromDB() {
    	
    	System.out.println("DB is disconnected");
    }
    
	@Test(priority = 1, description = "This is login test", groups = "regression")
	public void bloginTest() {
		System.out.println("Login is successful");

	}

	@Test(priority = 2, description = "this is logout test")
	public void alogout() {
		System.out.println("Log out is successful");
	}

}
