package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;
public class HomePage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	public HomePage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminbtn; 
	@FindBy(xpath="//a[contains(@href, 'logout') and @class = 'dropdown-item']")WebElement logoubtn;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser;
	@FindBy(xpath=" //a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenews;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']")WebElement homebtn;
	public HomePage clickOnHomeButtonOnHomePage()
	{
		wait.waitUntilElementToBeClickable(driver, homebtn);
		homebtn.click();
		return this;
	}	
	public LoginPage clickOnLogoutButton()
	{
		wait.waitUntilElementToBeClickable(driver,adminbtn);
		adminbtn.click();
		wait.waitUntilElementToBeClickable(driver,logoubtn);
	    logoubtn.click();
	    return new LoginPage(driver) ;
	}
	public boolean isRedirectToLoginPage()
	{
		return driver.getCurrentUrl().contains("login");
	}
	public AdminUserPage clickOnAdminUserMoreInfo()
	{
	    adminuser.click();
	    return new AdminUserPage(driver);
	}
	public ManageNewsPage clickOnmanageNewsMoreInfo()
	{
	    managenews.click();
	    return new ManageNewsPage(driver);
	}

}
