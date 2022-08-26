package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pritntalllinks {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("Total number of all Tags are " +alltags.size());
		
		for(int i=0;i<alltags.size();i++)
		{
			System.out.println("Links on page are" +alltags.get(i).getAttribute("href"));
			System.out.println("Text on page is" +alltags.get(i).getText());
		}
		
		
		driver.quit();

	}

}
