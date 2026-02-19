package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.GroceryBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends GroceryBase{
	
	@Test
	public void verifyWheTherUserIsAbleToAddNewNews() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnmanageNewsMoreInfo();
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.addNewNews();
	}
	
	@Test
	public void verifyTheUserIsAbleToSearchNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnmanageNewsMoreInfo();
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.searchNews();
	}
	@Test
	public void verifyTheUserIsAbleToResetNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnmanageNewsMoreInfo();
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.resetNews();
	}

}
