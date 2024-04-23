package listenerUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;

public class ListenerImplementation extends BaseClass implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Completed");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"Execution Started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+"Execution Completed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL,test.addScreenCapture(getWebPageScreenshot(driver)));
	}
}
