package com.Ex2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandling {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://demoqa.com/browser-windows");

		String parenthandle = driver.getWindowHandle();
		System.out.println("Parent window : " + parenthandle);
		
		/*
		 * driver.findElement(By.id("tabButton")).click();
		 * 
		 * Set<String> handles = driver.getWindowHandles(); for (String handle :
		 * handles) { System.out.println(handle); if (!handle.equals(parenthandle)) {
		 * driver.switchTo().window(handle); String chidlwindow1 =
		 * driver.findElement(By.id("sampleHeading")).getText();
		 * System.out.println(chidlwindow1); Thread.sleep(5000); driver.close(); } }
		 */
		//driver.switchTo().window(parenthandle);
		driver.findElement(By.id("windowButton")).click();
		
		Set<String> handles1 = driver.getWindowHandles();
		for (String handle1 : handles1) {
			System.out.println(handle1);
			if (!handle1.equals(parenthandle)) {
				driver.switchTo().window(handle1);
				driver.manage().window().maximize();
				String chidlwindow2 = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(chidlwindow2);
				Thread.sleep(5000);
				driver.close();
			}
		Thread.sleep(2000);
		//driver.quit();
	}
	}
}
