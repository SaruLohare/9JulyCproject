package OrangeHRMTestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import OrangeHRMBaseClass.Listner;
import OrangeHRMBaseClass.OrangeBase;
import OrangeHRMUtilityClass.Utility;
import OrangeHrmPomClass.OrangHRMLoginPage;
import OrangeHrmPomClass.OrangeHRM_PIMpage;


//now call here listener class    

@Listeners(OrangeHRMBaseClass.Listner.class)
public class OrangeHrmValidateEmplistButton extends OrangeBase {
	
	//create object for the classes------------->declaration
	//OrangHRMLoginPage login;
	OrangeHRM_PIMpage pim; 
	OrangHRMLoginPage login;
	
	
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		launchHRMBrowser();
		
		//initionalies object
		
		login= new OrangHRMLoginPage(driver);
		pim=new OrangeHRM_PIMpage(driver);
		
	}
	
	@BeforeMethod
	public void logintoOrangeHRM() throws IOException
	{
		login.enterUsername(Utility.readDataFromPropertiyFile("username"));
		login.enterPassword(Utility.readDataFromPropertiyFile("password"));
	    login.cliconloginButton();
	    Utility.wait(driver, 1000);
	}
	
	
  @Test
  public void validateEMPList() throws IOException
  {
	  
	  pim.clickonpimOption();
	  Utility.wait(driver, 1000);
	  
	 Assert.assertEquals(pim.getTextFromEmployeeList(), Utility.readDataFromPropertiyFile("employeelist"),"TC is fail text is not matching");  
  }
  
  
  @AfterMethod
  public void logoutOrange()
  {
	pim.logoutfromOrangeHRM(driver);  
  }
  
  
  @AfterClass
  public void closeBrowser()
  {
	  Reporter.log("closing browser", true);
	  driver.close();
  }
  
  
  
}
