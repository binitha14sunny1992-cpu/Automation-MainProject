package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility page = new PageUtility();
	
	public AdminUserPage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement addnewButton;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']")WebElement resetbtn;
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="user_type")WebElement usertype;	
	@FindBy(name="Create")WebElement savebtn;	
	
	@FindBy(id="un")WebElement usernamesearch;
	@FindBy(id="ut")WebElement usertypesearch;	
	@FindBy(name="Search")WebElement btnsearch;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement alertMessage;
	
	
	public AdminUserPage clickOnNewUserInAdminUserpage() 
	{
		addnewButton.click();
		return this;
	}
	public AdminUserPage searchForUser() 
	{
		searchButton.click();
		return this;
	}
	public AdminUserPage refreshUserList() 
	{
		resetbtn.click();
		return this;
	}
	public AdminUserPage addNewUserNameInUserNameField(String newUserName) 
	{
		username.sendKeys(newUserName);
		return this;
	}

	public AdminUserPage addNewPasswordInPasswordField(String newPassword) 
	{
		password.sendKeys(newPassword);
		return this;
	}

	public AdminUserPage saveNewUserByUsingNewUserNameAndPassword() 
	{
		page.selectDropdownWithValue(usertype, Constants.DROPDOWNVALUE1);
		savebtn.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() 
	{
		return alertMessage.isDisplayed();
	}

	public AdminUserPage enterUsernameInSearchUserNameField(String searchUserName) 
	{
		usernamesearch.sendKeys(searchUserName);
		return this;
	}

	public AdminUserPage selectUserTypeFromUserTypeDropDown() 
	{
		page.selectDropdownWithValue(usertypesearch, Constants.DROPDOWNVALUE1);
		return this;
	}

	public AdminUserPage searchUsingExistingUsernameAndUserType() 
	{
		btnsearch.click();
		return this;
	}
	
	
	/*public void newButtonClick()
	{
		newbtn.click();
	}
	public void addNewUser(String newUsername, String newPassword)
	{
		
		username.sendKeys(newUsername);
		password.sendKeys(newPassword);
		Select select =new Select(usertype);
		select.selectByVisibleText("Staff");
		savebtn.click();
		
	}
	public void searchUser()
	{
		searchbtn.click();
		usernamesearch.sendKeys("SampleTester11");
		Select select =new Select(usertypesearch);
		select.selectByVisibleText("Staff");
		btnsearch.click();

		
	}
	public void resetUser()
	{
		resetbtn.click();
	}*/
}
