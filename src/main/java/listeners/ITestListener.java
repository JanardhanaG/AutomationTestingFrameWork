package listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;

public interface ITestListener  {
	
	public void onTestStart(ITestResult result);
		

	 void onTestSuccess(ITestResult result);
	
	

	 void onTestFailure(ITestResult result); 
		
	 void onTestSkipped(ITestResult result) ;
		
	

	 void onStart(ITestContext context) ;


 void onFinish(ITestContext context);
}