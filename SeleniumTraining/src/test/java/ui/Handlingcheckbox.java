package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.ThreadDeathWatcher;

public class Handlingcheckbox {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement radio = driver.findElement(By.id("doi0"));
		Actions actions = new Actions(driver);
		actions.moveToElement(radio);
		actions.perform();
		driver.findElement(By.name("interest_market_c")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.name("interest_market_c")).click();
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
				
	}



}
