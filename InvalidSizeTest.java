package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class InvalidSizeTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
   // driver = new FirefoxDriver();
	  driver = SeleniumTestUtilities.getHtmlUnitDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testInvalidSize () throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("size")).clear();
    driver.findElement(By.id("size")).sendKeys("0");
    driver.findElement(By.id("range")).clear();
    driver.findElement(By.id("range")).sendKeys("11");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Lottery Error", driver.getTitle());
    assertTrue(driver.findElement(By.cssSelector("h3.center"))
            .getText()
            .matches("^The value supplied for the Number to pick is invalid!$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
