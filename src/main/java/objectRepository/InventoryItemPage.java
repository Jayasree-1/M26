package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	//Declaration step
	//2. identify web elements with annotations
	@FindBy (id = "add-to-cart") private WebElement addTocartBtn;
	
	@FindBy (className = "inventory_details_price") private WebElement price;
	
	//Initialization
	//3. create a constructor to initialize webelements
	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	//4. provide getters to access the webelements  -> Right click - Source - Generate getters and setters	
	public WebElement getAddToCart() {
		return addTocartBtn;
	}

	public WebElement getPrice() {
		return price;
	}
	
	public void clickOnAddToCartBtn()
	{
		addTocartBtn.click();
	}

}
