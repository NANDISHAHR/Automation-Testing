package extentreportstraining;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class practice1 {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentreport = new ExtentReports();
		File file = new File("file1.html");
		ExtentSparkReporter extentsparkreporter =  new ExtentSparkReporter(file);
		extentreport.attachReporter(extentsparkreporter);
		
		extentreport.createTest("Test1").pass("this is passsed");
		
		ExtentTest test2 = extentreport.createTest("Test2");
		test2.skip("this is skipped");
		
		extentreport.createTest("test3").log(Status.FAIL, "This is failed");
		
		extentreport.createTest("test4")
		.log(Status.FAIL, "This is failed")
		.log(Status.PASS, "This is passed")
		.log(Status.SKIP, "This is Skipped")
		.log(Status.WARNING, "This is Warning")
		.log(Status.INFO, "This is info");
		
		
		extentreport.flush();
		Desktop.getDesktop().browse(file.toURI());
		
	
	}
}
