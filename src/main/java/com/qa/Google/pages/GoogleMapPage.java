package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class GoogleMapPage {

	private WebDriver driver;
	private ElementUtil eutil;

	public GoogleMapPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By Email = By.cssSelector("#identifierId");
	private By Next = By.cssSelector("#identifierNext");
	private By Pass = By.xpath("//input[@type='password']");
	private By passNext = By.xpath("(//button[@jsname='LgbsSe'])[2]");
	private By mapLocate = By.id("omnibox");
	private By signIn = By.xpath("//a[text()='Sign in']");
	private By accountverify = By.xpath("(//a[@role='button'])[2]");
	private By GoogleId = By.cssSelector("div.q6rarf");
	private By youtube = By.xpath("(//a[@class='tX9u1b'])[4]");

	public String getGoogleMapPageTitle() {
		return eutil.doGetTitle(Constants.MAP_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean loginGoogleMap(String un, String pwd) {
		eutil.doIsDisplayed(mapLocate);
		eutil.clickElementWhenReady(signIn, Constants.DEFAULT_TIME_OUT);
		eutil.doSendKeys(Email, un);
		eutil.doClick(Next);
		eutil.waitForElementToBeVisibleAndDoSendKeys(Pass, Constants.DEFAULT_TIME_OUT, 2, pwd);
		eutil.doClick(passNext);
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		eutil.waitForFrameByname("account", Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(GoogleId);
	}

	public YouTubePage doClickOnYouTube() {
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(youtube);
		return new YouTubePage(driver);
	}

}
