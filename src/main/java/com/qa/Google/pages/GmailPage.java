package com.qa.Google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.qa.Google.utils.Constants;
import com.qa.Google.utils.ElementUtil;
import com.qa.Google.utils.JavaScriptUtil;

public class GmailPage {

	private WebDriver driver;
	private ElementUtil eutil;
	private JavaScriptUtil jsutil;

	public GmailPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
		jsutil = new JavaScriptUtil(driver);
	}

	private By gmailLogo = By.xpath("//div[@class='header__container']/a");
	private By signup = By.xpath("//a[text()='Sign in']");
	private By Email = By.cssSelector("#identifierId");
	private By Next = By.cssSelector("#identifierNext");
	private By Pass = By.xpath("//input[@type='password']");
	private By passNext = By.xpath("(//button[@jsname='LgbsSe'])[2]");
	private By accountverify = By.cssSelector("img.gb_Ia");
	private By GoogleId = By.cssSelector("div.q6rarf");
	private By TotalMail = By.xpath("(//span[@class='ts'])[3]");
	private By GmailElement = By.cssSelector("div.at9");
	private By StarMail = By.xpath("//span[@aria-label=\"Starred\"]");

	private By unreadMail = By.xpath("//tr[@class='zA zE']");
	private By readmail = By.xpath("//tr[@class='zA yO']");

	private By ComoposeMail = By.xpath("//div[text()='Compose']");
	private By composeMaileWIndow = By.xpath("//div[@class='AD']");
	private By ComposeValidate = By.xpath("//div[@class='nH Hd']");

	private By toMailId = By.xpath("//input[@class='agP aFw']");
	private By ClickOncc = By.xpath("//span[@class='aB gQ pE']");
	private By CCMail = By.xpath("(//input[@class='agP aFw'])[2]");
	private By SubLine = By.xpath("//input[@class='aoT']");
	private By ActualMsg = By.xpath("//div[@class='Am Al editable LW-avf tS-tW']");
	private By mailSend = By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']");

	private By Sent = By.xpath("//a[text()='Sent']");
	private By SentMail = By.xpath("//div[@class='aeF']");
	private By inbox = By.xpath("//a[text()='Inbox']");

	private By searchMail = By.xpath("//input[@placeholder='Search mail']");
	private By ValidateSearchMail = By.xpath("//div[@class='ae4 UI UJ nH oy8Mbf id']");

	private By yogi = By.xpath("//div[@class='gstq_d gstq_a gsfs']");
	private By setting = By.cssSelector("a.FH");
	private By settingOne = By.xpath("//div[text()='Quick settings']");
	private By SettingMaximize = By.xpath("//button[text()='See all settings']");
	private By SettingWindow = By.xpath("//h2[text()='Settings']");

	private By createLabel = By.xpath("//div[@aria-label='Create new label']");
	private By LabelName = By.xpath("//input[@class='xx']");
	private By LabelOk = By.xpath("//button[@name='ok']");
	private By ImpFolder = By.xpath("//div[@class='aio aip']");

	private By LabelVerified = By.xpath("//div[@class='aeF']");

	private By ClickOnMail = By.xpath("(//div[@class='oZ-jc T-Jo J-J5-Ji '])[3]");
	private By ClickOnMove = By.xpath("(//div[@role='button'])[29]");
	private By FinalMove = By.xpath("//div[text()='IMP']");
	private By openImp = By.xpath("//div[@class='aio aip']");
	private By ValidateMailRecive = By.xpath("//div[@class='aeF']");

	private By SignOut = By.xpath("//div[text()='Sign out']");

	public void SignOut() {
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		eutil.waitForFrameByname("account", Constants.DEFAULT_TIME_OUT);
		eutil.clickElementWhenReady(SignOut, Constants.DEFAULT_TIME_OUT);
	}

	public boolean movetTomailInImpLabel() throws InterruptedException {
		eutil.clickElementWhenReady(inbox, 10);
		Thread.sleep(5000);
		eutil.clickElementWhenReady(ClickOnMail, 10);
		Thread.sleep(2000);
		eutil.clickElementWhenReady(ClickOnMove, 10);
		Thread.sleep(5000);
		eutil.clickElementWhenReady(FinalMove, 10);
		Thread.sleep(2000);
		eutil.refresh();
		Thread.sleep(5000);
		eutil.clickElementWhenReady(openImp, 10);
		Thread.sleep(5000);
		return eutil.doIsDisplayed(ValidateMailRecive);
	}

	public boolean createLable() throws InterruptedException {
		eutil.clickElementWhenReady(inbox, 10);
		Thread.sleep(2000);
		eutil.clickElementWhenReady(createLabel, 10);
		Thread.sleep(2000);
		eutil.doSendKeys(LabelName, "IMP", 10);
		Thread.sleep(2000);
		// eutil.doSendKeys(toMailId, "yogeshdhanokar20@gmail.com", 10);
		eutil.clickElementWhenReady(LabelOk, 10);
		Thread.sleep(2000);
		eutil.clickElementWhenReady(ImpFolder, 10);
		Thread.sleep(2000);
		return eutil.doIsDisplayed(LabelVerified);

	}

	public void selectSetting() throws InterruptedException {
		eutil.refresh();
		eutil.clickElementWhenReady(inbox, 10);
		Thread.sleep(2000);
		eutil.clickElementWhenReady(setting, 10);
		Thread.sleep(2000);
		eutil.waitForElementToBeVisible(settingOne, 10, 5);
		Thread.sleep(2000);
		eutil.clickElementWhenReady(SettingMaximize, 10);
		Thread.sleep(2000);
		eutil.doPresenceOfElementLocated(SettingWindow, 10);
		Thread.sleep(2000);

	}

	public boolean searchMail() throws InterruptedException {
		eutil.refresh();
		eutil.clickElementWhenReady(inbox, 10);
		// eutil.doClear(searchMail);
		Thread.sleep(5000);
		eutil.doSendKeys(searchMail, "dhanokary", 10);
		eutil.clickElementWhenReady(yogi, 10);
		// eutil.doSendKeysWithEnter(searchMail, Keys.ENTER);
		Thread.sleep(2000);
		return eutil.doIsDisplayed(ValidateSearchMail);
	}

