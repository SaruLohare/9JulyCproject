package OrangeHrmPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OrangHRMLoginPage
{
	 //create all interested element----->as variable
	 //we use here annotation @findby
	
	//Data member should be declared globally with access level private using @findBy Annotation
	
	//variable declaration global variable
	
	@FindBy(name = "username") private WebElement username;            //we find userid element by name
	@FindBy(name="password") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbutton;
	
	
	//write constructor

	public OrangHRMLoginPage(WebDriver driver)
	{
		
		//use all global variable ----> call in local variable by using this keyword
		PageFactory.initElements(driver, this);	
	}
	
	
	//write methods for upper three variable
	
	public void enterUsername(String un)
	{
		username.sendKeys(un);
		Reporter.log("sending username",true);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
		Reporter.log("sending password",true);
	}
	
	public void cliconloginButton()
	{
		loginbutton.click();
		Reporter.log("click on loginbutton",true);
	}
	
	
}
