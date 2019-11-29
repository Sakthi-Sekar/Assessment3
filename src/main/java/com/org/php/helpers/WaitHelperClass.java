package com.org.php.helpers;

import java.time.Duration;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.php.constants.ConstantPaths;



/**
 * This class contains waits.
 * 
 * @author sakthi
 *
 */



public class WaitHelperClass {
	PageActions helper=new PageActions();


public WebElement fluentWaitHelper(WebDriver driver,String locators,String ignoringException,Properties property ) {
	FluentWait<WebDriver> fluentWait;
	String exceptionType=ignoringException.toLowerCase();
	
	switch(exceptionType) {
	
	case "staleelementexception":
	fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(ConstantPaths.mxaximumFluentWait))
			.pollingEvery(Duration.ofSeconds(ConstantPaths.pollingWait))
			.ignoring(StaleElementReferenceException.class);
	break;
	case "elementnotinteractableexception":
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(ConstantPaths.mxaximumFluentWait))
				.pollingEvery(Duration.ofSeconds(ConstantPaths.pollingWait))
				.ignoring(ElementNotInteractableException.class);
		break;
	case "elementnotselectableexception":
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(ConstantPaths.mxaximumFluentWait))
				.pollingEvery(Duration.ofSeconds(ConstantPaths.pollingWait))
				.ignoring(ElementNotSelectableException.class);
		break;
	case "elementnotvisibleexception":
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(ConstantPaths.mxaximumFluentWait))
				.pollingEvery(Duration.ofSeconds(ConstantPaths.pollingWait))
				.ignoring(ElementNotVisibleException.class);
		break;
		
	default :
	fluentWait = new FluentWait<WebDriver>(driver)
	.withTimeout(Duration.ofSeconds(ConstantPaths.mxaximumFluentWait))
	.pollingEvery(Duration.ofSeconds(ConstantPaths.pollingWait))
	.ignoring(NoSuchElementException.class);
	break;
	}
	WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver webdriver) {
			
			try {
				return helper.getElement(webdriver, property, locators);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return null;
		}
	});
	return element;
	
}
@SuppressWarnings("deprecation")
public WebElement explictWaitHelper(WebDriver driver,String locators,String expectedCondition,Properties property) throws Exception {
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver,ConstantPaths.explictWaitTime);
	if(expectedCondition.equalsIgnoreCase("clickable")) {
	element=wait.until(ExpectedConditions.elementToBeClickable(helper.getElement(driver, property, locators)));
		return element;
	}
		else {
			element=wait.until(ExpectedConditions.visibilityOf(helper.getElement(driver, property, locators)));
		return element;
		
	}
		
}
}
