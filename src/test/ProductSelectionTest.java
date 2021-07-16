package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;


public class ProductSelectionTest extends BaseClass {
	@Test
	public void loginSwaglab() {
		
		LoginPage objLogin = new LoginPage();
		String uname = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();
		objLogin.login(uname, pass);
		//test.log(LogStatus.PASS, "Login successfully");
	}
	
	@Test
	public void selectProduct() {
		ProductPage objProduct1 = new ProductPage();
		String product = sheet.getRow(1).getCell(2).getStringCellValue();
		objProduct1.dynamicAdd1(product);
		//test.log(LogStatus.PASS, "Product selection successfully");
	}
	
	@Test
	public void verifyProduct() {
		CartPage objCart = new CartPage();
		String product = sheet.getRow(1).getCell(2).getStringCellValue();
		objCart.verifyProduct(product);
		//test.log(LogStatus.PASS, "Product verification successfully");
	}
}
