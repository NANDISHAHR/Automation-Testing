package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.ThreadDeathWatcher;

public class Autosuggestiondropdown {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label/span")).click();
		//driver.findElement(By.id("fromCity")).click();
		WebElement from = driver.findElement(By.xpath("//span[text() = 'From']"));
		//WebDriverWait wait =  WebDriverWait(driver , 30);
		//wait.until(ExpectedConditions.elementToBeClickable(from));
		//((WebElement) driver).click();
		JavascriptExecutor exceutor = (JavascriptExecutor)driver;
		exceutor.executeScript("arguments[0].click();", from);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Sydney");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
        driver.quit();
	}



}
