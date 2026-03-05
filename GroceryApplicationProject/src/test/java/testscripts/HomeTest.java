package testscripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.GroceryBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomeTest extends GroceryBase{
	HomePage home;
	@Test(retryAnalyzer = retry.Retry.class,description="Verifying user can successfully login and logout from  application")
	public void verifySuccessfulLogoutOnvalidLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = login.clickOnSignInButton();			
		home.clickOnHomeButtonOnHomePage();		
		login=home.clickOnLogoutButton();	
		boolean islogout = home.isRedirectToLoginPage();
		Assert.assertTrue(islogout, Constants.LOGOUTERRORMESSAGE);	
		
	}
	

}
