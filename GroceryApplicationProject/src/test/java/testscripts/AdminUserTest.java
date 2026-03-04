package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.GroceryBase;
import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class AdminUserTest extends GroceryBase {
	HomePage home;
	AdminUserPage admin;
	
	@Test(description = "Verify that user can create a new admin user using new username and password")
	public void verifyUserCanAddNewAdminUser() throws IOException {
	String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
	String password = ExcelUtility.getStringData(0, 1, "LoginPage");

	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
	home=login.clickOnSignInButton();
	boolean dashBoardDisplay = login.isDashBoardDisplayed();
	Assert.assertTrue(dashBoardDisplay, Constants.VALIDCREDENTIALERROR);

	// AdminUserPage admin=new AdminUserPage(driver);
	// HomePage home=new HomePage(driver);
	admin=home.clickOnAdminUserMoreInfo();
	admin.clickOnNewUserInAdminUserpage();
	FakerUtility faker = new FakerUtility();
	String newUserName = faker.createRandomUserName();
	String newUserPassword = faker.createRandomPassword();

	admin.addNewUserNameInUserNameField(newUserName).addNewPasswordInPasswordField(newUserPassword)
	.saveNewUserByUsingNewUserNameAndPassword();

	boolean alertMessage = admin.isAlertMessageDisplayed();
	Assert.assertTrue(alertMessage, Constants.ADMINUSERADDEDERRORMESSAGE);

	}

	@Test(description = "Verify that user can search admin user using username and user type")
	public void verifyUserCanSearchAdminUserByUsernameAndUserType() throws IOException {
	String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
	String password = ExcelUtility.getStringData(0, 1, "LoginPage");

	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
	home = login.clickOnSignInButton();
	boolean dashBoardDisplay = login.isDashBoardDisplayed();
	Assert.assertTrue(dashBoardDisplay, Constants.VALIDCREDENTIALERROR);

	// AdminUserPage admin=new AdminUserPage(driver);
	// HomePage home=new HomePage(driver);
	admin=home.clickOnAdminUserMoreInfo();
	admin.searchForUser();

	String existingUserName = ExcelUtility.getStringData(0, 0, "AdminSearch");
	admin.enterUsernameInSearchUserNameField(existingUserName).selectUserTypeFromUserTypeDropDown()
	.searchUsingExistingUsernameAndUserType();

	}

	@Test(description = "Verify that user can refresh the admin user list")
	public void verifyUserCanRefreshAdminUserList() throws IOException {
	String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
	String password = ExcelUtility.getStringData(0, 1, "LoginPage");

	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
	home = login.clickOnSignInButton();

	// AdminUserPage admin=new AdminUserPage(driver);
	// HomePage home=new HomePage(driver);
	admin=home.clickOnAdminUserMoreInfo();
	admin.refreshUserList();

	}

	
	
/*	@Test
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
*/
}
