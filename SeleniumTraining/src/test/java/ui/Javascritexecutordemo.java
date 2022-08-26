package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascritexecutordemo {

	public static void main(String[] args)  {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor jsece = (JavascriptExecutor)driver;
		
		//print Title of the page
		String scrit = "return document.title;";
		String Title= (String) jsece.executeScript(scrit, args);
		System.out.println(Title);
	
		//Click the button
		driver.switchTo().frame("iframeResult");
		jsece.executeScript("myFunction()");
		driver.switchTo().alert().accept();
		
		//Highlight
		WebElement Button = driver.findElement(By.xpath("/html/body/button"));
		jsece.executeScript("arguments[0].style.border='3px solid red'", Button);
		
		//Scroll
		//driver.switchTo().parentFrame();
		driver.navigate().to("https://www.w3schools.com/");
		WebElement learn = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[3]/a"));
		jsece.executeScript("arguments[0].scrollIntoView(true);", learn);
		
	}

}
