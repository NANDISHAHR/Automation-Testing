package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firsttestcase {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\browserdriver\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.quit();
	}

}
