package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static String ScreenshotsubfolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extenttest;
	

	@BeforeSuite
	public void initializeExtentreport() {

		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("Test.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.specification.version.name"));
	}

	@AfterSuite
	public void generateExtentReport() throws Exception {
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("Test.html").toURI());
	}

	@Parameters("browserName")
	@BeforeTest
	public void setup(ITestContext context, @Optional("Chrome") String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("The browser is invalid");
			break;
		}

		driver.manage().window().maximize();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String Device = capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."))
				+ capabilities.getBrowserName();
		String Author = context.getCurrentXmlTest().getParameter("author");

		extenttest = extentReports.createTest(context.getName());
		extenttest.assignAuthor(Author);
		extenttest.assignDevice(Device);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@AfterMethod
	public void Checkstatus(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String Screenshotpath = null;
			Screenshotpath = capturescreenshot(
					result.getTestContext().getName() + "/" + result.getMethod().getMethodName());
			extenttest.addScreenCaptureFromPath(Screenshotpath);
			extenttest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extenttest.pass(m.getName() + "is passed");
		}

		extenttest.assignCategory(m.getAnnotation(org.testng.annotations.Test.class).groups());

	}

	public String capturescreenshot(String fileName) {
		if (ScreenshotsubfolderName == null) {
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("ddMMyyyHHmmss");
			ScreenshotsubfolderName = formatdate.format(date);
		}

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File Sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Screenshot/" + ScreenshotsubfolderName + "/" + fileName);
		try {
			FileUtils.copyFile(Sourcefile, destfile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return fileName;
	}
}
