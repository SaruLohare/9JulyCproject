package OrangeHrmPomClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static String readDataFromPropertiyFile(String key) throws IOException
	{
	//read data from property file
	
	//1.create object of properties class
	
	Properties prop=new Properties();
	
	//2.create object of fileinputstream and pass property file path
	
	FileInputStream myFile = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\09JULCProject1\\OrangeHRM.properties");
	
	//3.now we have to load property
	
	prop.load(myFile);
	String value = prop.getProperty(key);  //now we put here url/passcode/username then in console we get url/passcode/username
	return value;
	
	}
	
 // this following methods i just copy pest in utility class
	
	
	public static void screenshot(WebDriver driver,String TestCaseID) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\Admin\\Desktop\\selenium screenshot\\"+TestCaseID+".jpg");
		FileHandler.copy(Source, Destination);
	}
	
	//for the wait time 
	
	public static void wait(WebDriver driver,long wait)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(wait));
	}

	//for the scrolling method
	
	public static void scrollintoView(WebDriver driver,WebElement element) 
	{
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoView()", element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
