package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;
	public AdminUserPage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbtn;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbtn;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']")WebElement resetbtn;
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="user_type")WebElement usertype;	
	@FindBy(name="Create")WebElement savebtn;	
	
	@FindBy(id="un")WebElement usernamesearch;
	@FindBy(id="ut")WebElement usertypesearch;	
	@FindBy(name="Search")WebElement btnsearch;
	public void newButtonClick()
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
	}
}
