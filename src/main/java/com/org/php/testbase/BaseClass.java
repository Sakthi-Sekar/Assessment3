package com.org.php.testbase;

import java.io.IOException;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.beust.jcommander.Parameter;
import com.org.php.constants.ConstantPaths;
import com.org.php.helpers.PageActions;
import com.org.php.helpers.PageManager;
import com.org.php.helpers.WaitHelperClass;
import com.org.php.reports.LogReports;

public class BaseClass {

	public PageActions helper = new PageActions();
	public LogReports log=new LogReports();
	public WebDriver driver;
	public Properties property;
	public PageManager pageManager = new PageManager();
	public WaitHelperClass wait=new WaitHelperClass();

	/**
	 * select driver class type
	 * 
	 * @param browserType
	 * @throws IOException
	 */
	@BeforeTest
	public void openBrowser() throws IOException {
		property = pageManager.loadpropertyFile(ConstantPaths.CONFIG_FILE);
		String browserType = property.getProperty("browser");

		switch (browserType) {

		case "chrome":
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
			driver = new ChromeDriver(optionschrome);
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
			driver = new InternetExplorerDriver();
			break;

		}

		driver.manage().window().maximize();
		PageManager.manageTimeOuts(driver);
		driver.get(property.getProperty("url"));
		log.info("URL opened");

	}
//
//	@AfterTest
//	public void quitBrowser() {
//		driver.quit();
//	}
}
