package com.Ex2;

import java.lang.runtime.SwitchBootstraps;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascripthighlight {

	static String broswername = "Chrome";
	static  WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		switch (broswername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.att.com/mydatarequest/att/submit-inquiry-nocaseid/");
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0,1000)");
		//js.executeScript("document.getElementById(\"lastName\").setAttribute('style', 'border:2px solid red; background:yellow')");

		
		WebElement element = driver.findElement(By.id("firstName"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow');", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'border:; background:');", element);
		
	}

}
