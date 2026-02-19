package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends GroceryBase {
	
	@Test
	public void verifyWheTherUserIsAbleToAddNewUser() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnAdminUserMoreInfo();
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);	
		adminuserpage.newButtonClick();		
		FakerUtility faker=new FakerUtility();
		String newUserName=faker.createRandomUserName();
		String newPassword=faker.createRandomPassword();
		adminuserpage.addNewUser(newUserName, newPassword);
		
		
	}
	
	@Test
	public void verifyTheUserIsAbleToSearchTheNewUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnAdminUserMoreInfo();
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);		
		adminuserpage.searchUser();
	}
	
	@Test
	public void verifyWheTherUserIsAbleToResetTheAdminuserList() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");		
		LoginPage login=new LoginPage(driver);		
		login.enterUserNameOnUserNameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnAdminUserMoreInfo();
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);		
		adminuserpage.resetUser();
	}

}
