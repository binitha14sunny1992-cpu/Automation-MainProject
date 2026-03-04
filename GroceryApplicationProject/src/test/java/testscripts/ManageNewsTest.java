package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import org.testng.Assert;

import automationcore.GroceryBase;
import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends GroceryBase{
	
	HomePage home;
	ManageNewsPage news;
	
	@Test(description = "Verifying user can add new news")

	public void createNewNewsItem() throws IOException {
	String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
	String Password = ExcelUtility.getStringData(0, 1, "LoginPage");

	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
	home = login.clickOnSignInButton();
	boolean dashBoardDisplay = login.isDashBoardDisplayed();
	Assert.assertTrue(dashBoardDisplay, Constants.VALIDCREDENTIALERROR);

	// HomePage home=new HomePage(driver);
	news = home.clickOnmanageNewsMoreInfo();

	// ManageNewsPage news=new ManageNewsPage(driver);
	news.clickOnAddNewNews();
	FakerUtility faker = new FakerUtility();
	String newsContent = faker.createRandomContent();
	news.addNewNewsContent(newsContent);
	news.saveNewNews();

	boolean alertMessageDisplay = news.isAlertMessageDisplayed();
	Assert.assertTrue(alertMessageDisplay, Constants.NEWSADDEDERRORMESSAGE);
	}

	@Test(description = "Verifying user can search the news list")

	public void searchForExistingNewsItems() throws IOException {
	String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
	String Password = ExcelUtility.getStringData(0, 1, "LoginPage");

	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
	home = login.clickOnSignInButton();
	boolean dashBoardDisplay = login.isDashBoardDisplayed();
	Assert.assertTrue(dashBoardDisplay, Constants.VALIDCREDENTIALERROR);

	// HomePage home=new HomePage(driver);
	news = home.clickOnmanageNewsMoreInfo();

	// ManageNewsPage news=new ManageNewsPage(driver);
	news.clickOnSearchNews();
	news.enterSearchContentToBeSearched();
	news.clickOnSeachButtonAfterEnteringSearchContent();
	}

	@Test(description = "Verifying user can refresh the news list")
	public void refreshTheNewsListingPage() throws IOException {
	String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
	String Password = ExcelUtility.getStringData(0, 1, "LoginPage");

	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
	home = login.clickOnSignInButton();
	boolean dashBoardDisplay = login.isDashBoardDisplayed();
	Assert.assertTrue(dashBoardDisplay, Constants.VALIDCREDENTIALERROR);

	// HomePage home=new HomePage(driver);
	news = home.clickOnmanageNewsMoreInfo();

	// ManageNewsPage news=new ManageNewsPage(driver);
	news.refreshNewsList();
	}

	
	/*@Test
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
*/
}
