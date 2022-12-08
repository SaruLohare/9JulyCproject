package OrangeHRMBaseClass;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Listner extends OrangeBase implements ITestListener
{
	// on test failure is the inbuilt method so we dont need how it is come we just take here this method
	
		public void onTestFailure(ITestResult result)         //result is object
			
		{
			// now by using get method we get the name of fail method
			
			String Tcname = result.getName();
			
			
			Reporter.log("Test "+Tcname+"is failed please have a look again", true);
			Reporter.log("Test case is failed take screenshot", true);
		}
		
		public void onTestSuccess(ITestResult result) 
		{
			String Tcname = result.getName();
			Reporter.log("Test"+Tcname+" case is completed successfully", true);

		}
		

		public void onTestSkipped(ITestResult result)
		{
		    String Tcname = result.getName();
		
			Reporter.log("Test"+Tcname+" case is skiped please retry", true);
			
		}
		
}
