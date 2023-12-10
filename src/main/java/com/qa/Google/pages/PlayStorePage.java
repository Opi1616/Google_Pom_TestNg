package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;

public class PlayStorePage {
	private WebDriver driver;
	private ElementUtil eutil;

	public PlayStorePage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By Email = By.cssSelector("#identifierId");
	private By Next = By.cssSelector("#identifierNext");
	private By Pass = By.xpath("//input[@type='password']");
	private By passNext = By.xpath("(//button[@jsname='LgbsSe'])[2]");
	private By AccountButton = By.cssSelector("img.VfPpkd-kBDsod");
	private By accountverify = By.cssSelector("img.VfPpkd-kBDsod");
	private By GoogleId = By.cssSelector("div.YQy4vd");
	private By playStoreLogo = By.cssSelector("a.f0UV3d");
	private By SignInBtn = By.xpath("//span[@jsname='K4r5Ff' and text()='Sign in with Google']");
	private By news = By.xpath("(//a[@class='tX9u1b'])[6]");

	public String getPlayStorePageTitle() {
		return eutil.doGetTitle(Constants.PLAYSTORE_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean loginPlayStorePage(String un, String pwd) {
		eutil.doIsDisplayed(playStoreLogo);
		eutil.doClick(AccountButton);
		eutil.doClick(SignInBtn);
		eutil.doSendKeys(Email, un);
		eutil.doClick(Next);
		eutil.waitForElementToBeVisibleAndDoSendKeys(Pass, Constants.DEFAULT_TIME_OUT, 2, pwd);
		eutil.doClick(passNext);
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(GoogleId);
	}

	public NewsPage doClickNewsPage() {
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(news);
		return new NewsPage(driver);
	}

}
