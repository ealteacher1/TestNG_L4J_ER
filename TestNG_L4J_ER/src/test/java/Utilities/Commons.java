package Utilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Commons {
	public WebDriver driver;
	String ud= System.getProperty("user.dir");
	public Logger log = (Logger)LogManager.getLogger(Commons.class);
	public ITestResult result;
	
	public ExtentReports reports = new ExtentReports();
//	public ExtentSparkReporter htmlReporter=new ExtentSparkReporter("Results/shamsevanExtentRep_"+System.currentTimeMillis()+".html");
	public ExtentSparkReporter htmlReporter=new ExtentSparkReporter("Results/jenkins_extentReport.html");
	public ExtentTest test;	
	
	

	

public void waitforelementclickable(WebElement elementvairable) {
	log.info("Waiting for the Element to be clickable");
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(elementvairable));
}

public void waitforpageTitle(String pagetitle) {
	log.info("Waiting for page Title");
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.titleContains(pagetitle));
}


public void switchtoOpenedWindow(String Parent) throws InterruptedException {
	Set<String> wins=driver.getWindowHandles();
	for(String sesid:wins) {
		if (sesid!=Parent) {
			driver.switchTo().window(sesid);
			log.info("Window switched- Driver is present in the new Window/Tab");
}}}



public void tearDown() {
	driver.close();
}

public void Screenshots(String folderName) {	
   File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   File destinationPath=new File(ud+"\\Pictures\\"+folderName+"\\home"+System.currentTimeMillis()+".jpg");
   try {
	FileHandler.copy(SS,destinationPath );
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public String CaptureSSforER(String folderName) {	
	   File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destinationPath=new File(ud+"\\Pictures\\"+folderName+"\\home"+System.currentTimeMillis()+".jpg");
	   try {
		FileHandler.copy(SS,destinationPath );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   String absolutePath= destinationPath.getAbsolutePath();
	   return absolutePath;
	   
	}







public void Ibrowser(String BrowserName,String URL) throws InterruptedException {
	if (BrowserName.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
			   driver.get(URL);	
			   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			   driver.manage().window().maximize();
			   Thread.sleep(4000);
		}
		
		else if(BrowserName.equalsIgnoreCase("edge")) {
			
          WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
		   driver.get(URL);		   
		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   Thread.sleep(4000);}
	
	}

public void configureReport() {
	
	 reports.attachReporter(htmlReporter); 
	
	//Add system information/Environment information to Report 
	reports.setSystemInfo("Machine", "TestPC1");
	reports.setSystemInfo("OS", "Windows11");
	reports.setSystemInfo("browser", "chrome");
	reports.setSystemInfo("userName : ", "shams");
	
	//configuration to change Look and Feel of Report : 
	htmlReporter.config().setDocumentTitle("Evan's report");
	htmlReporter.config().setReportName("Myntra Test report");
	htmlReporter.config().setTheme(Theme.DARK);

}


}
