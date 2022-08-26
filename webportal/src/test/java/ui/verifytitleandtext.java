package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.commondatasetup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class verifytitleandtext extends commondatasetup {

	@Test
	public void TitleTest() {
		
		SoftAssert softassert = new SoftAssert();
		String ExpetecedText= "Search1";
		String ExpectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.ebay.com");
		//WebDriverManager.firefoxdriver().setup();
		//FirefoxDriver driver = new FirefoxDriver()
		String acctualtitle = driver.getTitle();
		
		System.out.println("Verifing Title");
		softassert.assertEquals(acctualtitle, ExpectedTitle , "Title verification is failed");
		
		String actualtext = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("value");
		System.out.println("Verifing text");
		softassert.assertEquals(actualtext, ExpetecedText, "Text verification failed");
		
		System.out.println("Close browser");
		driver.close();
		softassert.assertAll();//to report any assertion failure in the test case
	}

}
