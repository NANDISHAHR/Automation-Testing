package extentreportstraining;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.ProcessHandle.Info;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapturingScreenshot {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ExtentReports extentreport = new ExtentReports();
		File file = new File("Repoerts.html");
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(extentsparkreporter);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

	//	System.getProperties().list(System.out);
		String base64Code = Capturingscreenshot();
		String path = Capturingscreenshot("Google.jpg");

		extentreport.createTest("Screenshot Test 1", "This is for attaching the screenshots to the test at test level")
				.info("This is a info message").addScreenCaptureFromBase64String(base64Code);

		extentreport.createTest("Screenshot Test 2", "This is for attaching the screenshots to the test at test level")
				.info("This is a info message").addScreenCaptureFromBase64String(base64Code, "Google home Page");

		extentreport.createTest("Screenshot Test 3", "This is for attaching the screenshots to the test at test level")
				.info("This is a info message").addScreenCaptureFromBase64String(base64Code, "Google home Page1")
				.addScreenCaptureFromBase64String(base64Code, "Google home Page2")
				.addScreenCaptureFromBase64String(base64Code, "Google home Page3")
				.addScreenCaptureFromBase64String(base64Code, "Google home Page4")
				.addScreenCaptureFromBase64String(base64Code, "Google home Page5");

		extentreport.createTest("Screenshot Test 4", "This is for attaching the screenshots to the test at test level")
				.info("This is a info message").addScreenCaptureFromPath(path);

		extentreport.createTest("Screenshot Test 5", "This is for attaching the screenshots to the test at test level")
				.info("This is a info message").addScreenCaptureFromPath(path, "Google home");

		extentreport.createTest("Screenshot Test 5", "This is for attaching the screenshots to the test at log level")
				.info("This is a info message")
				.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
				.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "Google First page").build());

		extentreport.createTest("Screenshot Test 6", "This is for attaching the screenshots to the test at log level")
				.info("This is a info message").fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
				.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google path page").build());

		extentreport.createTest("Screenshot Test 7", "This is for attaching the screenshots to the test at log level")
				.info("This is a info message")
				.fail("This is a info message ",
						MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
				.fail("This is ingo message", MediaEntityBuilder
						.createScreenCaptureFromBase64String(base64Code, "Google First page").build());

		extentreport.createTest("Screenshot Test 7", "This is for attaching the screenshots to the test at log level")
				.info("This is a info message")
				.fail("This is a info message", MediaEntityBuilder.createScreenCaptureFromPath(path).build())
				.fail("This is a info message",
						MediaEntityBuilder.createScreenCaptureFromPath(path, "Google path page").build());

		Throwable t = new Throwable("This is throwable exception");
		extentreport.createTest("Screenshot Test 8", "This is for attaching the screenshots to the test at log level")
				.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build()).fail(t,
						MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "Google home page").build());

		extentreport.createTest("Screenshot Test 9", "This is for attaching the screenshots to the test at log level")
				.info("This is a info").fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
				.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "Google home page").build());

		extentreport.flush();
		driver.quit();
		Desktop.getDesktop().browse(file.toURI());

	}

	public static String Capturingscreenshot() {

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		String Base64Code = takescreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		return Base64Code;
	}

	public static String Capturingscreenshot(String fileName) {

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./screenshots/" + fileName);
		try {
			FileUtils.copyFile(sourcefile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destfile.getAbsolutePath();
	}
}
