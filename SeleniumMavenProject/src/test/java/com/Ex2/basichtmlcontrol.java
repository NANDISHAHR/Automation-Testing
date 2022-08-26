package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basichtmlcontrol {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://demo.guru99.com/test/");
		
		
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("password");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.navigate().to("https://demo.guru99.com/test/radio.html");
		Thread.sleep(5000);
		//driver.findElement(By.linkText("Selenium")).click();
       // driver.findElement(By.linkText("Radio & Checkbox Demo")).click();
        driver.findElement(By.id("vfb-7-1")).click();
        driver.findElement(By.id("vfb-6-0")).click();
        driver.findElement(By.id("vfb-6-2")).click();
		

	}

}
