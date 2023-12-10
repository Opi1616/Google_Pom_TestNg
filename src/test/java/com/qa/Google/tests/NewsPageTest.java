package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;

public class NewsPageTest extends BaseTest {
	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openPlayStorePage() {
		newsPage = playStorePage.doClickNewsPage();
	}

	@Test(priority = 2)
	public void PlayStorePagettitleTest() {
		String actTitle = newsPage.getNewsPageTitle();
		System.out.println("page titile: " + actTitle);
		Assert.assertEquals(actTitle, Constants.NEWS_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void doLoginPlayStorePage() {
		Assert.assertTrue(newsPage.loginNewsPage(prop.getProperty("username"), prop.getProperty("password")));
	}
}
