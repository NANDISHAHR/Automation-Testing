package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		//driver.findElement(By.linkText("Create New Account")).click();
		
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("._6ltg>button")).click();
		//driver.findElement(By.linkText("Forgotten password?")).click();
		
		driver.findElement(By.cssSelector("._97w3>a")).click();
		
		
		

	}

}
