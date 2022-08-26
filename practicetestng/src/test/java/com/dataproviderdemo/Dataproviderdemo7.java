package com.dataproviderdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class Dataproviderdemo7 {

	@Test(timeOut = 2000)
	public void TestAttributes() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.quit();
	}

	@Test(expectedExceptions = { NoSuchElementException.class } )
	public void TestAttribute2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("")).click();
		driver.quit();
	}

}
