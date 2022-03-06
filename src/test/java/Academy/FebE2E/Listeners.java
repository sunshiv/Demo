package Academy.FebE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;
import Resources.base;

public class Listeners extends base implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReporterObject();
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>(); 	//used to make thread safe so no failure during parallel execution
																//INTERVIEW QUESTION ON THREADS
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		tl.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) { 
		tl.get().log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//EXTENT REPORTING CODE 
		tl.get().fail(result.getThrowable());
		
		//SCREENSHOT CODE
		//result has access to all the testcase details for failed testcase
				WebDriver driver=null;
				//when test fails, execution come to this block, now capture testcase name(@test method)
				String testMethodName=result.getMethod().getMethodName();
				
				//get access to driver of the test class that failed to give life to driver present in base.java
				try {
					driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 		
				
				//screenshot code
				try {
					//adding screenshot in extent reporting
					tl.get().addScreenCaptureFromPath("." + getScreenShotPath(testMethodName,driver), testMethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
