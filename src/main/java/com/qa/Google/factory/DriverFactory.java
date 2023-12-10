package com.qa.Google.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;
	public Properties prop;
	public static String highlight;
	public OptionsManager optionsmanager;
//	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * This method will used to initialize the webdriver
	 * 
	 * @param browserName
	 * @return
	 */

	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");

		System.out.println("broswer name is : " + browserName);

		highlight = prop.getProperty("highlight");
		optionsmanager = new OptionsManager(prop);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsmanager.getChromeOptions());
			// tldriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());
			// tldriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
		} else if (browserName.equals("microsoft edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(optionsmanager.getEdgeOptions());
			// tldriver.set(new EdgeDriver(optionsmanager.getEdgeOptions()));
		} else {
			System.out.println("please pass the right browser : " + browserName);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		return driver;
	}

	/**
	 * getdriver(): it will return a thread local local copy of the webdriver
	 * 
	 * @return
	 */
//	public static synchronized WebDriver getDriver() {
//		return driver.get();
//	}

	/**
	 * this method is used to initialize the properties
	 * 
	 * @return this will return properties prop reference
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * take screenshot
	 * 
	 * @return
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
