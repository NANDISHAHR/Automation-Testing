import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.helpers.Util;

public class TestJavaLibraries {

	public static void main(String[] args) throws IOException {
		/*
		 * System.setProperty("webdriver.chrome.driver" ,
		 * "C:\\Users\\nandish.h.r\\eclipse-workspace1\\SeleniumJava\\browserdriver\\chromedriver.exe"
		 * ); WebDriver driver = new ChromeDriver();
		 * driver.get("https://www.google.com/");
		 */
		
		System.setProperty("webdriver.gecko.driver" , "C:\\Users\\nandish.h.r\\eclipse-workspace1\\SeleniumJava\\browserdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		Utils.CapturingScreenshot(driver, "Image.png");
	}

}
