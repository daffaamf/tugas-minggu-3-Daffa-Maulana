package com.juaracoding.labs.authentications;

import java.net.MalformedURLException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.labs.screens.InventoryScreen;
import com.juaracoding.labs.screens.LoginScreen;
import com.juaracoding.labs.services.DriverService;
import io.appium.java_client.android.AndroidDriver;


public class LoginTest {
  
  /**
   * Verifikasi login berhasil dengan kredensial yang valid.
   * 
   * @throws MalformedURLException 
   */
  @Test
  public void loginPositiveTest() throws MalformedURLException {
    AndroidDriver driver = DriverService.buildDriver();

    LoginScreen loginScreen = new LoginScreen(driver);
    Assert.assertTrue(loginScreen.usernameIsVisible());
    Assert.assertTrue(loginScreen.passwordIsVisible());
    
    Map<String, String> map = loginScreen.login("standard_user", "secret_sauce");
    Assert.assertEquals(map.get("username"), "standard_user");
    
    InventoryScreen inventoryScreen = new InventoryScreen(driver);
    Assert.assertEquals(inventoryScreen.getHeaderText(), "PRODUCTS");
    
    driver.quit();
  }
}