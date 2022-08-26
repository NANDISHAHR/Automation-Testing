package com.Ex2;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class permissionpopups {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentsettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		
		
		contentsettings.put("notifications", 1);
		profile.put("manage_default_content_settings",contentsettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		//Notifications
		//options.addArguments("disable-notifications");
		//locations
		//options.addArguments("disable-geolocation");
	//	options.addArguments("disable-media-stream");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cleartrip.com/");
		//driver.findElement(By.id("mic-launcher")).click();
		
		

	}

}
