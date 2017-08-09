package com.tests.utils;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tests.utils.PropertyReader;

public class DriverImplementation implements ExtWebDriver {

	private final Logger log = LoggerFactory.getLogger(DriverImplementation.class);
	private WebDriver driver;
	private final int MAX_RETRIES_COUNT;

	public DriverImplementation() {
		String count = PropertyReader.readProperty("driver_countdown");
		log.info("This is a new driver.");
		this.MAX_RETRIES_COUNT = Integer.parseInt(count);

	}

	public void setDriverImplementation(WebDriver driver) {
		this.driver = driver;

	}

	
	public void get(String arg0) {
		driver.get(arg0);

	}

	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getPageSource() {
		return driver.getPageSource();
	}

	
	public void close() {
		driver.close();

	}

	
	public void quit() {
		 driver.quit();

	}

	
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	
	public Navigation navigate() {
		return driver.navigate();
	}

	
	public Options manage() {
		return driver.manage();
	}

	
	public void setDriverImpl(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void setURLinMaxWindow(String URL) {		

	}

	
	public void destroyDriver() {
		driver = null;

	}

	
	public String switchToLastWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setURLinWindowWitResolution(String URL, int width, int height) {
		// TODO Auto-generated method stub

	}

	
	public void setURLandWindowLocation(String URL, int width_x, int height_y) {
		// TODO Auto-generated method stub

	}

}
