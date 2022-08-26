package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptscrolldemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.att.com/mydatarequest/new-request/");
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0,500)");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	WebElement element = driver.findElement(By.id("ge5p_z1-change-language"));
		//js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
		//js.executeScript("window.scrollBy(0,700)");

	js.executeScript("arguments[0].scrollIntoView()", element);
	}

}
