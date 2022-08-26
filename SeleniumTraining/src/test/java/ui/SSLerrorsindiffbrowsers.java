package ui;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SSLerrorsindiffbrowsers {
	public static String browser = "msEdge";
	public static WebDriver driver;

	public static void main(String[] args) {
		DesiredCapabilities dc  = new DesiredCapabilities();
		
		if (browser.equals("msEdge")) {
			WebDriverManager.edgedriver().setup();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			EdgeOptions edoptions = new EdgeOptions();
			edoptions.merge(dc);
			driver = new EdgeDriver(edoptions);
			
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			ChromeOptions choptions = new ChromeOptions();
			choptions.merge(dc);
			driver = new ChromeDriver(choptions);
			
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.merge(dc);
			 driver = new FirefoxDriver(ffoptions);
		}

		driver.get("https://expired.badssl.com");
		
				
	}
}