//	public void sendMail() throws InterruptedException {
//		eutil.doSendKeys(toMailId, "yogeshdhanokar20@gmail.com", 10);
//		eutil.doActionMoveToElementClick(ClickOncc);
//		eutil.doSendKeys(CCMail, "dhanokaryogi@gmail.com", 10);
//		eutil.doSendKeys(SubLine, "TestMsg", 10);
//		eutil.doSendKeys(ActualMsg, "Hello i have send one msg", 10);
//		Thread.sleep(2000);
//		eutil.clickElementWhenReady(mailSend, 10);
//	}

	public boolean verify_Mail_Is_Send() throws InterruptedException {
		eutil.refresh();
		eutil.clickElementWhenReady(Sent, 10);
		Thread.sleep(2000);
		return eutil.doIsDisplayed(SentMail);
	}

	public String getGmailPageTitle() {
		return eutil.doGetTitle(Constants.GMAIL_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean loginGmailPage(String un, String pwd) {
		eutil.doIsDisplayed(gmailLogo);
		eutil.clickElementWhenReady(signup, Constants.DEFAULT_TIME_OUT);
		eutil.doSendKeys(Email, un);
		eutil.doClick(Next);
		eutil.waitForElementToBeVisibleAndDoSendKeys(Pass, Constants.DEFAULT_TIME_OUT, 2, pwd);
		eutil.doClick(passNext);
		eutil.clickElementWhenReady(accountverify, Constants.DEFAULT_TIME_OUT);
		eutil.waitForFrameByname("account", Constants.DEFAULT_TIME_OUT);
		return eutil.doIsDisplayed(GoogleId);
	}

	public boolean getTotalEmailNoRecived() {
		eutil.refresh();
		eutil.goToDefaultContaint();
		eutil.waitForElementToBeVisible(GmailElement, Constants.DEFAULT_TIME_OUT, Constants.TIME_OUT);
		eutil.doIsDisplayed(TotalMail);
		int totalreciveEmail = Integer.parseInt(eutil.doGetText(TotalMail));
		int actualReceiveMail = Constants.ACTUAL_RECIVE_EMAILS;
		System.out.println("Total recive email: " + totalreciveEmail);
		System.out.println("Actual recive email: " + actualReceiveMail);
		if (totalreciveEmail == actualReceiveMail) {
			return true;
		} else {
			return false;
		}

	}

	public int TotalStarMail() {
		eutil.refresh();
		return eutil.TotalstarMails(StarMail, Constants.DEFAULT_TIME_OUT);

	}

	public int TotalReadEmails() {
		eutil.refresh();
		return eutil.TotalReadEmails(readmail, Constants.DEFAULT_TIME_OUT);

	}

	public int TotalUnReadEmails() {
		eutil.refresh();
		return eutil.TotalUnReadEmails(unreadMail, Constants.DEFAULT_TIME_OUT);

	}

	public void GetValidatedComposeEmail() {
		eutil.refresh();
		eutil.clickElementWhenReady(ComoposeMail, Constants.DEFAULT_TIME_OUT);
		// eutil.waitForFrameByname("app", 10);
		// eutil.switchToChild();
		// eutil.doMoveToElement(ComposeValidate);
	}

}
