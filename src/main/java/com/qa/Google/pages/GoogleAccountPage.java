package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class GoogleAccountPage {
	private WebDriver driver;
	private ElementUtil eutil;

	public GoogleAccountPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By search = By.xpath("(//a[@class='tX9u1b'])[2]");
	private By Account = By.xpath("//div[@class='h-c-header__lockup']");
	private By GoToAccount = By.xpath("(//a[text()='Go to Google Account'])[2]");
	private By Email = By.cssSelector("#identifierId");
	private By Next = By.cssSelector("#identifierNext");
	private By Pass = By.xpath("//input[@type='password']");
	private By passNext = By.xpath("(//button[@jsname='LgbsSe'])[2]");
	private By accountverify = By.xpath("(//a[@role='button'])[2]");
	private By GoogleId = By.cssSelector("div.q6rarf");

	public boolean accountIsExist() {
		return eutil.doIsDisplayed(Account);
	}

	public String getAccountPageTitle() {
		return eutil.doGetTitle(Constants.ACCOUNTS_PAGE_TTILE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean loginGoogleAccount(String un, String pwd) {

		eutil.doClick(GoToAccount);
		eutil.doSendKeys(Email, un);
		eutil.doClick(Next);
		eutil.waitForElementToBeVisibleAndDoSendKeys(Pass, Constants.DEFAULT_TIME_OUT, 2, pwd);
		eutil.doClick(passNext);
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		eutil.waitForFrameByname("account", Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(GoogleId);

	}

	public GoogleSearchPage doClickOnGoogleSearch() {
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(search);
		return new GoogleSearchPage(driver);
	}
}
