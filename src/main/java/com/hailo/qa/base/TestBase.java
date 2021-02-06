package com.hailo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.hailo.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					//"C:/Users/rajesh.gawas/eclipse-workspace/com.hailo/src/main/java/config.properties"
					System.getProperty("user.dir")+"/src/main/java/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("user-data-dir=C:\\Users\\rajesh.gawas\\AppData\\Local\\Google\\Chrome\\User Data\\Guest Profile");
			//options.addArguments("--start-maximized");
		    //options.addArguments("Zoom 90%");
			driver = new ChromeDriver();
			//((JavascriptExecutor)driver).executeScript("document.body.style.zoom='80%';");

		} else if (browserName.equals("FF")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("user-data-dir=C:\\Users\\rajesh.gawas\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\o98lusvh.FFselenium");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
//		driver.get(prop.getProperty("PAGE_LOAD_TIMEOUT"));
//		driver.get(prop.getProperty("IMPLICIT_WAIT"));
	}
	
	

}
