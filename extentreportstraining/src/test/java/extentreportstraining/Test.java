package extentreportstraining;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Test {

	public static void main(String[] args) {
	
		
		  WebDriverManager.chromedriver().setup(); WebDriver driver = new
		  ChromeDriver(); Capabilities capabilities = ((RemoteWebDriver)
		driver).getCapabilities(); System.out.println(capabilities.getBrowserName());
		  System.out.println(capabilities.getBrowserVersion());
		 
		
		//System.getProperties().list(System.out);
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.vm.specification.version"));
		

	}

}
