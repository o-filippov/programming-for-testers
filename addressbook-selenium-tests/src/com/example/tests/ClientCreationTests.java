package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ClientCreationTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNonEmptyClientCreation() throws Exception {
    openMainPage();
    initClientCreation();
    fillClientForm("first name 1", "last name 1", "address 1", "1111111", "2222222", "3333333", "test@test.com", "test2@test.com", "1", "January", "1980", "Rob", "address 2", "4444444");
    submitClientCreation();
    returnToMainPage();
  }
  
  @Test
  public void testEmptyClientCreation() throws Exception {
    openMainPage();
    initClientCreation();
    fillClientForm("", "", "", "", "", "", "", "", "1", "January", "1975", "[none]", "", "");
    submitClientCreation();
    returnToMainPage();
  }

private void returnToMainPage() {
	driver.findElement(By.linkText("home page")).click();
}

private void submitClientCreation() {
	driver.findElement(By.name("submit")).click();
}

private void fillClientForm(String first_name, String last_name, String address, String home_phone, String mobile_phone, String work_phone, String email, String email_2, String birth_day, String birth_month, String birth_year, String group, String address_2, String home_phone_2) {
	driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(first_name);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(last_name);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(address);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(home_phone);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(mobile_phone);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(work_phone);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(email_2);
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(birth_day);
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(birth_month);
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(birth_year);
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(group);
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(address_2);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(home_phone_2);
}

private void initClientCreation() {
	driver.findElement(By.linkText("add new")).click();
}

private void openMainPage() {
	driver.get(baseUrl + "/addressbookv4.1.4/");
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
