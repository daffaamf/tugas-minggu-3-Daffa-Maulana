package com.juaracoding.labs.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverService {
  private AndroidDriver driver;
  private UiAutomator2Options options;

  public void setDriver() throws MalformedURLException {
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723") , options);
  }

  public void setOptions() {
    options = new UiAutomator2Options();
    // options.setCapability("appium:deviceName", "emulator-5554");
    options.setCapability("platformName", "Android");
    options.setCapability("appium:automationName", "UiAutomator2");
    options.setCapability("appium:appPackage", "com.swaglabsmobileapp");
    options.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
  }

  public AndroidDriver getDriver() {
    return driver;
  }

  public static AndroidDriver buildDriver() throws MalformedURLException {
    DriverService driverService = new DriverService();
    driverService.setOptions();
    driverService.setDriver();
    AndroidDriver driver = driverService.getDriver();
    driver.hideKeyboard();
    return driver;
  }
}
