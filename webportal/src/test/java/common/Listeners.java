package common;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.testUtils;
public class Listeners extends testUtils implements ITestListener {

	public void OnTestStart(ITestResult result) {

		Reporter.log("method name is: " +result.getName());
		System.out.println("Test Case is starting");
		Reporter.log("<a href=\"C:\\Users\\nandish.h.r\\eclipse-workspace1\\webportal\\screenshot\">Test Result</a>");
	}

	public void OnTestSuccess(ITestResult result) {

		Reporter.log("The status of exceution is: "+result.getStatus());
	}

	public void OnTestFailure(ITestResult result) {
		System.out.println("Test failed Screenshot captured");
		
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"C:\\Users\\nandish.h.r\\eclipse-workspace1\\webportal\\screenshot\">Test Result</a>");
	}

	public void OnTestSkipped(ITestResult result) {

	}

	public void OnTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void OnStart(ITestContext context) {

	}

	public void OnFinish(ITestContext context) {

	}
}
