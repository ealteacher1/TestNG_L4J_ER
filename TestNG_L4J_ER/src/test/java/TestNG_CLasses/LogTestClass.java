package TestNG_CLasses;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogTestClass extends Utilities{
	
	
  @Test
  public void Verify_Homepage() throws InterruptedException {
	  
	  test=reports.createTest("Verify_Homepage").assignAuthor("Maria").assignCategory("smoke").assignDevice("Mac");
	  
      String expectedTitle="Google";
      
      
      log.info("Getting actual Title");
      String actual_Title=driver.getTitle();
      log.info("Title Collected");
      
      
      
      
      if(actual_Title.equals(expectedTitle)) {
    	 log.info("Title verified and Matched with Expected Title");
    	 test.pass("Verify_Homepage");
    	 
      }
      else {
    	  log.error("Title Verification Failed, Tiitle expected:["+ expectedTitle+"] but found: ["+actual_Title+ "]");
 //   	  test.fail("Verify_Homepage");
    	  test.log(Status.FAIL, MarkupHelper.createLabel("Verify_Homepage", ExtentColor.RED));
    	  test.addScreenCaptureFromPath(CaptureSSforER("er_ss"),"Failed to Verify Title");
    	
      }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
