package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import test.BaseClass;

public class ProductPage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")  
	WebElement Item1;
	
	
	public ProductPage() {
		driver = BaseClass.driver;
		report = BaseClass.report;
		test = BaseClass.test;
		
		//Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void addcart() {
		Item1.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	public void dynamicAdd(String string) {
		WebElement ClickLogin = driver.findElement(By.xpath(string));
		ClickLogin.click();
		
	}
	
	
	public void dynamicAdd1(String prodcut) {
		test = report.startTest("Login"); 
		WebElement ClickLogin = driver.findElement(By.xpath("//*[text()='" + prodcut + "']//following::button[1]"));
		ClickLogin.click();
	}
	
}