package com.wbl.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeClass;

import com.wbl.base.CommonPage;


public class HomePage extends CommonPage {
	HomePage hm;

	@BeforeClass
	public void beforeClass(){
		hm = new HomePage(driver);
	}

	@FindBy(how =How.CSS, using =".nav.navbar-nav.navbar-nav-margin-left>li>a")	
	List<WebElement> linkList;

	@FindBy(css=".navbar-btn.btn.btn-primary.ng-scope")
	WebElement logButton;


	//page classes are dependent on driver objects
	//dependency injection using constructor	

	//public Object logButton;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public int linkList() {
		//return driver.findElements(By.cssSelector(".nav.navbar-nav.navbar-nav-margin-left>li>a")).size();
		return linkList.size();
	}

	public void logButton() {
		//WebElement logButton = driver.findElement(By.cssSelector(".navbar-btn.btn.btn-primary.ng-scope"));
		logButton.click();
	}

}
