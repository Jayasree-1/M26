package inventoryTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

//@Listeners(genericUtilities.ListenersImplementation.class)
public class MakeanOrderTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
    public void tc_001_MakeanOrderTest() throws IOException, InterruptedException {
		
		/*//create object of all required utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//read common data from property file
		String URL = fUtil.readDatafromPropertyFile("url");
		String USERNAME = fUtil.readDatafromPropertyFile("username");
		String PASSWORD = fUtil.readDatafromPropertyFile("password");*/
	
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//read test data from Excel file
		String PRODUCTNAME = fUtil.readDatafromExcelFile("Product", 1, 2);
		System.out.println(PRODUCTNAME);
		
	   /* //Launch browser
	    WebDriver driver = new ChromeDriver();
	    sUtil.maximizeWindow(driver);
	    sUtil.addImplicitWait(driver);
			
	    //Load application
		driver.get(URL);
			
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.LogintoApp(USERNAME, PASSWORD);*/
		
		Thread.sleep(3000);
		//click on product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnProduct(driver, PRODUCTNAME); 
		System.out.println(pAddedToCart);
								
		//add to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		Thread.sleep(3000);
		//navigate to cart
		ip.clickOnCartContainer();
		
		Thread.sleep(3000);
		//validate the product in Cart
	    CartPage cp = new CartPage(driver);
	    String pInCart = cp.getProductName();
	    System.out.println(pInCart);
		
		/*if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}*/
		
		Assert.assertEquals(pInCart, pAddedToCart);
		
		//Assert.assertTrue(pInCart.equals(pAddedToCart));
		
		System.out.println(pInCart);
		
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
		//ip.logoutOfApp();
		}

}
