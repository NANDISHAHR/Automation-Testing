package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascripttextboxdemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
//1) Find element (JavaScript)  + text(JavaScript)
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("document.getElementById('email').value='abcd@gmail.com'");
		
		//2) Find element (Webdriver)  + text(JavaScript)
		
		WebElement element = driver.findElement(By.id("email"));
		
		js.executeScript("arguments[0].value='abcd@gmail.com'", element);
		String text = (String) js.executeScript("return document.getElementById('email').value");
		System.out.println(text);
		driver.quit();
	}

}
