package ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlingwindows {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/au/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("TRY FOR FREE")).click();
		Thread.sleep(2000);
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator = windowhandles.iterator();
		String Parentwindow = iterator.next();
		System.out.println(Parentwindow);
		String CHildwindow = iterator.next();
		System.out.println(CHildwindow);
		
		driver.switchTo().window(CHildwindow);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Testing");
		driver.findElement(By.name("UserLastName")).sendKeys("test");
		
		driver.switchTo().window(Parentwindow);
		//driver.quit();
		

	}

}
