package com.wbl;


import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.LoginPage;
import com.wbl.utilities.ExcelHelper;

public class LoginPageTest extends BaseTest{
	HomePage hm;
	LoginPage lp;

	@BeforeClass
	public void beforeClass(){
		hm = new HomePage(driver);

	}

	@DataProvider(name="LoginPage-Data")
	public Object[][] siginData(){
		Object[][] data = ExcelHelper.getExcelData("LoginPage-Data.xlsx", "sheet1");
		return data;
	}	

	@Test(dataProvider="LoginPage-Data")
	public void checkValidUser(String uid,String pass,String expected)
	{
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.LoginSc("valid","valid", true);
		System.out.println("expected value"+expected);
		String actual = lp.LoginSc(uid,pass, false);
		assertNotNull(actual);
		assertTrue(actual.contains(expected));
	}

	@Test(dataProvider="LoginPage-Data")
	public void checkInvalidPassword(String uid,String pass,boolean isValidCredential)
	{
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.LoginSc("valid","invalid", false);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Invalid Password"), "Text not found!");
	}

	@Test(dataProvider="LoginPage-Data")
	public void checkInValidUser(String uid,String pass,boolean isValidCredential)
	{
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.LoginSc("invalid","valid", false);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Invalid username"), "Text not found!");
	}
	@Test(dataProvider="LoginPage-Data")
	public void checkValidUserPassword(String uid,String pass,boolean isValidCredential)
	{
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.LoginSc("valid","valid", true);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Invalid username"), "Text not found!");
	}
}