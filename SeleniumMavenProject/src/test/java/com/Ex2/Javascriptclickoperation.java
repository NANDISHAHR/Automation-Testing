package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascriptclickoperation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.att.com/mydatarequest/new-request/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.evaluate(\"//a[text()='Submitting a new request or other data concerns >']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click();");
	
		WebElement link = driver.findElement(By.xpath("//a[text()='Submitting a new request or other data concerns >']"));
		
		js.executeScript("arguments[0].click()", link);
		
	}

}
