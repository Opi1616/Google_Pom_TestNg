package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class GoogleSearchPage {
	private WebDriver driver;
	private ElementUtil eutil;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By searchBar = By.xpath("//input[@title='Search']");
	private By Search = By.xpath("(//input[@name='btnK'])[2]");
	private By SearchMain = By.xpath("(//input[@name='btnK'])[1]");
	private By Iamlucky = By.xpath("(//input[@name='btnI'])[2]");
	private By maps = By.xpath("(//a[@class='tX9u1b'])[3]");

	private By हिन्दी = By.xpath("//a[text()='हिन्दी']");
	private By मराठी = By.xpath("//a[text()='मराठी']");
	private By English = By.xpath("//a[text()='English']");

	private By allProduct = By.xpath("//section[@id='all-products']");

	private By searchResultOfAmitabh = By.xpath("//h3[text()='Amitabh Bachchan - Wikipedia']");

	public boolean ElementIsExist() {
		eutil.doIsDisplayed(Search);
		eutil.doIsDisplayed(searchBar);
		return eutil.doIsDisplayed(Iamlucky);
	}

	public boolean HindiLangaugeSelect() {
		eutil.refresh();
		eutil.doClick(हिन्दी);
		return eutil.doIsDisplayed(Iamlucky);

	}

	public boolean MarathiLangaugeSelect() {
		eutil.refresh();
		eutil.doClick(मराठी);
		return eutil.doIsDisplayed(Iamlucky);
	}

	public boolean EnglishLangaugeSelect() {
		eutil.refresh();
		eutil.doClick(English);
		return eutil.doIsDisplayed(Iamlucky);
	}

	public boolean searchAmitabhBachchanandValidate() {
		eutil.refresh();
		eutil.doSendKeys(searchBar, Constants.SEACHINGSOMENAME);
		eutil.clickElementWhenReady(SearchMain, Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(searchResultOfAmitabh);
	}

	public boolean validationAllProductsIsExist() {
		driver.navigate().to("https://about.google/intl/en/products/");
		eutil.doActionMoveToElementClick(allProduct);
		return eutil.doIsDisplayed(allProduct);

	}

	public GoogleMapPage doClickOnGoogleMap() {
		eutil.waitForFrameByname("app", Constants.DEFAULT_TIME_OUT);
		eutil.doClick(maps);
		return new GoogleMapPage(driver);
	}

}
