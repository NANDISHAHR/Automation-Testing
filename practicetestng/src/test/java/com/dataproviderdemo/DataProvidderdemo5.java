package com.dataproviderdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvidderdemo5 {

	@Test(dataProvider = "getdata", dataProviderClass = xlsdatasupplier.class)
	public void dataexceldemo(String userName , String password) throws Exception {
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
}
