package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;
import com.qa.Google.utils.Log;

public class GoogleWebPageTest extends BaseTest {

	@Test(priority = 1)
	public void launchGooglePage() {
		Log.startTestCase("Launch Google Page");
		String actTitle = googleWebPage.getGoogleWebPageTitle();
		System.out.println("page title is :" + actTitle);
		Assert.assertEquals(actTitle, Constants.GOOGLE_PAGE_TITLE);
		Log.info("Google Page Launch sucessfully");
	}

	@Test(priority = 2)
	public void WebPageUrlTest() {

		Assert.assertTrue(googleWebPage.getGoogleWebPageUrl());
	}

	@Test(priority = 3)
	public void verifyTitlebarBtn() {
		Assert.assertTrue(googleWebPage.searchBarExist());
	}

	@Test(priority = 4)
	public void verifyBtn() {
		Assert.assertTrue(googleWebPage.searchBtnExist());
		Assert.assertTrue(googleWebPage.imfeelingExist());

	}

}
