package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{
	
	//Declaration step
	//2. identify web elements with annotations
  	@FindBy (className = "shopping_cart_link") private WebElement cartContainerBtn;
	
	@FindBy (id = "react-burger-menu-btn") private WebElement menuBtn;
	
	@FindBy (linkText = "Logout") private WebElement logoutLnk;
	
	@FindBy (className = "product_sort_container") private WebElement sortDropDown;
	
	//Initialization
	//3. create a constructor to initialize webelements
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	//4. provide getters to access the webelements  -> Right click - Source - Generate getters and setters	
	public WebElement getCartContainer() {
		return cartContainerBtn;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLnk;
	}

	public WebElement getSortDropDown() {
		return sortDropDown;
	}	
	
	//Business Library - Generic method - related to application
	/**
	 * This method will click on a product and return the details to caller
	 * @param username
	 * @param password
	 */
	public String clickOnProduct(WebDriver driver , String productname)
	{
		WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
	    String productdetails = ele.getText();
	    ele.click();
	    
	    return productdetails;
	}
	
	/**
	 * This method will click on lowest priced product and return the product details to caller
	 * @param driver
	 * @param ProductName
	 * @param sortOption
	 * @return
	 */
	public String clickOnLowestPriceProduct(WebDriver driver, String productname, String sortOption)
	{
		handleDropDown(sortDropDown, sortOption);
		WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
		String productdetails = ele.getText();
		ele.click();
		
		return productdetails;
	}
	
	/**
	 * This product will perform logout operation
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	/**
	 * This method will click on cart container
	 */
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}
}
