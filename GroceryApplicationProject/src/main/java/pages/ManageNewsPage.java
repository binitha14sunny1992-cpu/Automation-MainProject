package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	public ManageNewsPage(WebDriver driver) //constructor creation
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement addNewNews;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchNews;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='btn btn-rounded btn-warning']")WebElement resetbtn;
	
	@FindBy(xpath="//textarea[@id='news']")WebElement addNewsContent;	
	@FindBy(name="create")WebElement saveNewsBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	
	@FindBy(name="un")WebElement searchnews;	
	@FindBy(name="Search")WebElement searchNewsBtn;
	
	public ManageNewsPage clickOnAddNewNews() 
	{
		addNewNews.click();
		return this;
	}
	public ManageNewsPage clickOnSearchNews() 
	{
		searchNews.click();
		return this;
	}
	public ManageNewsPage refreshNewsList() 
	{
		resetbtn.click();
		return this;
	}
	public ManageNewsPage addNewNewsContent(String newNewsContent) 
	{
		addNewsContent.sendKeys(newNewsContent);
		return this;
	}
	public ManageNewsPage saveNewNews() 
	{
		saveNewsBtn.click();
		return this;
	}
	public ManageNewsPage enterSearchContentToBeSearched() 
	{
		searchnews.sendKeys("Sample Test1");
		return this;
	}
	public ManageNewsPage clickOnSeachButtonAfterEnteringSearchContent() 
	{
		searchNewsBtn.click();
		return this;
	}
	public boolean isAlertMessageDisplayed() 
	{
		return alertMessage.isDisplayed();
	}
	
	
	/*public void addNewNews()
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
	}*/
}
