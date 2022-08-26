package practicetestng;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstclass {

	@Test
	public void testgoogle() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Testing", Keys.ENTER);
		System.out.println(driver.getTitle());
		String ExpectedTitle = "Testing - Google Search";
		String ActualTitale = driver.getTitle();
		assertEquals(ActualTitale, ExpectedTitle , "The title is mismatched");
		assertTrue(true);
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void Testfacebook() throws Exception {
		
		SoftAssert softassert = new SoftAssert();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("abcd@gm.com" , Keys.ENTER);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@id='u_0_6_Du']/div/i")).click();
		System.out.println(driver.getTitle());
		
		//title assertionl
		String Actualtitle = driver.getTitle();
		String Expectedtitle= "Log in to Facebook";
		softassert.assertEquals(Actualtitle, Expectedtitle, "the title is mismatched");
		
		//url Assertion
		String actualurl = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		String expectedurl= "https://www.facebook.com/";
		softassert.assertNotEquals(actualurl,expectedurl, "The URL is same");
		
		//text assertion
		String actualtext= driver.findElement(By.id("email")).getAttribute("value");
		String expectedtext= "";
		softassert.assertEquals(actualtext, expectedtext, "The text is mismached");
		
		//border assertion
		String actualborder = driver.findElement(By.id("email")).getCssValue("border");
		String expectedborder = "1px solid rgb(240, 40, 73)";
		softassert.assertEquals(actualborder, expectedborder, "The border is mismatched");
		
		//error message
		String actualerrormsg = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		String expectederrormsg = "The email address you entered isn't connected to an account. Find your account and log in.";
		softassert.assertEquals(actualerrormsg, expectederrormsg, "The error message is mismatched");
		
		driver.quit();
		softassert.assertAll();
	}
}
