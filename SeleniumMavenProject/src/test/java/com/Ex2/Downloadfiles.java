package com.Ex2;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.FixedRecvByteBufAllocator;

public class Downloadfiles {

	public static void main(String[] args) throws Exception {
		String filetype = "PDF";
		String filesize = "150 kB";

		// Chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", "C:\\Users\\nandish.h.r\\OneDrive - Accenture\\Pictures\\Camera Roll");

		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// edge browser
		/*
		 * WebDriverManager.edgedriver().setup(); EdgeOptions options = new
		 * EdgeOptions();
		 * 
		 * HashMap<String, Object> prefs = new HashMap<>();
		 * prefs.put("plugins.always_open_pdf_externally", true);
		 * prefs.put("download.default_directory",
		 * "C:\\Users\\nandish.h.r\\OneDrive - Accenture\\Pictures\\Saved Pictures");
		 * options.setExperimentalOption("prefs", prefs);
		 * 
		 * WebDriver driver = new EdgeDriver(options);
		 * driver.manage().window().maximize();
		 */

		// firefox
		/*
		 * WebDriverManager.firefoxdriver().setup();
		 * 
		 * FirefoxOptions options = new FirefoxOptions(); FirefoxProfile profile = new
		 * FirefoxProfile(); profile.setPreference("pdfjs.disabled", true);
		 * profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		 * "application/pdf,application/doc,application/ms-doc,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"
		 * ); profile.setPreference("browser.download.dir",
		 * "C:\\Users\\nandish.h.r\\OneDrive - Accenture\\Pictures\\Saved Pictures");
		 * profile.setPreference("browser.download.folderList", 2);
		 * options.setProfile(profile); WebDriver driver = new FirefoxDriver(options);
		 */

		driver.manage().window().maximize();

		driver.get("https://file-examples.com/");
		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();
		Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(By.id("google_esf")));
		driver.switchTo().frame(driver.findElement(By.id("aswift_5")));
		WebElement frame = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		driver.findElement(By.xpath("//td[text()='" + filetype + "']/following-sibling::td[2]/a")).click();
		driver.findElement(By.xpath("//td[text()='" + filesize + "']/following-sibling::td[4]/a")).click();

	}

}
