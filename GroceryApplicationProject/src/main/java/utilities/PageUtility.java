package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {
		  Select object = new Select(element);
		  object.selectByValue(value);
		  }
		public void selectDropdownWithIndex(WebElement element, String value) {
		Select object = new Select(element);
		  object.selectByValue(value);
		}
		public void selectDropdownByVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		  object.selectByValue(value);
		}

		public void rightClick(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).build().perform();
		    }
		public void mouseHover(WebDriver driver, WebElement element) {
		        Actions a = new Actions(driver);
		        a.moveToElement(element).build().perform();
		    }
		public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions a=new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		   }
		public void selectRadioButton(WebElement element) {
		           element.click();
		       }
		public void selectCheckbox(WebElement element) {
		 
		            element.click();
		    }
		    public void keyboardAction() throws AWTException {
		        Robot robot = new Robot();
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        robot.keyPress(KeyEvent.VK_T);
		        robot.keyRelease(KeyEvent.VK_T);
		        robot.keyRelease(KeyEvent.VK_CONTROL);
		    }

}
