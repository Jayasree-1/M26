package practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class MakeanOrderUsingDDTandGU {
	
	public static void main(String args[]) throws EncryptedDocumentException, IOException {
		
		//create object of all required utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//read common data from property file
		String URL = fUtil.readDatafromPropertyFile("url");
		String USERNAME = fUtil.readDatafromPropertyFile("username");
		String PASSWORD = fUtil.readDatafromPropertyFile("password");
	
		//read test data from Excel file
		String PRODUCTNAME = fUtil.readDatafromExcelFile("Product", 1, 2);
		
	    //Launch browser
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	    //Load application
		driver.get(URL);
			
		//login to application
		//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		//driver.findElement(By.name("password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.LogintoApp(USERNAME , PASSWORD);
		
		//lp.getUsernameEdt().sendKeys(USERNAME);
		//lp.getPasswordEdt().sendKeys(PASSWORD);
		//lp.getLoginBtn().click();
			
		//click on product
		WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String pAddedToCart = productEle.getText();
		productEle.click();
							
		//add to cart
		driver.findElement(By.id("add-to-cart")).click();
			
		//navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//capture screenshot for reference
		String screenshotname = "Tc_001"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenshot(driver, screenshotname);
		System.out.println(path);
			
		//click on checkout
		driver.findElement(By.id("checkout")).click();
			
		//enter data 
		driver.findElement(By.id("first-name")).sendKeys("Devi");
		driver.findElement(By.id("last-name")).sendKeys("Peddireddy");
		driver.findElement(By.id("postal-code")).sendKeys("521301");
			
		//click on continue
		driver.findElement(By.id("continue")).click();
			
		//click on finish
		driver.findElement(By.id("finish")).click();
			
		//Validate on successful completion
		String Msg = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		String expMsg = "Thank you for your order!";
		if(Msg.equals(expMsg))
			{
				System.out.println("pass");
				System.out.println(Msg);
			}
		else
			{
				System.out.println("Fail");
			}
			
		//Logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		}
}
