package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locators {
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

		//driver.get("https://www.saucedemo.com/");
		driver.get("https://www.selenium.dev/documentation/webdriver/elements/locators/");
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.name("user-name")).sendKeys("Testing");
		//driver.findElement(By.className("input_error form_input")).sendKeys("King"); // Compound class names not permitted
		//driver.findElement(By.cssSelector("#user-name")).sendKeys("Test");
		//driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Queen");
		//driver.findElement(By.tagName("input")).sendKeys("tagname");
		//driver.findElement(By.linkText("Locators")).click();
		driver.findElement(By.partialLinkText("Getting")).click();
	}

}
