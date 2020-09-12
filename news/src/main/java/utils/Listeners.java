package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class Listeners extends TestListenerAdapter {


	
public void onTestStart(ITestResult tr)
	{
		System.out.println("Test Started");
	}
	
public void onTestSuccess(ITestResult tr)
	{
		
		
	}


public void onTestFailure(ITestResult tr)
	{	
	
	}

public void onTestSkipped(ITestResult tr)
	{
		System.out.println("Test skipped");
	}
}
