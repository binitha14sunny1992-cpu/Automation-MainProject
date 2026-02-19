package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminbtn; 
	@FindBy(xpath="//a[contains(@href, 'logout') and @class = 'dropdown-item']")WebElement logoubtn;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser;
	@FindBy(xpath=" //a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenews;
	public void adminClick()
	{
		adminbtn.click();
		
	}
	public void logoutClick()
	{
		logoubtn.click();
	}
	public void clickOnAdminUserMoreInfo()
	{
		adminuser.click();
	}
	public void clickOnmanageNewsMoreInfo()
	{
		managenews.click();
	}

}
