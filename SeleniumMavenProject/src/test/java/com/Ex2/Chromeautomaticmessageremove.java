package com.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chromeautomaticmessageremove {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		//options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		//options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		List<String> excludeswitches = new ArrayList<>();
		excludeswitches.add("enable-automation");
		options.setExperimentalOption("excludeSwitches", excludeswitches);
	
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		

	}

}
