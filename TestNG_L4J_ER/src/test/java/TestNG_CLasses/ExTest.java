package TestNG_CLasses;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.Utilities;

import org.testng.annotations.BeforeTest;


import org.testng.annotations.AfterTest;

public class ExTest extends Utilities {
	
	
  @Test
  public void tc1_Validate_Login_Functionality() {
	  test=reports.createTest("Launch Browser and Go to Website");
	  //browsert initialized 
	  // implicit wait given
	  // maximize the screen
	  //go to URl
//	  test.log(Status.PASS, "User Launched the Website Successfully");
	  test.info("User Successfully land on Homepage and Title Veified");	  
	  //validate page title 
	  test.pass("HomePage title verified");  
  }
  
  @Test
  public void tc2_Registration_Validation() {
	  test=reports.createTest("Validate Login ").assignAuthor("Maria").assignCategory("smoke").assignDevice("Chrome");
	  //type email and password in login field 
	  // click on login button 
	  //  wait for the alert
	  test.warning("alert Displaying");
	  //accept the alert 
	  //verified homepage after loging successfuly   
	  test.pass("user logged in to the application Successfully");  
  }
  
  public void tc3() {
	  test=reports.createTest("Validate Dashboard ").assignAuthor("Maria").assignCategory("smoke").assignDevice("Chrome");
	  //click on dashboard 
	  // verify /assert the Title 
	  test.fail("Title is not verified");
	  //accept the alert 
	  //verified homepage after loging successfuly 
	  test.skip("Test skipped"); 
  }}
