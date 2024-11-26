package com.HMS.BaseClass;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.HMS.Generic.WebDriverUtilityTest.JavaUtility;
import com.HMS.Generic.WebDriverUtilityTest.UtilityClassObject;
import com.HMS.Generic.WebDriverUtilityTest.WebDriverUtility;
import com.HMS.GenericFileUtilityTest.ExcelUtility;
import com.HMS.GenericFileUtilityTest.FileUtility;

public class BaseClassForHMS {

	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility file = new FileUtility();
	public ExcelUtility Excel = new ExcelUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public JavaUtility j = new JavaUtility();

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("===Database connection is Given===");
		

	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("    ====Preconditions are Given====    ");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException {
		System.out.println("      =====Launching the Browser=====      ");
		String BROWSER = System.getProperty("browser", file.getDataFromPropFile("browser"));
		driver = wu.toLaunchBrowser(driver, BROWSER);
		wu.maximize(driver);
		wu.waitForPageLoad(driver, 20);
		sdriver = driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws IOException {
		System.out.println("        =====  Login  =====        ");
		String URL = System.getProperty("url",file.getDataFromPropFile("url"));
		wu.url(driver, URL);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("        =====  Logout  =====        ");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
		System.out.println("     =====Closing the Browser=====     ");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("    ====Postconditions are Given====    ");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("===Database connection is Disconnected===");

	}
}
