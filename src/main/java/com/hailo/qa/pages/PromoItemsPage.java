package com.hailo.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hailo.qa.base.TestBase;

public class PromoItemsPage extends TestBase {

	// OR
	@FindBy(xpath = "//a[@name='Promo Items']")
	WebElement Promo_items_menu;

	@FindBy(xpath = "//button[text()='Add Promo Item']")
	WebElement Add_promo_button;

	@FindBy(xpath = "//select[@name='promoCategory']")
	WebElement promo_category_dd;

	@FindBy(xpath = "//select[@name='categorySpecificDocuments']")
	WebElement category_Specific_Documents_text;

	@FindBy(xpath = "//input[@name='promoItemTitle']")
	WebElement promo_Item_Title_text;

	@FindBy(xpath = "//input[@name='promoItemSubtitle']")
	WebElement promo_Item_Subtitle_text;

	@FindBy(xpath = "//input[@name='promoItemStartDate']")
	WebElement promo_Item_StartDate_cal;

	@FindBy(xpath = "//input[@name='promoItemEndDate']")
	WebElement promo_Item_EndDate_cal;

	@FindBy(xpath = "//span[text()='Inactive']")
	WebElement Active_Status_button;

	@FindBy(xpath = "//button[contains(text(),'Add')][@class='btn btn-darkone']")
	WebElement Add_button;

	@FindBy(xpath = "//button[text()='Clear']")
	WebElement clear_button;

	public PromoItemsPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	//
	public void openAddPromoItemWindow() throws InterruptedException {

		Promo_items_menu.click();
		Thread.sleep(3000);
		Add_promo_button.click();
	}

	public void selectCategory() {
		promo_category_dd.click();
		Select selObj = new Select(promo_category_dd);
		selObj.selectByVisibleText("Manuals");

	}

	public void selectDocument() {
		category_Specific_Documents_text.click();
		Select selObj = new Select(category_Specific_Documents_text);
		selObj.selectByVisibleText("HailoERD1.pdf");

	}

	public void enterPromoTitle() {
		promo_Item_Title_text.sendKeys("mjb1 Promo Title");

	}

	public void enterSubTitle() {
		promo_Item_Subtitle_text.sendKeys("mjb1 Promo Sub Title");
	}

	public void setStartDate() {
		promo_Item_StartDate_cal.click();
		promo_Item_StartDate_cal.sendKeys(Keys.ENTER);

	}

	public void enableStatus() throws InterruptedException {
		Active_Status_button.click();
		Thread.sleep(3000);
	}

	public void clickAddPromoButton() {
		Actions act=new Actions(driver);
		act.moveToElement(Add_button).click().build().perform();
		
//		Add_button.click();
		
	}
	
	public void doVerticalScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
	}

	public void selectEndDate() throws InterruptedException {
		promo_Item_EndDate_cal.click();
		Date date = new Date();
		SimpleDateFormat dformat = new SimpleDateFormat("d-MM-yyyy");
		String tdate = dformat.format(date);
		System.out.println(tdate);
		String[] datesplit = tdate.split("-");
		List<WebElement> dateList = driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));

		int i = Integer.parseInt(datesplit[0]) + 1;

		System.out.println("This is next date" + i);
		String s = String.valueOf(i);
		for (WebElement dateelement : dateList) {
			String captureDate = dateelement.getText();
			System.out.println(captureDate);

			if (captureDate.equals(s)) {
				dateelement.click();
				Thread.sleep(2000);
				break;

			}

		}
		Thread.sleep(2000);
	}
	
	public void zoomout() throws AWTException, InterruptedException {
		Robot rb=new Robot();
		/*
		 * for(int i=0; i<3; i++){
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.
		 * SUBTRACT)); }
		 */
		/*
		 * for (int i = 0; i < 2; i++) {
		 * 
		 * 
		 * rb.keyPress(KeyEvent.VK_CONTROL); Thread.sleep(2000);
		 * rb.keyPress(KeyEvent.VK_SUBTRACT); Thread.sleep(2000);
		 * 
		 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_SUBTRACT);
		 * Thread.sleep(2000); }
		 */
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.body.style.zoom='" + level + "%'");
		((JavascriptExecutor)driver).executeScript("document.body.style.zoom='80%';");
		}
	public void pressTabButton() throws AWTException, InterruptedException {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_TAB);
	}
	

}
