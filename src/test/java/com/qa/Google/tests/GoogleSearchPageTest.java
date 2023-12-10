package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchPageTest extends BaseTest {

	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openSearchPage() {
		googleSearchPage = googleAccountPage.doClickOnGoogleSearch();
	}

	@Test(priority = 2)
	public void verifyButtonsIsExist() {
		Assert.assertTrue(googleSearchPage.ElementIsExist());
	}

	@Test(priority = 3)
	public void SelectMarathiLangauge() {
		Assert.assertTrue(googleSearchPage.MarathiLangaugeSelect());
	}

	@Test(priority = 4)
	public void SelectHindiLangauge() {
		Assert.assertTrue(googleSearchPage.HindiLangaugeSelect());
	}

	@Test(priority = 5)
	public void SelectEnglishLangauge() {
		Assert.assertTrue(googleSearchPage.EnglishLangaugeSelect());
	}

	@Test(priority = 6)
	public void Search_Amitabh_Bachchan() {
		Assert.assertTrue(googleSearchPage.searchAmitabhBachchanandValidate());
	}

	@Test(priority = 7)
	public void ProductsAllExist() {
		Assert.assertTrue(googleSearchPage.validationAllProductsIsExist());
	}

}
