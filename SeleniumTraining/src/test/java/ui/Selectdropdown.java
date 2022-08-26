package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectdropdown {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		WebElement ddown = driver.findElement(By.name("employees_c"));
		Select select = new Select(ddown);
		WebElement firstselected = select.getFirstSelectedOption();
		
		System.out.println(firstselected.getText());
		select.selectByValue("level1");
		Thread.sleep(2000);
		select.selectByVisibleText("51 - 100 employees");
		Thread.sleep(2000);
		select.selectByIndex(5);
		Thread.sleep(2000);

		driver.quit();

	}

}
