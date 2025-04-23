package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //1.create a seperate POM class
	
	//Declaration step
	//2. identify web elements with annotations
	@FindBy (id = "user-name") private WebElement usernameEdt;
	
	//@FindBy (name = "password") private WebElement passwordEdt;
	//Auto Healing process - if the first locator is not able to identify the web element automatically then FindAll annotations will shift to another locator for identifying the webelement  
	@FindAll({@FindBy(id = "password"),@FindBy(name = "password")}) private WebElement passwordEdt; //single web element with multiple loactors - OR operator
	
	//@FindBys({@FindBy(id = "password"),@FindBy(name = "password")}) private WebElement passwordEdt; //single web element with multiple loactors - AND operator
	
	@FindBy (className = "submit-button") private WebElement loginBtn;
	
	//Initialization
	//3. create a constructor to initialize webelements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	//4. provide getters to access the webelements  -> Right click - Source - Generate getters and setters
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - Generic method - related to application
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void LogintoApp(String username , String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
