package com.wbl.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class WebDriverUtil {
	static Logger log = LogManager.getLogger(WebDriverUtil.class);

	public static WebDriver getDriver(String browsername) {
		WebDriver driver = null;
		
		
		log.info("i am in" +browsername);

		try {
		
			switch (browsername) {

			case "Chrome":
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case "FireFox":
				System.setProperty("webdriver.firefox.driver",
						System.getProperty("user.dir") + "/resources/geckodriver.exe");
				driver = new FirefoxDriver();

				break;

				default:
				System.setProperty("webdriver.firefox.driver",
						System.getProperty("user.dir") + "/resources/geckodriver.exe");
				driver = new FirefoxDriver();

			}

		} catch (Exception e) {
			log.error("check for error while creating webdriver object");
			log.error(e.getStackTrace());
		}
		return driver;

	}

}
