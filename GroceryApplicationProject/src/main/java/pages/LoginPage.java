package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//input[@name='username']")WebElement username; 
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signbtn;
	
	public void enterUserNameOnUserNameField(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
	}
	public void enterPasswordOnPasswordField(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	public void clickOnSignInButton()
	{
		signbtn.click();
	}

}
