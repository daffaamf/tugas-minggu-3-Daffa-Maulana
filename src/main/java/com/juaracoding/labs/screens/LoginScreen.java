package com.juaracoding.labs.screens;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen {
  private AndroidDriver driver;
  private By username = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
  private By password = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
  private By button = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
  private By errorMessage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");
  private WebDriverWait wait;

  public LoginScreen(AndroidDriver driver) {
    this.driver = driver;
    this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    wait = new WebDriverWait(driver, Duration.ofSeconds(25));
  }

  public String fillUsername(String username) {
    WebElement element = wait.until(
      ExpectedConditions.presenceOfElementLocated(this.username)
    );
    element.sendKeys(username);
    return element.getText();
  }

  public boolean usernameIsVisible() {
    WebElement element = wait.until(
      ExpectedConditions.presenceOfElementLocated(this.username)
    );
    return element.isDisplayed();
  }

  public String fillPassword(String password) {
     WebElement element = wait.until(
      ExpectedConditions.presenceOfElementLocated(this.password)
    );
    element.sendKeys(password);
    return element.getText();
  }

   public boolean passwordIsVisible() {
   WebElement element = wait.until(
      ExpectedConditions.presenceOfElementLocated(password)
    );
    return element.isDisplayed();
  }

  public void click() {
    wait.until(
      ExpectedConditions.presenceOfElementLocated(button)
    ).click();
  }

  public String getMessage() {
    return driver.findElement(errorMessage).getText();
  }

  public Map<String, String> login(String username, String password) {
    String valueUsername = fillUsername(username);
    String valuePassword = fillPassword(password);
    click();
    Map<String, String> map = new HashMap<>();
    map.put("username", valueUsername);
    map.put("password", valuePassword);

    return map;
  }

  public void login() {
    login("standard_user", "secret_sauce");
  }
}
