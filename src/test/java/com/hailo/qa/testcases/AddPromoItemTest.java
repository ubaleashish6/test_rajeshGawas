package com.hailo.qa.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.google.common.base.Suppliers;
import com.hailo.qa.base.TestBase;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.pages.PromoItemsPage;

public class AddPromoItemTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	PromoItemsPage promoitem;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		promoitem = new PromoItemsPage();
	}

//	@Test(priority = 1)
//	public void viewPromoItem() {
//		dashboard = new Dashboard();
//		dashboard.clickonMasterMenu();
//		
//	}

	@Test(priority = 2)
	public void createNewSupplier() throws InterruptedException, AWTException {
		//promoitem.zoomout();
		dashboard = new Dashboard();
		dashboard.clickonMasterMenu();
		Thread.sleep(2000);
		//promoitem.doVerticalScroll();
		//promoitem.zoomout();
		promoitem.openAddPromoItemWindow();
		Thread.sleep(2000);
		
		promoitem.selectCategory();
		promoitem.selectDocument();
		promoitem.enterPromoTitle();
		promoitem.enterSubTitle();
		promoitem.setStartDate();
		Thread.sleep(2000);
		promoitem.selectEndDate();
		Thread.sleep(1000);
		promoitem.pressTabButton();
		Thread.sleep(1000);
		try {
			promoitem.clickAddPromoButton();
		}
		catch(NoSuchElementException e) {
			//driver.findElement(By.xpath("//button[contains(text(),'Add')][@class='btn btn-darkone']")).click();
		}
		
		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
