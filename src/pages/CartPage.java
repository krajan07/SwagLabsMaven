package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.BaseClass;

public class CartPage {
	WebDriver driver;
	
	
	
	@FindBy(id="shopping_cart_container")
	WebElement cart;
	
	public CartPage()
	{
		driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyProduct(String product)
	{
		
			cart.click();
			String name = driver.findElement(By.xpath("//*[@class=\"inventory_item_name\"]")).getText();
			Assert.assertEquals(name, product);
			System.out.println("Product Name: " +  name);
		
	}
}
