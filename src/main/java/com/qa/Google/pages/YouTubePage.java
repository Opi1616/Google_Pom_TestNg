package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class YouTubePage {
	private WebDriver driver;
	private ElementUtil eutil;

	public YouTubePage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By Email = By.cssSelector("#identifierId");
	private By Next = By.cssSelector("#identifierNext");
	private By Pass = By.xpath("//input[@type='password']");
	private By passNext = By.xpath("(//button[@jsname='LgbsSe'])[2]");
	private By youTubeLogoLocate = By.xpath("(//a[@title='YouTube Home'])[1]");
	private By signIn = By.xpath("(//a[@aria-label='Sign in'])[1]");
	private By accountverify = By.xpath("//button[@id='avatar-btn']");
	private By GoogleId = By.xpath("(//div[@id='header'])[5]");
	private By playStore = By.xpath("(//a[@class='tX9u1b'])[5]");

//	private By youtube = By.xpath("(//a[@class='tX9u1b'])[4]");
	public String getYouTubePageTitle() {
		return eutil.doGetTitle(Constants.YOUTUBE_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean loginYouTubePage(String un, String pwd) {
		eutil.doIsDisplayed(youTubeLogoLocate);
		eutil.clickElementWhenReady(signIn, Constants.DEFAULT_TIME_OUT);
		eutil.doSendKeys(Email, un);
		eutil.doClick(Next);
		eutil.waitForElementToBeVisibleAndDoSendKeys(Pass, Constants.DEFAULT_TIME_OUT, 2, pwd);
		eutil.doClick(passNext);
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(GoogleId);
	}

	public PlayStorePage doClickOnPlayStore() {
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(playStore);
		return new PlayStorePage(driver);
	}

}
