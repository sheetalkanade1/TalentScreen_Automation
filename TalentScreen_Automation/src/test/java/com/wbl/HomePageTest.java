package com.wbl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;

public class HomePageTest extends BaseTest{
	HomePage hm;

	@BeforeClass
	public void beforeClass(){
		hm = new HomePage(driver);
	}	

	@Test(groups= {"Smoke"})
	public void linkList() {
		hm= PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals(3,  hm.linkList());
	}


	@Test(groups= {"Smoke"})
	public void logButton() {
		// verify that the “login button” is displayed and enabled
		hm= PageFactory.initElements(driver, HomePage.class);
		WebElement logButton = driver.findElement(By.xpath(".navbar-btn.btn.btn-primary.ng-scope"));
		Assert.assertTrue(logButton.isDisplayed());
	}
}


