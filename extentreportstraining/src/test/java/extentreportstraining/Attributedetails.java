package extentreportstraining;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.fasterxml.jackson.databind.util.ViewMatcher;

public class Attributedetails {

	public static void main(String[] args) throws Exception {
		ExtentReports extentreport = new ExtentReports();
		File file = new File("Repoerts.html");
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(file);
		
		File file1 = new File("FailedRepoerts.html");
		ExtentSparkReporter extentsparkreporter1 = new ExtentSparkReporter(file1);
		extentsparkreporter1.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		File file2 = new File("SkippedRepoerts.html");
		ExtentSparkReporter extentsparkreporter2 = new ExtentSparkReporter(file2);
		extentsparkreporter2.filter().statusFilter().as(new Status[] {Status.SKIP}).apply();
		
		File file3 = new File("WarningRepoerts.html");
		ExtentSparkReporter extentsparkreporter3 = new ExtentSparkReporter(file3);
		extentsparkreporter3.filter().statusFilter().as(new Status[] {Status.WARNING}).apply();
		
		extentreport.attachReporter(extentsparkreporter,extentsparkreporter1,extentsparkreporter2,extentsparkreporter3);
		
		
		/*//to remove author and un-order left pannel
		 * extentsparkreporter.viewConfigurer().viewOrder().as(new ViewName[] {
		 * ViewName.TEST, ViewName.EXCEPTION, ViewName.CATEGORY, ViewName.DASHBOARD,
		 * ViewName.DEVICE }).apply();
		 */
		
		extentreport.createTest("test1" , "Test desc")
		.assignAuthor("Nandish")
		.assignCategory("Smoke")
		.assignDevice("Chrome 102")
		.pass("This is a passed test");
		
		extentreport.createTest("test2", "test desc")
		.assignAuthor("John")
		.assignCategory("Snaity")
		.assignDevice("Edge 102")
		.fail("This is a failed test");
		
		extentreport.createTest("test3", "test desc")
		.assignDevice("firfox 60")
		.assignCategory("Regression")
		.assignAuthor("rebecca")
		.fail("This is a failed test");
		
		
		extentreport.createTest("Test4" , "Test desc")
		.assignAuthor("Nandish")
		.assignAuthor("John")
		.assignCategory("Smoke")
		.assignCategory("Regression")
		.assignDevice("Chrome 97")
		.assignDevice("Chrome 99")
		.pass("This is a passed test");
		
		
		extentreport.createTest("Test5" , "Test desc")
		.assignAuthor("Nandish" , "John" , "Rebecca" , "Jeevana")
		.assignCategory("Smoke" , "Regression" , "Sanity")
		.assignDevice("Chrome 97" , "Chrome 99" , "Firefox 87")
		.pass("This is a passed test");
		
		extentreport.createTest("Test6" , "Test desc")
		.assignAuthor(new String[] {"Nandish" , "John" , "Rebecca" , "Jeevana"})
		.assignCategory(new String [] {"Smoke" , "Regression" , "Sanity"})
		.assignDevice(new String [] {"Chrome 97" , "Chrome 99" , "Firefox 87" , "Edge 102"})
		.pass("This is a passed test");
		
		Throwable t = new RuntimeException("This is a custome message");
		extentreport.createTest("Exception Test").fail(t);
		
		extentreport.flush();
		Desktop.getDesktop().browse(file.toURI());
		Desktop.getDesktop().browse(file1.toURI());
		Desktop.getDesktop().browse(file2.toURI());
		Desktop.getDesktop().browse(file3.toURI());
	}

}
