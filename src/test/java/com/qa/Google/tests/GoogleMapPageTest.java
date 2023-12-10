package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Google.utils.Constants;

public class GoogleMapPageTest extends BaseTest {

	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openMapPage() {
		googleMapPage = googleSearchPage.doClickOnGoogleMap();
	}

	@Test(priority = 2)
	public void MapPagettitleTest() {
		String actTitle = googleMapPage.getGoogleMapPageTitle();
		System.out.println("page titile: " + actTitle);
		Assert.assertEquals(actTitle, Constants.MAP_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void doLoginMapPage() {
		Assert.assertTrue(googleMapPage.loginGoogleMap(prop.getProperty("username"), prop.getProperty("password")));
	}

}
