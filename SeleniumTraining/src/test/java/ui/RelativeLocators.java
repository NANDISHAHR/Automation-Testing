package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {
	public static String browser = "msEdge";// External configuration - XLS,CSV
	//public static EdgeDriver driver; //gloabal declaration
	//public static ChromeDriver driver1;
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("msEdge")) {
			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}

		driver.get("https://www.saucedemo.com/");
		WebElement password = driver.findElement(By.id("password"));
		driver.findElement(with(By.tagName("input")).above(password)).sendKeys("Testing");
		driver.findElement(with(By.tagName("input")).below(password)).click();
		
	
	}

	
}