package com.juaracoding.labs.catalogs;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.labs.screens.InventoryScreen;
import com.juaracoding.labs.screens.LoginScreen;
import com.juaracoding.labs.services.DriverService;

import io.appium.java_client.android.AndroidDriver;

public class CatalogTest {
  
  @Test
  public void addToCartTest() throws MalformedURLException {
    AndroidDriver driver = DriverService.buildDriver();

    LoginScreen loginScreen = new LoginScreen(driver);
    loginScreen.login();

    InventoryScreen inventoryScreen = new InventoryScreen(driver);
    int productIndex = 0;
    Assert.assertEquals(inventoryScreen.getProductNameBy(productIndex), "Sauce Labs Backpack");

    inventoryScreen.addToCartBy(productIndex);
    Assert.assertEquals(inventoryScreen.getButtonRemoveCartBy(productIndex), "REMOVE");
    Assert.assertEquals(inventoryScreen.getTotalCart(), "1");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.quit();
  }
}
