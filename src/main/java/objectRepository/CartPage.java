package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//Declaration step
	//2. identify web elements with annotations
	@FindBy (id = "checkout") private WebElement checkout;
	
	@FindBy(xpath = "//button[.='Remove']") private WebElement removeBtn;
	
	@FindBy(className = "inventory_item_name") private WebElement itemInfo;
	
	//Initialization
	//3. create a constructor to initialize webelements
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	//4. provide getters to access the webelements  -> Right click - Source - Generate getters and setters	
	public WebElement getCheckout() {
		return checkout;
	}


	public WebElement getRemoveBtn() {
		return removeBtn;
	}


	public WebElement getItemInfo() {
		return itemInfo;
	}

	/**
	 * This method will capture the product name
	 * @return
	 */
	public String getProductName()
	{
		return itemInfo.getText();
	}
		

}
