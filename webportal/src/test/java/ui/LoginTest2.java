package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 {
	
	public static WebDriver driver;
	
	@Parameters({"browser"})

	@Test
	public void lunchapplication(String browser) {

		if (browser.equals("msEdge")) {
			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.close();
		

	}

}
