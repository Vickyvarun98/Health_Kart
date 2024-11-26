package com.HMS.Generic.ListenerUtility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.HMS.BaseClass.BaseClassForHMS;
import com.HMS.Generic.WebDriverUtilityTest.JavaUtility;
import com.HMS.Generic.WebDriverUtilityTest.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClassForHMS implements ISuiteListener,ITestListener,IRetryAnalyzer{
	
	int count=0,limit=2;
	public ExtentReports report;
	public static ExtentTest test;
	
	JavaUtility j=new JavaUtility();
	String date= j.getCurrentDatewithTime();
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("I--Suite Execution Starts.....",true);
		ExtentSparkReporter spark=new ExtentSparkReporter("./Extent_Report/reports_"+date+".html");
		spark.config().setDocumentTitle("Execution Reports");
		spark.config().setReportName("Contact Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "EDGE");
		report.setSystemInfo("OS", "WINDOWS-12");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("I--Suite Execution Ends.....",true);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Starts.....",true);
		UtilityClassObject.setTest(test);
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+" Execution Started...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Success.....",true);
		test.log(Status.INFO,result.getMethod().getMethodName()+" Execution Sucess...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		Reporter.log("I--Test Execution Fails.....",true);
		TakesScreenshot edriver=(TakesScreenshot)BaseClassForHMS.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, "ErrorShot_"+date);
		test.log(Status.FAIL,methodName+" Execution Failed...");
		Reporter.log("Screenshot is Taken....",true);
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Skipped.....",true);
		test.log(Status.INFO,result.getMethod().getMethodName()+" Execution Skipped...");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Fails with Success Percentage.....",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Fails without Timeout.....",true);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Starts.....",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("I--Test Execution Ends.....",true);
	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count<limit) {
			count++;
			return true;
		}
		return false;
	}

	
	
	
	

}
