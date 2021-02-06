package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hailo.qa.base.TestBase;

public class AdminPage extends TestBase {

	@FindBy(xpath = "//span[text()=\"Admin\"]")
	WebElement admin;

	public AdminPage() {

		PageFactory.initElements(driver, this);
	}

}
