package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provide implementation to ITestListener interface of testNG
 * @author Devi
 */

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test execution started");
		
		//intimate extent report for test 
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test is pass");
		
		//log the Status as pass in extent reports
		test.log(Status.PASS, methodName +" -> Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test is fail");
		
		//log the Status as pass in extent reports
		test.log(Status.FAIL, methodName +" -> Test is fail");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log an exception in extent report
		test.log(Status.WARNING, result.getThrowable());
					
		//capture the screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
				
		String screenshotName = methodName+"-"+j.getSystemDateInFormat();	
				
		try {
			String path = s.captureScreenshot(BaseClass.sdriver, screenshotName);
			
			//attach the screenshot to extent report
			test.addScreenCaptureFromPath(path);
			
			}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test is skip");
		
		//log the Status as pass in extent reports
		test.log(Status.SKIP, methodName +" -> Test is skip");
				
		//capture the exception
		System.out.println(result.getThrowable());
				
		//log an exception in extent report
		test.log(Status.WARNING, result.getThrowable());
	
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution started");
		
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDateInFormat()+".html");
	    esr.config().setDocumentTitle("Swag Labs Execution");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter name", "Devi");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution finished");
		
		//Generate extent reports
		report.flush();
	}

}
