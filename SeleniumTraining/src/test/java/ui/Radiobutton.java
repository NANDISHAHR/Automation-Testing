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

public class Radiobutton {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.singaporeair.com/en_UK/plan-and-book/your-booking/searchFlight/#/book/bookflight");
		driver.manage().window().maximize();
		WebElement radio1  = driver.findElement(By.id("bookFlights"));
		System.out.println(radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
		radio2.click();
		System.out.println(radio2.isSelected());
		System.out.println(radio1.isSelected());
		
		System.out.println(driver.findElements(By.xpath("//*[@name = 'book-flight-radio']")).size());
		
		
		
		
				
	}



}
