package ui;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshotdemo {

	public static void main(String[] args) throws IOException {
		
		Date currentdate = new Date();
		System.out.println(currentdate);
		String screenshotfilename = currentdate.toString().replace(":", "-");
		System.out.println(screenshotfilename);
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();
		
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotfilename+".png"));
		
		
		
		//driver.close();
		//driver.quit();
		

	}

}
