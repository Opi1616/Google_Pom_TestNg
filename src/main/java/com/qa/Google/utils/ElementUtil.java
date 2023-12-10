package com.qa.Google.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Google.factory.DriverFactory;

public class ElementUtil {
	private WebDriver driver;
	private JavaScriptUtil jsutil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsutil = new JavaScriptUtil(driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if (Boolean.parseBoolean(DriverFactory.highlight)) {
			jsutil.drawBorder(element);
		}
		return element;
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> element = driver.findElements(locator);
		return element;
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void goToDefaultContaint() {
		driver.switchTo().defaultContent();
	}

	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		default:
			System.out.println("Please pass the right locator type and value ");
			break;
		}
		return locator;
	}

	public WebElement getElement(String locatorType, String locatorvalue) {
		return driver.findElement(getBy(locatorType, locatorvalue));
	}

	public WebElement getElement(By locator, int timeout) {
		return doPresenceOfElementLocated(locator, timeout);
	}

	public void doClear(By locator) {
		getElement(locator).clear();
	}

	public String doGetTitle() {
		return driver.getTitle();
	}

	public String doGetCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void doNavaigateBack() {
		driver.navigate().back();
	}

	public void doSendKeys(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}

	public void doSendKeysWithEnter(By locator, Keys key) {
		getElement(locator).sendKeys();
	}

	public WebElement doSendKeys(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(String locatorType, String locatorvalue) {
		getElement(locatorType, locatorvalue).click();
	}

	public void doClick(By locator, int timeout) {
		doPresenceOfElementLocated(locator, timeout).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public String openAppPage(String frame, By ProductName, By header) throws InterruptedException {
		waitForFrameByname(frame, 10);
		doClick(ProductName);
		String title = doGetTitle();

		doIsDisplayed(header);
		Thread.sleep(2000);
		return title;

	}

	public List<String> getElementsTextlist(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eletextList = new ArrayList<>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isBlank()) {
				eletextList.add(text);
			}
		}
		return eletextList;
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static void printElementValue(List<String> eleList) {
		for (String e : eleList) {
			System.out.println(e);
		}

	}

	public List<String> getAttributeList(By locator, String attributeName) {

		List<WebElement> eleList = getElements(locator);
		List<String> attrList = new ArrayList<>();
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attributeName);
			attrList.add(attrValue);
		}
		return attrList;
	}

	public int TotalstarMails(By locator, int timeout) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
		System.out.println("Total star mail is : " + eleList.size());
		for (WebElement e : eleList) {
			e.isDisplayed();
		}
		return eleList.size();

	}

	public int TotalReadEmails(By locator, int timeout) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
		System.out.println("total Read mail is: " + eleList.size());
		for (WebElement e : eleList) {
			e.isDisplayed();
		}
		return eleList.size();
	}

	public int TotalUnReadEmails(By locator, int timeout) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
		System.out.println("total Unread mail is: " + eleList.size());
		for (WebElement e : eleList) {
			e.isDisplayed();
		}
		return eleList.size();
	}

	public void productopen(By locator, By APplocator, String frame) {
		List<WebElement> prodList = getElements(locator);
		for (WebElement element : prodList) {
			driver.switchTo().frame(frame);
			element.click();
			doNavaigateBack();
			doClick(APplocator);
		}

	}

	public String getAttributeValue(By locator, String attrName) {
		String attrval = getElement(locator).getAttribute(attrName);
		System.out.println(attrval);
		return attrval;
	}

	public boolean isElementExist(By locator) {
		int elementCount = getElementsCount(locator);
		System.out.println("Total element found:  " + elementCount);
		if (elementCount >= 1) {
			System.out.println("Element is found" + locator);
			return true;
		} else {
			System.out.println("Element is not found" + locator);
			return false;
		}

	}

	/**********************************************
	 * DropDownSelectClassUtilities
	 ***************************************************/

	public void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doDropDownselectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doDropDownselectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectDropDwon(By locator, String Value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(Value)) {
				e.click();
				break;
			}
		}

	}

	public void doSelectDropDwonWithouSelectClass(By locator, String Value) {
		List<WebElement> optionList = getElements(locator);
		System.out.println(optionList.size());
		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(Value)) {
				e.click();
				break;
			}
		}

	}

	/*********************************************
	 * List Util
	 *********************************************/
	public List<String> getLinkTextList(By locator, String LinkText) {
		List<WebElement> langList = getElements(locator);
		List<String> LinkTextList = new ArrayList<>();
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText();
			LinkTextList.add(text);
			if (text.equals(LinkText)) {
				e.click();
				break;
			}

		}
		return LinkTextList;
	}

	public void clickOnElementFromSection(By locator, String LinkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(LinkText)) {
				e.click();
				break;
			}

		}

	}

	/******************************
	 * WebTable Util
	 *************************************/
	public void printTable(By rowlocator, By collocator, String beforeXpath, String afterXpath) {
		int rowCount = getElements(rowlocator).size();
		int colCount = getElements(collocator).size();
		for (int row = 2; row <= rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				String xpath = beforeXpath + row + afterXpath + col + "]";
				String text = doGetText(By.xpath(xpath));
				System.out.print(text + "    ");
			}
			System.out.println();
		}

	}

	/*************************************
	 * Action Util
	 *************************************************/
	public void doMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).perform();
	}

	public void doClickOnChildMenu(By ParentmenuLocator, By ChildmenuLocator) throws InterruptedException {
		doMoveToElement(ParentmenuLocator);
		Thread.sleep(3000);
		doClick(ChildmenuLocator);
	}

	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionSendKeysonActiveElement(By locator, String value) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).sendKeys(value).build().perform();
	}

	/**
	 * Clicks in the middle of the given element. Equivalent to:
	 * Actions.moveToElement(onElement).click()
	 *
	 * @param locator
	 */

	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled into
	 * view and itslocation is calculated using getClientRects.
	 *
	 * @param locator
	 */
	public void doActionMoveToElementClick(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();

	}

	/*************** Window Handles ******************/
	public void switchToChild() {
		Set<String> handles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(handles);
		String parentWIndowId = handleList.get(0);
		String childWindowId = handleList.get(1);
		driver.switchTo().window(childWindowId);
	}

	/************************** Wait Utils **********************************/
	public void doSendKeys(By locator, String value, int timeOut) {
		doPresenceOfElementLocated(locator, timeOut).sendKeys(value);
	}

	public void waitForElementToBeVisibleAndDoSendKeys(By locator, int timeout, long intervalTime, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
	}

	public WebElement doPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement isElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBeVisible(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBeVisibleWithElement(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<String> getElementsTextWithWait(By locator, int timeout) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
		List<String> eleTexList = new ArrayList<>();
		for (WebElement e : eleList) {
			String text = e.getText();
			eleTexList.add(text);
		}
		return eleTexList;
	}

	/************* Wait Utils For Non Web Elements ****************/

	public boolean waitForUrlToContain(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public boolean waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public String doGetTitleWithfraction(String titleFraction, int timeOut) {
		if (waitForTitleContains(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	public String doGetTitle(String title, int timeOut) {
		if (waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	public boolean waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}

	public boolean waitForTitleToBe(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(titleFraction));
	}

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}

	public void doAlertAccepect(int timeout) {
		waitForAlert(timeout).accept();
	}

	public void doAlertDismiss(int timeout) {
		waitForAlert(timeout).dismiss();
	}

	public void enterAlertText(String text, int timeout) {
		waitForAlert(timeout).sendKeys(text);
	}

	public void waitForFrameByname(String nameOrID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
	}

	public void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameByLocator(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFrameByElement(By frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public void clickElementWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void clickElementWhenReady(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementPresentUsingfluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("Element is not found......");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement WaitForElementUsingWebDriverWait(int timeOut, int pollingTime, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.withTimeout(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage("Element is not found...");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/***************** Custom Wait *****************/

	public WebElement retryingElement(By locator, int timeOut, long pollingTime) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ":" + locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;

		}

		if (element == null) {
			try {
				throw new Exception("ElementNotFoundException");
			} catch (Exception e) {
				System.out.println("element is not found exception.. tried for : " + timeOut + "with the interval of: "
						+ attempts);
			}
		}

		return element;
	}

}
