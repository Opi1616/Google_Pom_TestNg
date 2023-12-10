package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Google.utils.ElementUtil;

public class GoogleProductPage {
	private WebDriver driver;
	private ElementUtil eutil;

	public GoogleProductPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	private By searchBar = By.xpath("//input[@title='Search']");
	private By accounts = By.xpath("(//a[@class='tX9u1b'])[1]");
	private By search = By.xpath("(//a[@class='tX9u1b'])[2]");
	private By maps = By.xpath("(//a[@class='tX9u1b'])[3]");
	private By youtube = By.xpath("(//a[@class='tX9u1b'])[4]");
	private By playStore = By.xpath("(//a[@class='tX9u1b'])[5]");
	private By news = By.xpath("(//a[@class='tX9u1b'])[6]");
	private By gmail = By.xpath("(//a[@class='tX9u1b'])[7]");
	private By meet = By.xpath("(//a[@class='tX9u1b'])[8]");
	private By chat = By.xpath("(//a[@class='tX9u1b'])[9]");
	private By contacts = By.xpath("(//a[@class='tX9u1b'])[10]");
	private By drive = By.xpath("(//a[@class='tX9u1b'])[11]");
	private By calander = By.xpath("(//a[@class='tX9u1b'])[12]");
	private By translate = By.xpath("(//a[@class='tX9u1b'])[13]");
	private By photos = By.xpath("(//a[@class='tX9u1b'])[14]");
	private By duo = By.xpath("(//a[@class='tX9u1b'])[15]");
	private By shopping = By.xpath("(//a[@class='tX9u1b'])[16]");
	private By googleApps = By.xpath("//a[@aria-label='Google apps']");

	private By Account = By.xpath("//div[@class='h-c-header__lockup']");
	private By map = By.id("searchbox");
	private By youtubeLogo = By.xpath("(//yt-icon[@id='logo-icon'])[1]");
	private By PlayStore = By.xpath("//span[text()='google_logo Play']");
	private By News = By.id("sdgBod");
	private By Gmail = By.xpath("//span[@class='mobile-before-hero-only']");
	private By Meet = By.xpath("(//img[@alt='Google Meet logo'])[1]");

	public boolean accountsIsExist() {
		eutil.waitForFrameByname("app", 10);
		eutil.doIsDisplayed(accounts);
		eutil.doIsDisplayed(search);
		eutil.doIsDisplayed(maps);
		eutil.doIsDisplayed(youtube);
		eutil.doIsDisplayed(playStore);
		eutil.doIsDisplayed(news);
		eutil.doIsDisplayed(gmail);
		eutil.doIsDisplayed(meet);
		eutil.doIsDisplayed(chat);
		eutil.doIsDisplayed(translate);
		eutil.doIsDisplayed(drive);
		eutil.doIsDisplayed(calander);
		eutil.doIsDisplayed(photos);
		eutil.doIsDisplayed(contacts);
		eutil.doIsDisplayed(duo);
		eutil.doIsDisplayed(shopping);
		eutil.refresh();
		return true;
	}

	public String openAccountPage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(accounts);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(Account);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public String openSearchPage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(search);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(searchBar);
		Thread.sleep(2000);
		return title;
	}

	public String openMapsPage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(maps);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(map);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public String openYoutubePage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(youtube);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(youtubeLogo);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public String openPlayStorePage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(playStore);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(PlayStore);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public String openNewsPage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(news);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(News);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public String openGmailPage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(gmail);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(Gmail);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public String openMeetPage() throws InterruptedException {
		eutil.doClick(googleApps);
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(meet);
		String title = eutil.doGetTitle();
		eutil.doIsDisplayed(Meet);
		Thread.sleep(2000);
		eutil.doNavaigateBack();
		eutil.refresh();
		return title;
	}

	public GoogleAccountPage doClickOnGoogleAccount() {
		eutil.waitForFrameByname("app", 10);
		eutil.doClick(accounts);
		return new GoogleAccountPage(driver);
	}

}
