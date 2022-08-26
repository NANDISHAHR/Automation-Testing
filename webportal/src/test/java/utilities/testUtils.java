package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.TakesScreenshot;

import common.basetest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


public class testUtils extends basetest {
	public void getScreenshot() throws IOException {
	Date currentdate = new Date();
	String Screenshotfilename = currentdate.toString().replace(" ", "-");
	File ScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(ScreenshotFile, new File(".//screenshot//"+ Screenshotfilename + ".png"));
	}

}
