package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class navigatemethods {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement serach = driver.findElement(By.name("q"));
		serach.sendKeys("facebook");
		serach.submit();
		driver.navigate().to("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		driver.quit();
		

	}

}
