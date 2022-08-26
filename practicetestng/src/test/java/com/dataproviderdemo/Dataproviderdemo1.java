package com.dataproviderdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataproviderdemo1 {

	
	@Test(dataProvider = "loginTestData")
	public void orangeHRM(String userName , String password) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.tagName("button")).click();
		driver.quit();
	}

	@DataProvider(name = "loginTestData")
	public Object[][] logindata() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "Test123";

		return data;
	}
	
}
