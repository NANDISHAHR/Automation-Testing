package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboardevenets {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		
		WebElement Source= driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[5]/pre"));
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.keyDown(Source, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement destination = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[4]/pre"));
		Thread.sleep(2000);
		action.keyDown(destination, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
		
		//driver.close();
		//driver.quit();
		

	}

}
