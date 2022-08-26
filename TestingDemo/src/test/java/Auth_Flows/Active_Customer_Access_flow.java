package Auth_Flows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Active_Customer_Access_flow {

	public static WebDriver driver = null;

	@Test
	public void Active_Customer_Access_Launch() {

		
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions choption = new ChromeOptions();
		choption.merge(dc);
		
		driver = new ChromeDriver(choption);
		driver.get("https://e-tst2.stage.att.com/mydatarequest/");
		driver.manage().window().maximize();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement slide = driver.findElement(By.xpath("/html"));
		Actions action = new Actions(driver);
		WebElement state =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/main/div[3]/div/div[1]/div[3]/div[1]/span/div/div/button"))); 
		System.out.println(state);
		action.moveToElement(state).build().perform();
		//action.dragAndDropBy(slide, 0, 100).perform();

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,100)");
		
		//driver.getWindowHandles();
		//WebElement frame1 = driver.findElement(By.xpath("html/head/iframe"));
		//driver.switchTo().frame(frame1);
		WebElement button = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[3]/div/div[1]/div[3]/div[1]/span/div/div/button"));
		action.contextClick(button).perform();
	//	@SuppressWarnings("deprecation")
		//Boolean we = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"__next\"]/main/div[3]/div/div[1]/div[3]/div[1]/span/div/div/div")));
		//By pathOfSelection = By.xpath("//button[text()='Alabama']");
		driver.close();

	}

}
