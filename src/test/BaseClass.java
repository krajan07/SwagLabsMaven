package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	XSSFWorkbook wbook;
	protected XSSFSheet sheet;
	
	SoftAssert soft = new SoftAssert();

	
	@BeforeTest
	public void setup() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//test.log(LogStatus.PASS, "Login page loaded successfully");
		report = new ExtentReports("ExtentReport.html");
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet=wbook.getSheetAt(0);
	}
	
	
	@AfterTest
	public void TearDown()
	{
		//test.log(LogStatus.PASS, "Testing Completed");
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
