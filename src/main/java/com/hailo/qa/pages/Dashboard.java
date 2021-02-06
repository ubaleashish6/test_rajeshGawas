package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hailo.qa.base.TestBase;

public class Dashboard extends TestBase {

	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dash;

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement admin;

	@FindBy(xpath = "//span[text()='Master']")
	WebElement master;

	public Dashboard() {

		PageFactory.initElements(driver, this);
	}

	public String ValidateDashboardTitle() {
		return driver.getTitle();
	}

	public boolean ValidateLogo() {
		return dash.isDisplayed();

	}

	public void clickonAdminMenu() {

		admin.click();
	}

	public void clickonMasterMenu() {
		master.click();
	}
}
