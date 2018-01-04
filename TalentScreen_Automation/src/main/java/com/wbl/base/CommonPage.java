package com.wbl.base;


import org.openqa.selenium.WebDriver;

public class CommonPage {
	protected WebDriver driver;



	public CommonPage(WebDriver driver) {
		this.driver=driver;
	}


	public String getTitle() {
		return driver.getTitle();
	}



}


