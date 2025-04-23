package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeanOrderusingDDT_Add2items {
	
public static void main(String args[]) throws IOException {
		
		//Read common data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read test data from excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Product");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
		
		Row rw1 = sh.getRow(4);
		Cell cl1 = rw1.getCell(2);
		String PRODUCTNAME1 = cl1.getStringCellValue();

		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load application
		driver.get(URL);
		
		//login to application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//click on product
		WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String pAddedToCart = productEle.getText();
		productEle.click();
						
		//add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//back to products
		driver.findElement(By.id("back-to-products")).click();
		
		//click on product
		WebElement productEle1 = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME1+"']"));
		String pAddedToCart1 = productEle1.getText();
		productEle1.click();
								
		//add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
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
