package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickdemo {

	public static void main(String[] args)  {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement rectangle = driver.findElement(By.xpath("//*[@id=\"swatch\"]"));
		Actions action = new Actions(driver);
		action.contextClick(rectangle).perform();
		
		
		//driver.close();
		//driver.quit();
		

	}

}
