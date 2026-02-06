package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.GroceryBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends GroceryBase{
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
	}
	
	@Test
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
	}

	
}
