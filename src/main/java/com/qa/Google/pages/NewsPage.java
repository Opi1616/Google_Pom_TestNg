package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class NewsPage {

	private WebDriver driver;
	private ElementUtil eutil;

	public NewsPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By Email = By.cssSelector("#identifierId");
	private By Next = By.cssSelector("#identifierNext");
	private By Pass = By.xpath("//input[@type='password']");
	private By passNext = By.xpath("(//button[@jsname='LgbsSe'])[2]");
	private By accountverify = By.cssSelector("img.gb_Ia");
	private By GoogleId = By.cssSelector("div.q6rarf");
	private By playStoreLogo = By.cssSelector("#sdgBod");
	private By SignInBtn = By.xpath("//a[text()='Sign in']");
	private By gmail = By.xpath("(//a[@class='tX9u1b'])[7]");

	public String getNewsPageTitle() {
		return eutil.doGetTitle(Constants.NEWS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean loginNewsPage(String un, String pwd) {
		eutil.doIsDisplayed(playStoreLogo);
		eutil.clickElementWhenReady(SignInBtn, Constants.DEFAULT_TIME_OUT);
		eutil.doSendKeys(Email, un);
		eutil.doClick(Next);
		eutil.waitForElementToBeVisibleAndDoSendKeys(Pass, Constants.DEFAULT_TIME_OUT, 2, pwd);
		eutil.doClick(passNext);
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		eutil.waitForFrameByname("account", Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(GoogleId);
	}

	public GmailPage doClickOnGmailPage() {
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(gmail);
		return new GmailPage(driver);
	}

}
