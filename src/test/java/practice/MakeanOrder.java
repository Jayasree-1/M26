package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeanOrder {
	
	public static void main(String args[]) {
		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load application
		driver.get("https://www.saucedemo.com/");
		
		//login to application
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//click on product
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		
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
