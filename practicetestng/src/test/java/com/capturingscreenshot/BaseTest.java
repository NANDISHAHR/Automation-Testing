package com.capturingscreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static String ScreenshotsubfolderName;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@AfterMethod
	public void capturescre(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			capturescreenshot(result.getTestContext().getName() +"/" + result.getMethod().getMethodName());
		}
	}
	
	public void capturescreenshot(String fileName)  {
		if(ScreenshotsubfolderName == null) {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		ScreenshotsubfolderName = date.format(dateformat);
	   			
		}
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourecefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Screenshot/"+ ScreenshotsubfolderName + "/" + fileName);
		try {
			FileUtils.copyFile(sourecefile, destfile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
 }
