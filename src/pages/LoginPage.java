package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.BaseClass;

public class LoginPage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	
	@FindBy(xpath="//input[@name='user-name']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='login-button']")
	WebElement ClickLogin;
	
	
	public LoginPage() {
		driver = BaseClass.driver;
		report = BaseClass.report;
		test = BaseClass.test;
		
		//Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uname,String pass) {
		test = report.startTest("Login Test Case");
		test.log(LogStatus.PASS, "Login page loaded successfully");
		UserName.sendKeys(uname);
		test.log(LogStatus.PASS, "Successfully provided user name");
		Password.sendKeys(pass);
		test.log(LogStatus.PASS, "Successfully provided password");
		ClickLogin.click();
		test.log(LogStatus.PASS, "Successfully clicked on Login Button");
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	}

}
