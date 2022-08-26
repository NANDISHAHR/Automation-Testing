package com.Ex2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingframes {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoqa.com/frames");
	
	WebElement frame1 = driver.findElement(By.id("frame1"));
	driver.switchTo().frame(frame1);
	driver.findElement(By.id("sampleHeading"));
	
	driver.findElement(By.xpath("//*[@id='sampleHeading']"));
	driver.quit();
	
	
}
}
