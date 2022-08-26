package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiselect {

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		WebElement multi = driver.findElement(By.id("cars"));
		Select select = new Select(multi);
		select.selectByValue("saab");
		Thread.sleep(2000);
		select.selectByIndex(0);
		Thread.sleep(2000);
		List<WebElement> allItems = select.getAllSelectedOptions();
		System.out.println(allItems.size());
		Thread.sleep(2000);
		select.deselectAll();
		Thread.sleep(2000);
		select.selectByValue("audi");
		Thread.sleep(2000);
		select.selectByIndex(2);
		Thread.sleep(2000);
		select.deselectByIndex(2);
		Thread.sleep(2000);
		List<WebElement> allItem1 = select.getAllSelectedOptions();
		System.out.println(allItem1.size());
		
		

	}

}
