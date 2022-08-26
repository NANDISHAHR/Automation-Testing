package extentreportstraining;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfgChnages {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExtentReports extentreport = new ExtentReports();
		File file = new File("Test.html");
		ExtentSparkReporter extentSparkreporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(extentSparkreporter);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());

		/*
		 * ExtentSparkReporterConfig config = extentSparkreporter.config();
		 * config.setTheme(Theme.DARK); config.setReportName("Report name");
		 * config.setDocumentTitle("Document title");
		 * config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		 * config.setCss(".badge-primary{background-color:#da0b2b}");
		 * extentSparkreporter.config().setJs(
		 * "document.getElementsByClassName(\"logo\")[0].style.display='none';");
		 */

		extentSparkreporter.loadJSONConfig(new File("./src/test/resources/extentreportconfi.json"));
		// extentSparkreporter.loadXMLConfig(new
		// File("./src/test/resources/extentreportconfig.xml"));

		extentreport.createTest("test1", "Test desc").assignAuthor("Nandish").assignCategory("Smoke")
				.assignDevice("Chrome 102").pass("This is a passed test");

		extentreport.setSystemInfo("OS", System.getProperty("os.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.specification.version.name"));
		extentreport.setSystemInfo("Browser Version", capabilities.getBrowserVersion() + capabilities.getBrowserName());
		extentreport.setSystemInfo("APP URL", System.getProperty("www.google.com"));
		extentreport.setSystemInfo("UserName", System.getProperty("abc@gmail.com"));
		extentreport.setSystemInfo("Password", System.getProperty("abcdname"));
		extentreport.flush();
		 driver.quit();
		Desktop.getDesktop().browse(file.toURI());
	}

}