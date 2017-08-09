package com.tests.utils;

import org.openqa.selenium.WebDriver;

public interface ExtWebDriver extends WebDriver {

	public void setDriverImpl(WebDriver driver);
	
	public void setURLinMaxWindow(String URL);

	public void destroyDriver();

	public String switchToLastWindow();

	public void setURLinWindowWitResolution(String URL, int width, int height);

	public void setURLandWindowLocation(String URL, int width_x, int height_y);

}
