package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	public LoginPage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//input[@name='username']")WebElement username; 
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signbtn;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboardTile;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginText;
	
	public LoginPage enterUserNameOnUserNameField(String usernamevalue)
	{
		wait.waitUntilVisibilityOfAllElements(driver, username);
	    username.sendKeys(usernamevalue);
	    return this;
	}
	public LoginPage enterPasswordOnPasswordField(String passwordvalue)
	{
		wait.waitUntilVisibilityOfAllElements(driver, password);
	    password.sendKeys(passwordvalue);
	    return this;
	}
	public HomePage clickOnSignInButton()
	{
		wait.waitUntilElementToBeClickable(driver, signbtn);
	    signbtn.click();
	    return new HomePage(driver);
	}
	public boolean isDashBoardDisplayed()
	{
		try
		{
			return dashboardTile.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	public String getLoginPageHeader()
	{
		return loginText.getText();
	}
	

}
