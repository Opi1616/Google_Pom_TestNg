package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;

public class GoogleProductPageTest extends BaseTest {

	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void allAppExist() {
		Assert.assertTrue(googleProductPage.accountsIsExist());
	}

	@Test(priority = 2)
	public void openAccountPage() throws InterruptedException {
		String actTitle = googleProductPage.openAccountPage();
		System.out.println("acc page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TTILE);
	}

	@Test(priority = 3)
	public void openSearchPage() throws InterruptedException {
		String actTitle = googleProductPage.openSearchPage();
		System.out.println("search page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.SEARCH_PAGE_TTILE);
	}

	@Test(priority = 4)
	public void openMapPage() throws InterruptedException {
		String actTitle = googleProductPage.openMapsPage();
		System.out.println("map page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.MAP_PAGE_TITLE);
	}

	@Test(priority = 5)
	public void openYouTubePage() throws InterruptedException {
		String actTitle = googleProductPage.openYoutubePage();
		System.out.println("Youtube page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.YOUTUBE_PAGE_TITLE);
	}

	@Test(priority = 6)
	public void openPlayStorePage() throws InterruptedException {
		String actTitle = googleProductPage.openPlayStorePage();
		System.out.println("PlayStore page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.PLAYSTORE_PAGE_TITLE);
	}

	@Test(priority = 7)
	public void openNewsPage() throws InterruptedException {
		String actTitle = googleProductPage.openNewsPage();
		System.out.println("News page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.NEWS_PAGE_TITLE);
	}

	@Test(priority = 8)
	public void openGmailPage() throws InterruptedException {
		String actTitle = googleProductPage.openGmailPage();
		System.out.println("Gmail page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.GMAIL_PAGE_TITLE);
	}

	@Test(priority = 9)
	public void openMeetPage() throws InterruptedException {
		String actTitle = googleProductPage.openMeetPage();
		System.out.println("Meet page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.MEET_PAGE_TITLE);
	}

}
