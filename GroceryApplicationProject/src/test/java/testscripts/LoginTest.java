package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import automationcore.GroceryBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends GroceryBase{
	HomePage home;
	@Test(priority=1, description="Validating User Login With Valid Credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=login.clickOnSignInButton();
		boolean dashboardDisplay=login.isDashBoardDisplayed();		
		Assert.assertTrue(dashboardDisplay, Constants.VALIDCREDENTIALERROR);
	}	
	
	
	@Test(priority=2, description="Validating User Login With Valid Username & Invalid Password")
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expected="7rmart supermarket";
		String actual=login.getLoginPageHeader();
		Assert.assertEquals(actual, expected,Constants.INVALIDPASSWORDERROR);
		
	}
	
	@Test(priority=3,description="Validating User Login With Invalid Username & Valid Password")
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expected="7rmart supermarket";
		String actual=login.getLoginPageHeader();
		Assert.assertEquals(actual, expected,Constants.INVALIDUSERNAMEERROR);
		
	}
	
	@Test(priority=4,description="Validating User Login With Invalid Credentials",groups= {"smoke"},dataProvider="loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String usernamevalue,String passwordvalue) throws IOException
	{
		//String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		//String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		boolean dashboardDisplay=login.isDashBoardDisplayed();	
		Assert.assertFalse(dashboardDisplay, Constants.INVALIDCREDENTIALERROR);
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] {new Object[]{ "admin" , "admin22" }, new Object[] {"admin123","123"},
		//new Object[]{ExcelUtility.getStringData(3,
		//0,"Login"),ExcelUtility.getStringData(3,1,"Login")
		};
	}

	
}
