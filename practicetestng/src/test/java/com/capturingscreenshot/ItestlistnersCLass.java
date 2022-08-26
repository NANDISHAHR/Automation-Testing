package com.capturingscreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestlistnersCLass extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		//capturescreenshot(result.getTestName()+ ".jpg");
		System.out.println(result.getTestContext().getName()+ " "+ result.getMethod().getMethodName());
		capturescreenshot(result.getMethod().getMethodName()+".png");
		
	}

	
}
