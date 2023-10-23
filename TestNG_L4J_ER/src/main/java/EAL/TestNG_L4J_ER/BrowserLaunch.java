package EAL.TestNG_L4J_ER;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {
	
	public static WebDriver driver;
	
	public static Logger log=LogManager.getLogger(BrowserLaunch.class);
	public static void main(String[] args) {
		
	
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		log.info("driver launched");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		log.info("window maximized");
		
		
		driver.get("https://www.myntra.com");
		log.info("user land on website");
		
		
		try {
		
			log.info("clicking on Women button");
			
		driver.findElement(By.linkText("Women1")).isDisplayed();
		driver.findElement(By.linkText("Women1")).click();
		log.info("women button clicked");
		}
		catch (Exception e) {
			log.error("exeception occured",new Exception("element not found"));
		
		}
		
		finally {
			driver.quit();
			log.info("Quitting the Driver");
		}
		
		

	}

}
