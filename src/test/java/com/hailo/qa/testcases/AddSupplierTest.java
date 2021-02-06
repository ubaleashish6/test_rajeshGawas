package com.hailo.qa.testcases;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.google.common.base.Suppliers;
import com.hailo.qa.base.TestBase;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.pages.SuppliersPage;

public class AddSupplierTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	SuppliersPage suppliersPage;

//	public AddSupplierTest() {
//		//super();
//	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		suppliersPage = new SuppliersPage();
		//dashboard = new Dashboard();

	}

	@Test(priority = 1)
	public void createNewSupplier() throws InterruptedException {
		dashboard = new Dashboard();
		dashboard.clickonAdminMenu();
		suppliersPage.openAddSupplierWindow();
		Thread.sleep(5000);
		suppliersPage.enterSupplierName();
		suppliersPage.enterSupplierFirstName();
		suppliersPage.enterSupplierLastName();
		suppliersPage.enterEmail();
		suppliersPage.enterSupplierContact();
		//suppliersPage.uploadDoc();
		Thread.sleep(5000);
		suppliersPage.enableStatus();
		suppliersPage.clickCreateAccountButton();
		Thread.sleep(5000);
	}

//	@Test(priority = 2)
//	public void loginPageLogoTest() {
//		boolean flag = loginPage.validateLogo();
//		Assert.assertTrue(flag);
//	}
//
//	@Test(priority = 3)
//	public void loginTest() throws InterruptedException {
//		dashboard = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
