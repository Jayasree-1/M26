package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to Selenium
 * @author Devi
 */

public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicity wait to the code
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by visible Text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element, String visibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param Value
	 * @param element
	 */
	public void handleDropDown(String Value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(Value);
	}
	
	/**
	 * This method will perform mouse Hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();		
	}
	
	/**
	 * This method will perform double click action
	 * @param driver
	 * @param element
	 */
	public void doubleclickAction(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();		
	}
	
	/**
	 * This method will perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightclickAction(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();		
	}
	
	/**
	 * This method will perform click and Hold action
	 * @param driver
	 * @param element
	 */
	public void clickandHoldAction(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.clickAndHold(element).perform();		
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param element
	 */
	public void dragandDropAction(WebDriver driver , WebElement src, WebElement target)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target).perform();		
	}
	
	/**
	 * This method will scroll to particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	/**
	 * This method will Handle the frame by index
	 * @param driver
	 * @param element
	 */
	public void handleFrameIndex(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by name or id
	 * @param driver
	 * @param element
	 */
	public void handleFrameIdorName(WebDriver driver , String IDorName)
	{
		driver.switchTo().frame(IDorName);
	}
	
	/**
	 * This method will handle frame by FrameElement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver , WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will switch the control back to immediate parent frame
	 * @param driver
	 * @param element
	 */
	public void switchToParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the contro back to main page ignoring all the parent frames
	 * @param driver
	 * @param element
	 */
	public void switchToDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch to window
	 * @param driver
	 * @param element
	 */
	public void switchToWindow(WebDriver driver , String windowHandle)
	{
		driver.switchTo().window(windowHandle);
	}
	
	/**
	 * This method will accept alert popup
	 * @param driver
	 * @param element
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel alert popup
	 * @param driver
	 * @param element
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the alert text and return to caller
	 * @param driver
	 * @param element
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will enter data into alert popup
	 * @param driver
	 * @param element
	 */
	public void enterAlertData(WebDriver driver , String alertData)
	{
		driver.switchTo().alert().sendKeys(alertData);
	}
	
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}
	
	/**
	 * This method will scroll right by 500 units
	 * @param driver
	 */
	public void scrollRight(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(500,0);", "");
	}
	
	/**
	 * This method will scroll left by 500 units
	 * @param driver
	 */
	public void scrollLeft(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(-500,0);", "");
	}
	
	/**
	 * This method will capture the screenshot and return the path to caller
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver , String ScreenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+ScreenshotName+".png"); //tsname_date_time
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //for extent reports
	}
}
