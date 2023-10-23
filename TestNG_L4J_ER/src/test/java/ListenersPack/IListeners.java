package ListenersPack;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.Utilities;


public class IListeners extends Utilities implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		this.driver= ((Utilities)result.getInstance()).driver;
		
       Screenshots("passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		this.driver= ((Utilities)result.getInstance()).driver;
		
		
		
		System.out.println("Test failed");
		
          Screenshots("failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		this.driver= ((Utilities)result.getInstance()).driver;
		
		
     
	}
	
	
	
	
	
	
	

}
