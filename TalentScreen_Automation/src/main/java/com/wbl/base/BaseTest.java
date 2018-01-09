package com.wbl.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wbl.utilities.ConfigUtils;
import com.wbl.utilities.Constants;
import com.wbl.utilities.WebDriverUtil;

public class BaseTest {
	protected WebDriver driver;
	protected static String url;
	protected static String browser;

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		ConfigUtils configUtils = new ConfigUtils(Constants.RESOURCES_PATH +"config.properties");
		url=configUtils.getProperty("url");
		browser=configUtils.getProperty("browser");
	}

	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		System.out.println("Test Execution Starts");

	}
	@BeforeMethod(alwaysRun=true)
	public void beforeClass() {
		driver = WebDriverUtil.getDriver(browser);
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

}
