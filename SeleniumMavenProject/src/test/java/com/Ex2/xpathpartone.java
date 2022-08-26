package com.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathpartone {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		//driver.findElement(By.xpath("html/body/div[3]/a[4]")).click();
		
		driver.findElement(By.xpath("//a[@id='navbtn_exercises']")).click();

	}

}
