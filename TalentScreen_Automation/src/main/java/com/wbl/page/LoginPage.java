package com.wbl.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.wbl.base.CommonPage;

public class LoginPage extends CommonPage {
	@FindBy(css="#username")
	WebElement userName;

	@FindBy(css="#password")
	WebElement passWord;

	@FindBy(css=".btn.btn-primary")
	WebElement submit;

	@FindBy(css=".btn.btn-block.btn-lg.btn-social.btn-github")
	WebElement github;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getCookie(String cookieName)
	{
		return ((LoginPage) driver).getCookie(cookieName);
	}


	public void LoginGit() {
		github.click();
	}

	public String getLogInTitle(){
		return driver.getTitle();
	}

	public String LoginSc(String uid,String pass,boolean isValidCredential) {
		//WebElement userName = driver.findElement(By.cssSelector("#username"));
		userName.sendKeys(uid);
		//WebElement password = driver.findElement(By.cssSelector("#password"));
		passWord.sendKeys(pass);

		submit.click();
		if(isValidCredential == true){
			// check if user is logged in successfully
		} else {
			//check appropriate error message is displayed
		}
		return null;
	}
}
