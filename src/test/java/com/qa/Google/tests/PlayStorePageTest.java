package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;

public class PlayStorePageTest extends BaseTest {
	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openPlayStorePage() {
		playStorePage = youTubePage.doClickOnPlayStore();
	}

	@Test(priority = 2)
	public void PlayStorePagettitleTest() {
		String actTitle = playStorePage.getPlayStorePageTitle();
		System.out.println("page titile: " + actTitle);
		Assert.assertEquals(actTitle, Constants.PLAYSTORE_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void doLoginPlayStorePage() {
		Assert.assertTrue(playStorePage.loginPlayStorePage(prop.getProperty("username"), prop.getProperty("password")));
	}

}
