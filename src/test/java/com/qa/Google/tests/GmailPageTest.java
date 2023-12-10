package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;

public class GmailPageTest extends BaseTest {

	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openGmailPage() {
		gmailPage = newsPage.doClickOnGmailPage();
	}

	@Test(priority = 2)
	public void GmailPagettitleTest() {
		String actTitle = gmailPage.getGmailPageTitle();
		System.out.println("page titile: " + actTitle);
		Assert.assertEquals(actTitle, Constants.GMAIL_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void doLoginGmailPage() {
		Assert.assertTrue(gmailPage.loginGmailPage(prop.getProperty("username"), prop.getProperty("password")));
	}

	@Test(priority = 4)
	public void VerifyTotalNumbersOfEmailRecived() {
		Assert.assertTrue(gmailPage.getTotalEmailNoRecived());
	}

	@Test(priority = 5)
	public void VerifyTotalNumbersOfEmailIsStar() {
		Assert.assertEquals(gmailPage.TotalStarMail(), Constants.ACTUAL_STAR_EMAIL);
	}

	@Test(priority = 6)
	public void VerifyTotalReadEmails() {
		Assert.assertEquals(gmailPage.TotalReadEmails(), Constants.ACTUAL_READ_EMAIL);
	}

	@Test(priority = 7)

	public void VerifyTotalUnReadEmails() {
		Assert.assertEquals(gmailPage.TotalUnReadEmails(), Constants.ACTUAL_UNREAD_EMAIL);
	}

	@Test(priority = 8)
	public void VerifyAndSendComoposeEmail() {
		gmailPage.GetValidatedComposeEmail();
	}

//	@Test(priority = 9)
//	public void SendMail() throws InterruptedException {
//		gmailPage.sendMail();
//	}

	@Test(priority = 9)
	public void verifySendMail() throws InterruptedException {
		Assert.assertTrue(gmailPage.verify_Mail_Is_Send(), "mail is sended and verified");
	}

	@Test(priority = 10)
	public void searchMail() throws InterruptedException {
		Assert.assertTrue(gmailPage.searchMail(), "mail is searched with particular name ");

	}

	@Test(priority = 11)
	public void OpenSettingWIndow() throws InterruptedException {
		gmailPage.selectSetting();
	}

	@Test(priority = 12)
	public void createLable() throws InterruptedException {

		Assert.assertTrue(gmailPage.createLable(), "lable created successfully");
	}

	@Test(priority = 13)
	public void MailMoveToImpLabel() throws InterruptedException {

		Assert.assertTrue(gmailPage.movetTomailInImpLabel(), "Mail moved ib to the imp label successfully");
	}

	@Test(priority = 14)
	public void signOut() throws InterruptedException {
		gmailPage.SignOut();

	}

}
