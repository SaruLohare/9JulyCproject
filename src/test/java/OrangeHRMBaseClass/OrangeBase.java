package OrangeHRMBaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import OrangeHRMUtilityClass.Utility;



public class OrangeBase 
{
	
	protected WebDriver driver;
	
	public void launchHRMBrowser() throws IOException
	{
		

		 System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		
		//here we call method to get url
		driver.get(Utility.readDataFromPropertiyFile("url"));
		
		driver.manage().window().maximize();
		
		
		Utility.wait(driver, 1000);
		
		
		Reporter.log("launching browser......", true);
		
	}
	

}
