package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demoiframe {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert2");
		driver.manage().window().maximize();
		
		//driver.switchTo().frame("iframeResult");
		//driver.switchTo().frame(0);
		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(2000);
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();
		
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		driver.getWindowHandle();
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Testing Automation");
		
		String alerttext1 = driver.switchTo().alert().getText();
		System.out.println(alerttext1);
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		//driver.quit();
		

	}

}
