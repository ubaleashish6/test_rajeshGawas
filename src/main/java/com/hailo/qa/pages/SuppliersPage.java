package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hailo.qa.base.TestBase;

public class SuppliersPage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//a[@name='Suppliers']")
	WebElement suppliers_menu;

	@FindBy(xpath = "//button[text()='Add Supplier']")
	WebElement add_supplier_button;

	@FindBy(xpath = "//input[@name='supplierName']")
	WebElement suppliername_text_field;

	@FindBy(xpath = "//input[@name='supplierFirstName']")
	WebElement supplierfirstname_text_field;

	@FindBy(xpath = "//input[@name='supplierLastName']")
	WebElement supplierlastname_text_field;

	@FindBy(xpath = "//input[@name='supplierEmail']")
	WebElement supplieremail_text_field;

	@FindBy(xpath = "//input[@name='supplierContact']")
	WebElement suppliercontact_text_field;

	@FindBy(xpath = "//span[text()='Inactive']")
	WebElement togglebutton;

	@FindBy(xpath = "//input[@id='supplier_payment_status']")
	WebElement chkbox1;
	
	@FindBy(xpath = "//input[@id='supplier_agreement_status']")
	WebElement chkbox2;

	@FindBy(xpath = "//button[@class='docButton ml-4']")
	WebElement docupload_button;

	@FindBy(xpath = "//button[@class='btn btn-secondary btn btn-primary']")
	WebElement clear_button;

	@FindBy(xpath = "//button[@class='btn btn-darkone mr-0 btn btn-primary']")
	WebElement createaccount_button;

	@FindBy(xpath = "//img[@src='data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='21' height='21' viewBox='0 0 21 21'%3E%3Cpath d='M28.5,9.615,26.385,7.5,18,15.885,9.615,7.5,7.5,9.615,15.885,18,7.5,26.385,9.615,28.5,18,20.115,26.385,28.5,28.5,26.385,20.115,18Z' transform='translate(-7.5 -7.5)'/%3E%3C/svg%3E']")
	WebElement close_icon;

	public SuppliersPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public void openAddSupplierWindow() {

		suppliers_menu.click();
		add_supplier_button.click();
	}

	public void enterSupplierName() {
		suppliername_text_field.sendKeys("mjbsupplier");
	}

	public void enterSupplierFirstName() {

		supplierfirstname_text_field.sendKeys("Firstname");
	}

	public void enterSupplierLastName() {
		supplierlastname_text_field.sendKeys("Lastname");

	}

	public void enterEmail() {

		supplieremail_text_field.sendKeys("mjbqasupplier2@mjb.com");
	}

	public void enterSupplierContact() {
		suppliercontact_text_field.click();
		suppliercontact_text_field.sendKeys("9999999999");

	}

	public void enableStatus() {

		togglebutton.click();
	}

	public void clickCreateAccountButton() {

		createaccount_button.click();
	}

	public void uploadDoc() {

		docupload_button.click();
		docupload_button.sendKeys("C:\\Rajesh_Docs\\Hailo\\okay.pdf");

	}

}
