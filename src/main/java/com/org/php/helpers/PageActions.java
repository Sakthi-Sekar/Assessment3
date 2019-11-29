package com.org.php.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * 
 * @author sakthi
 *
 */

public class PageActions {

	/**
	 * this method returns webElement for respective locator.
	 * 
	 * @param driver
	 * @param property
	 * @param locators
	 * @return
	 * @throws Exception
	 */
	public WebElement getElement(WebDriver driver, Properties property, String locators) throws Exception {

		String[] locatorArray = property.getProperty(locators).split(":", 2);
		String objectType = locatorArray[0].toUpperCase();
		String locator = locatorArray[1];

		switch (objectType) {
		// Find by xpath
		case "XPATH":
			return driver.findElement(By.xpath(locator));

		// Find by css
		case "CSS":
			return driver.findElement(By.cssSelector(locator));

		// find by class
		case "CLASSNAME":
			return driver.findElement(By.className(locator));

		// find by name
		case "NAME":
			return driver.findElement(By.name(locator));

		// find by link
		case "LINK":
			return driver.findElement(By.linkText(locator));

		// find by partial link
		case "PARTIALLINK":
			return driver.findElement(By.partialLinkText(locator));

		default:
			return driver.findElement(By.xpath(locator));
		}
	}

	/**
	 * 
	 * this method returns list of webElements for respective locator.
	 * 
	 * @param driver
	 * @param property
	 * @param locators
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> getElements(WebDriver driver, Properties property, String locators) throws Exception {

		String[] locatorArray = property.getProperty(locators).split(":", 2);
		String objectType = locatorArray[0].toUpperCase();
		String locator = locatorArray[1];

		switch (objectType) {
		// Find by xpath
		case "XPATH":
			return driver.findElements(By.xpath(locator));

		// Find by css
		case "CSS":
			return driver.findElements(By.cssSelector(locator));

		// find by class
		case "CLASSNAME":
			return driver.findElements(By.className(locator));

		// find by name
		case "NAME":
			return driver.findElements(By.name(locator));

		// find by link
		case "LINK":
			return driver.findElements(By.linkText(locator));

		// find by partial link
		case "PARTIALLINK":
			return driver.findElements(By.partialLinkText(locator));

		default:
			return driver.findElements(By.xpath(locator));

		}
	}

	/**
	 * this method return WebElement by selecting perticular selector.
	 * 
	 * @param driver
	 * @param locators
	 * @return
	 * @throws Exception
	 */
	public WebElement getElement(WebDriver driver, String locators) throws Exception {
		// splits into selector type and locator.
		String[] locatorArray = locators.split(":", 2);
		String objectType = locatorArray[0].toUpperCase();
		String locator = locatorArray[1];

		switch (objectType) {
		// Find by xpath
		case "XPATH":
			return driver.findElement(By.xpath(locator));

		// Find by css
		case "CSS":
			return driver.findElement(By.cssSelector(locator));

		// find by class
		case "CLASSNAME":
			return driver.findElement(By.className(locator));

		// find by name
		case "NAME":
			return driver.findElement(By.name(locator));

		// find by link
		case "LINK":
			return driver.findElement(By.linkText(locator));

		// find by partial link
		case "PARTIALLINK":
			return driver.findElement(By.partialLinkText(locator));

		default:
			return driver.findElement(By.xpath(locator));

		}
	}

	/**
	 * returns webElement.
	 * 
	 * @param driver
	 * @param locators
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> getElements(WebDriver driver, String locators) throws Exception {

		// splits into selector type and locator value.
		String[] locatorArray = locators.split(":", 2);
		String objectType = locatorArray[0].toUpperCase();
		String locator = locatorArray[1];

		switch (objectType) {
		// Find by xpath
		case "XPATH":
			return driver.findElements(By.xpath(locator));

		// Find by css
		case "CSS":
			return driver.findElements(By.cssSelector(locator));

		// find by class
		case "CLASSNAME":
			return driver.findElements(By.className(locator));

		// find by name
		case "NAME":
			return driver.findElements(By.name(locator));

		// find by link
		case "LINK":
			return driver.findElements(By.linkText(locator));

		// find by partial link
		case "PARTIALLINK":
			return driver.findElements(By.partialLinkText(locator));

		default:
			return driver.findElements(By.xpath(locator));

		}
	}

	/**
	 * returns WebElement.replaces oldevalue by new value(or index).
	 * 
	 * @param driver
	 * @param property
	 * @param locators
	 * @param oldValue
	 * @param replacedValue
	 * @return
	 * @throws Exception
	 */
	public WebElement getElement(WebDriver driver, Properties property, String locators, String oldValue,
			String replacedValue) throws Exception {
		// replaces common value by indexbased value.
		String locatorValue = property.getProperty(locators).replace(oldValue, replacedValue);
		String[] locatorArray = locatorValue.split(":", 2);
		String objectType = locatorArray[0].toUpperCase();
		String locator = locatorArray[1];

		switch (objectType) {
		// Find by xpath
		case "XPATH":
			return driver.findElement(By.xpath(locator));

		// Find by css
		case "CSS":
			return driver.findElement(By.cssSelector(locator));

		// find by class
		case "CLASSNAME":
			return driver.findElement(By.className(locator));

		// find by name
		case "NAME":
			return driver.findElement(By.name(locator));

		// find by link
		case "LINK":
			return driver.findElement(By.linkText(locator));

		// find by partial link
		case "PARTIALLINK":
			return driver.findElement(By.partialLinkText(locator));

		default:
			return driver.findElement(By.xpath(locator));
		}
	}
	public String getTextValue(WebDriver driver,String cssSelector) {
	JavascriptExecutor execute = (JavascriptExecutor) driver;
	String texts = execute.executeScript("return document.querySelector(" + cssSelector + ").innerText;").toString();
	return texts;
}
}
