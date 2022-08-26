package ui;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Basicwebdrivermethod {
	public static String browser = "msEdge";// External configuration - XLS,CSV
	//public static EdgeDriver driver; //global declaration
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
		driver.manage().window().maximize();
		
		String currnetURL = driver.getCurrentUrl();
		System.out.println(currnetURL);
		
		String Title = driver.getTitle();
		System.out.println(Title);
		
		String PageSource =  driver.getPageSource();
		System.out.println(PageSource);
		
		//driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        List<WebElement>  webelements = driver.findElements(By.xpath("//div[@class=\'inventory_list']/div"));
        System.out.println(webelements);
		driver.navigate().to("https://www.sugarcrm.com/");
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[1]/div[4]/a")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
       //driver.close();
		driver.quit();	
		
	}
}
