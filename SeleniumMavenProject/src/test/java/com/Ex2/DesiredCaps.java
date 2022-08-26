package com.Ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCaps {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.merge(caps);
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://cacert.com");

	}

}
