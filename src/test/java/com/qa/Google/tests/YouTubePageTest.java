package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;

public class YouTubePageTest extends BaseTest {

	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openMapPage() {
		youTubePage = googleMapPage.doClickOnYouTube();
	}

	@Test(priority = 2)
	public void youTubePagettitleTest() {
		String actTitle = youTubePage.getYouTubePageTitle();
		System.out.println("page titile: " + actTitle);
		Assert.assertEquals(actTitle, Constants.YOUTUBE_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void doLoginYouTubePage() {
		Assert.assertTrue(youTubePage.loginYouTubePage(prop.getProperty("username"), prop.getProperty("password")));
	}

}
