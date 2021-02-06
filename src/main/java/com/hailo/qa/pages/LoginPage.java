package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hailo.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//small[contains(@class,'forgotPwd')]")
	WebElement forgotPwd;

//	@FindBy(xpath="//*[@id=\"app\"]/div/div/section/div/div/div[2]/div[2]/form/div[3]/small")
//	WebElement forgotPwd1;

	@FindBy(xpath = "//img[contains(@class,'weblogo1')]")
	WebElement logo;

	// Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public Dashboard login(String un, String pwd) throws InterruptedException {

		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(5000);
		return new Dashboard();
	}

}
