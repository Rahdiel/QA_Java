package com.tests.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriver {

	private final Logger log = LoggerFactory.getLogger(WebDriver.class);
	public static ExtWebDriver driver = null;

	public WebDriver() {
		initialize();
	}

	public void initialize() {
		if (driver == null)
			createNewDriverInstance();
	}

	public void destroyDriver() {
		driver.quit();
		driver.destroyDriver();
		driver = null;

	}

	private void createNewDriverInstance() {
		String browser = PropertyReader.readProperty("browser");
		driver = new DriverImplementation();
		String firefox_driver = PropertyReader.readProperty("firefox_driver");

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefox_driver);

			driver.setDriverImpl(new FirefoxDriver());
			log.info("Firefox browser was open");

		} else if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver.setDriverImpl(new ChromeDriver(capabilities));
			log.info("Chrome browser was open");

		} else {
			log.info("Can't read browser type. Will run with default browser");
			ChromeDriverManager.getInstance().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver.setDriverImpl(new ChromeDriver(chromeOptions));
			log.info("Chrome browser was open");
		}

	}

}
