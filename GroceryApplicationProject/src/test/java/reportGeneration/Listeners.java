package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationcore.GroceryBase;
import utilities.ExtentReportUtility;

public class Listeners extends GroceryBase implements ITestListener{  //ITestListener is s predefined interface
	ExtentTest test; 
 	ExtentReports extent = ExtentReportUtility.createExtentReports(); 
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
  
 	public void onTestStart(ITestResult result) {  //method overriding all these onTestStart methods are predefined in ITestListener interface.
  
 		ITestListener.super.onTestStart(result); //this method will automatically invoke before each Test
 		test = extent.createTest(result.getMethod().getMethodName()); //fetch the method name and will attach to the report
 		extentTest.set(test); 
  
 	} 
  
 	public void onTestSuccess(ITestResult result) { //automatically invoke on Pass
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); 
  
 	} 
  
 	public void onTestFailure(ITestResult result) { //automatically invoke on fail
  
 		ITestListener.super.onTestFailure(result); 
 		 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		 
 		WebDriver driver = null; 
 		 
 		String testMethodName = result.getMethod().getMethodName(); //failed reason will be generated in the fail scenarios
 		 
 		try { 
 			 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (IllegalArgumentException e) { 
  
 			e.printStackTrace(); 
 		} catch (IllegalAccessException e) { 
  
 			e.printStackTrace(); 
 		} catch (NoSuchFieldException e) { 
  
 			e.printStackTrace(); 
 		} catch (SecurityException e) { 
  
 			e.printStackTrace(); 
 		} 
  
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (Exception e) { 
 		} 
 	} 
  
 	public void onTestSkipped(ITestResult result) { //automatically invoke on Skip
 		 
 		ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		String testMethodName = result.getMethod().getMethodName(); 
  
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
  
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
  
 	public void onTestFailedWithTimeout(ITestResult result) { 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) { 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) { 
  
 		ITestListener.super.onFinish(context); 
 		extent.flush(); //very important method and it will not generate the report correctly if it is not used.
 	}
	

}
