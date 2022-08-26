package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {

	public static WebDriver driver = null;

	@BeforeSuite
	public void lunchbrowser1() {

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
	}

	@AfterSuite
	public void closingbroswer() {

		driver.close();

	}
}
