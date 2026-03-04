package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static int EXPLICITWAIT = 5;
	  public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
	 
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	  }
	 
	    public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.elementToBeSelected(element));
	    }

	    public void waitUntilVisibilityOfAllElements(WebDriver driver, WebElement elements) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    }
	    public void waitUntilFrameToBeAvailableAndSwitch(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	    }
	    public void waitUntilInvisibilityOfElement(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.invisibilityOf(element));
	    }
	    public void waitUntilTextToBePresentInElementValue(WebDriver driver, WebElement element, String text) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	    }

}
