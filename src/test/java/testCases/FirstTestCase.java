package testCases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.*;

//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {	
	
	WebDriver driver;

//	ATUTestRecorder recorder;

	/*
	 * @BeforeTest public void setUp() throws ATUTestRecorderException {
	 * 
	 * recorder = new ATUTestRecorder("TestResults/", "Hailo Web Portal", false);
	 * recorder.start(); }
	 */
			
@Test(priority = 1)
public void doLogin() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://3.13.129.128:8081/");
	driver.findElement(By.name("email")).sendKeys("ankita.juyal@mjbtech.com");
	driver.findElement(By.name("password")).sendKeys("1111");
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Thread.sleep(2000);
	Reporter.log("We are into Block 1");
}

	@Test(priority = 2)
	public void navigateToAdminPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/nav/div/div[2]/button[1]/span[1]")).click();
		driver.findElement(By.linkText("Roles")).click();
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[2]/td[1]"));
		action.moveToElement(we).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[2]/td[1]/div/a/span")).click();

		Thread.sleep(3000);
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/button/span")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Store User");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void addUser() throws InterruptedException {
		driver.findElement(By.linkText("Users")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='userFirstName']")).sendKeys("test1");
		driver.findElement(By.xpath("//input[@name='userLastName']")).sendKeys("user");
		driver.findElement(By.xpath("//input[@name='userEmailId']")).sendKeys("testuser1@mailinator.com");
		Thread.sleep(2000);
		WebElement userPhoneNo = driver.findElement(By.xpath("//input[@name='userPhoneNo']"));
		userPhoneNo.click();
		driver.findElement(By.xpath("//input[@name='userPhoneNo']")).sendKeys("999999-9999");

		WebElement roleDD = driver.findElement(By.xpath("//select[@name='userRoleId']"));
		Thread.sleep(2000);
		Select selObj = new Select(roleDD);
		selObj.selectByVisibleText("SuperAdmin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/form/div[1]/div[2]/div/div[2]/div/button[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("test1 user");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[2]/td[1]/div/a[3]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"confirm-delete\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
	}
	 
	@Test(priority = 4)
	public void doLogout() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div[2]/ul/li/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div[2]/ul/li/div/div/ul/li[2]/a/span")).click();
	}		
		
		//@AfterTest
		/*public void tearDown() throws ATUTestRecorderException {
			driver.close();
//			recorder.stop();
		}*/

	}

