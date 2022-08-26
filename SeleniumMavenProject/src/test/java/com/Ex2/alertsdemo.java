package com.Ex2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertsdemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.manage().window().maximize();
		
		//simple alert
	
		driver.findElement(By.xpath("//input[@type='button' and @value='Alert']")).click();
		Alert simplealert = driver.switchTo().alert();
		System.out.println(simplealert.getText());
		Thread.sleep(2000);
		simplealert.accept();
		
		//confirmation alert
		
		driver.findElement(By.name("confirmation")).click();
		Alert confirmationalert = driver.switchTo().alert();
		System.out.println(confirmationalert.getText());
		Thread.sleep(2000);
		confirmationalert.accept();
		driver.findElement(By.name("confirmation")).click();
		Thread.sleep(2000);
		confirmationalert.dismiss();
		
		//prompt alert
		
		driver.findElement(By.name("prompt")).click();
		Alert promotalert = driver.switchTo().alert();
		System.out.println(promotalert.getText());
		promotalert.sendKeys("TEST");
		Thread.sleep(2000);
		promotalert.accept();
		
		
		driver.quit();
		
		
		//confirmation alert

	}

}
