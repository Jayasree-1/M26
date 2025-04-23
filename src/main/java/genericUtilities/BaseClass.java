package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class conists of basic configuration annotations of TestNG.
 * Author Devi
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	//For listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("---Database Connection successful---");
	}
	
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException
	{
		String URL = fUtil.readDatafromPropertyFile("url");
		
		driver = new FirefoxDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitWait(driver);
		
		driver.get(URL);
		
		System.out.println("---Browse Launch successful---");		
		
		//for listeners
		sdriver = driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDatafromPropertyFile("username");
		String PASSWORD = fUtil.readDatafromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LogintoApp(USERNAME, PASSWORD);
		
		System.out.println("---Login to App successful---");	
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
	    ip.logoutOfApp();
	    
	    System.out.println("---Logout of App successful---");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("---Browser Closure successful---");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("---Database Closure successful---");
	}

}