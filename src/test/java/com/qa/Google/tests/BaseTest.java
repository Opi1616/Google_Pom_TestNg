package com.qa.Google.tests;

import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.qa.Google.factory.DriverFactory;
import com.qa.Google.pages.GmailPage;
import com.qa.Google.pages.GoogleAccountPage;
import com.qa.Google.pages.GoogleMapPage;
import com.qa.Google.pages.GoogleProductPage;
import com.qa.Google.pages.GoogleSearchPage;
import com.qa.Google.pages.GoogleWebPage;
import com.qa.Google.pages.NewsPage;
import com.qa.Google.pages.PlayStorePage;
import com.qa.Google.pages.YouTubePage;

public class BaseTest {

	DriverFactory df;
	Properties prop;
	WebDriver driver;
	GoogleWebPage googleWebPage;
	GoogleProductPage googleProductPage;
	GoogleAccountPage googleAccountPage;
	GoogleSearchPage googleSearchPage;
	GoogleMapPage googleMapPage;
	YouTubePage youTubePage;
	PlayStorePage playStorePage;
	NewsPage newsPage;
	GmailPage gmailPage;

	@BeforeSuite

	public void beforeSuite() {

		DOMConfigurator.configure("log4j.xml");
	}

	@BeforeClass
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		googleWebPage = new GoogleWebPage(driver);
		googleAccountPage = new GoogleAccountPage(driver);
		googleSearchPage = new GoogleSearchPage(driver);
		googleMapPage = new GoogleMapPage(driver);
		youTubePage = new YouTubePage(driver);
		playStorePage = new PlayStorePage(driver);
		newsPage = new NewsPage(driver);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
