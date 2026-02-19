package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbtn;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbtn;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='btn btn-rounded btn-warning']")WebElement resetbtn;
	
	@FindBy(xpath="//textarea[@id='news']")WebElement news;	
	@FindBy(name="create")WebElement savebtn;
	
	@FindBy(name="un")WebElement searchnews;	
	@FindBy(name="Search")WebElement btnsearch;
	
	public void addNewNews()
	{
		newbtn.click();
		news.sendKeys("New grocery Offers Updated 3");		
		savebtn.click();
		
	}
	public void searchNews()	
	{
		searchbtn.click();
		searchnews.sendKeys("New grocery Offers Updated 3");			
		btnsearch.click();
		
	}
	public void resetNews()
	{
		resetbtn.click();
	}
}
