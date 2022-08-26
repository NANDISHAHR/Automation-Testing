package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Navigatebwpages {
    WebDriver driver;
    String baseurl;
    
	@SuppressWarnings("deprecation")
	@Before

	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseurl = "https://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	void test() {
		driver.get(baseurl);
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);
		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + CurrentURL);
		
	}
	@After
	void tearDown() throws Exception {
		driver.quit();
		
	}

}
