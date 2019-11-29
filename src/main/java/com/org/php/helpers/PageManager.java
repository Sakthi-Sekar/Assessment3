package com.org.php.helpers;

import java.io.FileInputStream;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.org.php.constants.ConstantPaths;

/**
 * This class contains helper methods.
 * 
 * @author sakthi
 *
 */

public class PageManager {

	public static PageActions helper = new PageActions();

	/**
	 * manage page loading and implicit wait .
	 * 
	 * @param driver
	 */
	public static void manageTimeOuts(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(ConstantPaths.loadingTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ConstantPaths.implicitTime, TimeUnit.SECONDS);
	}

	/**
	 * loads the property file located at specified path.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public Properties loadpropertyFile(String filePath) throws IOException {
		Properties property = new Properties();
		FileInputStream input = new FileInputStream(filePath);
		property.load(input);
		return property;
	}

	/**
	 * scroll the element upto bottom of the page.
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAndView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);

	}

	/**
	 * select the dropdown text.
	 * 
	 * @param driver
	 * @param dropDownLocator
	 * @param dropDownText
	 * @param property
	 * @throws Exception
	 */
	public static void selectDropDownText(WebDriver driver, String dropDownLocator, String dropDownText,
			Properties property) throws Exception {
		Select dropdown = new Select(helper.getElement(driver, property, dropDownLocator));
		dropdown.selectByVisibleText(dropDownText);
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollAndViewAtTop(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * mouse cursor move upto sepcifed element.
	 * 
	 * @param driver
	 * @param element
	 */
	public static void movieToParticularElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public String getDateFormat(String dateFormate) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormate);
		Date date = new Date();
		String currentDate = dateFormat.format(date).toString();
		return currentDate;

	}

	public int generateRandomInt(int upperRange) {
		Random random = new Random();
		return random.nextInt(upperRange);
	}
}
