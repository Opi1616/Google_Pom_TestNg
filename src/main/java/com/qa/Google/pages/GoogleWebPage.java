package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class GoogleWebPage {
//1.declare private driver
	private WebDriver driver;
	private ElementUtil eutil;

//2.page constructor
	public GoogleWebPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);

	}

//3.By locators
	private By searchBar = By.xpath("//input[@title='Search']");
	private By Searchbtn = By.xpath("(//input[@value='Google Search'])[2]");
	private By imFeelingbtn = By.xpath("(//input[@name='btnI'])[2]");
	private By googleApps = By.xpath("//a[@aria-label='Google apps']");

	public String getGoogleWebPageTitle() {
		return eutil.doGetTitle(Constants.GOOGLE_PAGE_TITLE, Constants.TIME_OUT);
	}

	public boolean getGoogleWebPageUrl() {
		return eutil.waitForTitleContains(Constants.GOOGLE_PAGE_URL, Constants.TIME_OUT);
	}

	public boolean searchBarExist() {
		return eutil.doIsDisplayed(searchBar);
	}

	public boolean searchBtnExist() {
		return eutil.doIsDisplayed(Searchbtn);
	}

	public boolean imfeelingExist() {
		return eutil.doIsDisplayed(imFeelingbtn);
	}

	public GoogleProductPage doClickOnGoogleApp() {
		eutil.doClick(googleApps);
		return new GoogleProductPage(driver);
	}

}
