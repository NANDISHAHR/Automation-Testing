package practicetestng;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void InitializeBrowser(@Optional("Chrome") String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =  new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver =  new EdgeDriver();
			break;
		default:
			System.err.println("Browser name is invalid");
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters("sleeptime")
	@AfterTest
	//public void teardown(Long sleeptime)
	public void teardown(String sleeptime) throws Exception {
		System.out.println(sleeptime);
		//Thread.sleep(sleeptime);
		Thread.sleep(Long.valueOf(sleeptime));
		driver.quit();
	}
	@Parameters("URL")
	@Test
	public void lunchapp(String URL) {
		driver.get(URL);
	}

	@Parameters({"username" , "password"})

	@Test
	public void loginorangeHRM(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test
	public void myinfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	
	@Test
	public void verifymyinfo() {
		boolean actaualvalue = driver.findElement(By.xpath("//div[@class='head']/h1[text()='Personal Details']")).isDisplayed();
		Assert.assertTrue(actaualvalue);
	}
	
	@Test
	public void verifylogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
	}
	
}
