package ListenersPack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.Utilities;

public class TestListeners extends Utilities implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
		configureReport();
		log.info("On-Start Listeners, Extent report configuration Done.");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		reports.flush();
		log.info("On-Start Listeners, Extent report configuration Done.");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) { 
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of the passed method: "+ result.getName(), ExtentColor.GREEN));
		CaptureSSforER("er_ss");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of the Failed method: "+ result.getName(), ExtentColor.RED));
		CaptureSSforER("failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of the skipped method: "+ result.getName(), ExtentColor.ORANGE));
		
		
	}



	
	
}
