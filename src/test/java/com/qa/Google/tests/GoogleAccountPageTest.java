package com.qa.Google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.Google.utils.Constants;

public class GoogleAccountPageTest extends BaseTest {

	@Test(priority = 0)
	public void GoogleProductPageSetup() {
		googleProductPage = googleWebPage.doClickOnGoogleApp();
	}

	@Test(priority = 1)
	public void openGoogleAccount() {
		googleAccountPage = googleProductPage.doClickOnGoogleAccount();
	}

	@Test(priority = 2)
	public void GoogleAccountLogoExist() {
		Assert.assertTrue(googleAccountPage.accountIsExist());
	}

	@Test(priority = 3)
	public void loginPageTitleTest() {
		String actTitle = googleAccountPage.getAccountPageTitle();
		System.out.println("page titile: " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TTILE);
	}

	@Test(priority = 4)
	public void doLoginGoogleAccount() {
		Assert.assertTrue(
				googleAccountPage.loginGoogleAccount(prop.getProperty("username"), prop.getProperty("password")));
	}

}
