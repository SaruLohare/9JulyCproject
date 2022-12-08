package OrangeHrmPomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OrangeHRM_PIMpage
{

	// click on pim
	
	@FindBy(xpath = "//span[text()='PIM']")  private WebElement PIM;  
	@FindBy(xpath = "//a[text()='Employee List']") private WebElement Employlist;
	@FindBy(xpath = "//span[contains(text(),' Records Found')]") private WebElement noOfrecords;
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']") private WebElement userid;
	@FindBy(xpath = "//a[text()='Logout']") private WebElement logoutbutton;
	//write constructor
	
	
	public OrangeHRM_PIMpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonpimOption()
	{
		PIM.click();
		Reporter.log("clickon PIM",true);
	}
	
	public String getTextFromEmployeeList()
	{
		
		
		String empList = Employlist.getText();
		
		Reporter.log("getting text from emplist button",true);
		return empList;
		
	} 
	
	//we give here in string bz we have to get the ans in string
	
	public String getNumberOfEmployeeRecords(WebDriver driver) throws IOException
	{
		Utility.wait(driver, 1000);
		Utility.scrollintoView(driver, noOfrecords);
		
	    String records = noOfrecords.getText();
		Utility.wait(driver, 1000);

		
	    Utility.screenshot(driver, records);
		Reporter.log("get no of employeeRecords",true);
		return records;
	}
	
	public void logoutfromOrangeHRM(WebDriver driver)
	{
		userid.click();
		
		Utility.wait(driver, 2000);
		Reporter.log("logout from orange hrm",true);
		logoutbutton.click();
	}
	
	
	
}
