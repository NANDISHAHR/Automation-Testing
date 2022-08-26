package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 {
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
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		//driver.close();
		driver.quit();

	}

}
//we need to change driver name for each browser