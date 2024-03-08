package com.Capstan.CustomerLogin;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Capstan.manager.ManagerLogin;
import com.Capstan.manager.OpenAccount;
import org.testng.Assert;

public class MLoginTest extends base{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    // System.setProperty("webdriver.chrome.driver", "C:\\pro\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
    //driver = new ChromeDriver();

    System.setProperty("webdriver.firefox.driver", "D:\\Selenium\\geckodriver-v0.34.0-win32\\geckodriver.exe");
    driver = new FirefoxDriver();

    baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }
  
  @Test
  public void ManagerLoginTest(){
    driver.get(baseUrl);
    driver.manage().window().maximize();
    ManagerLogin managerLoginPage = new ManagerLogin(driver);
    managerLoginPage.clickHomeButton();
    managerLoginPage.clickManagerLoginButton();


    managerLoginPage.clickAddCustomerButton();
    managerLoginPage.enterFName(fname);
    managerLoginPage.sleep(3000);
    managerLoginPage.enterLName(lname);
    managerLoginPage.sleep(3000);
    managerLoginPage.enterPin(pin);
    managerLoginPage.sleep(3000);
    managerLoginPage.clickaddcustButton();
    managerLoginPage.sleep(5000);
    managerLoginPage.handleAlert();

    OpenAccount openAccountPage = new OpenAccount(driver);
    managerLoginPage.sleep(5000);
    openAccountPage.clickOpenAccountButton();
    openAccountPage.sleep(3000);
    openAccountPage.selectCostomerFromDropdown();
    openAccountPage.sleep(3000);
    openAccountPage.selectCurrencyFromDropdown();
    openAccountPage.sleep(3000);
    openAccountPage.clickProcessButton();
    openAccountPage.sleep(5000);
    openAccountPage.handleAlert();
    openAccountPage.sleep(5000);
    openAccountPage.clickCustomerButton();
    openAccountPage.sleep(5000);

    CustomerLogin customerLoginPage = new CustomerLogin(driver);
    customerLoginPage.clickHomeButton();
    customerLoginPage.sleep(3000);
    customerLoginPage.clickCustomerLoginButton();
    customerLoginPage.sleep(3000);
    customerLoginPage.selectNameDropdown();
    customerLoginPage.sleep(3000);
    customerLoginPage.clickLoginButton();

    CustomerDeatils customerDeatils = new CustomerDeatils(driver);
    customerDeatils.clickDepositButton();
    customerDeatils.sleep(3000);
    customerDeatils.enterDepoAmount("2000");
    customerDeatils.sleep(3000);
    customerDeatils.clickDepositRes();
    customerDeatils.sleep(3000);
    customerDeatils.clickWithdrawlButton();
    customerDeatils.sleep(3000);
    customerDeatils.enterWithdrawlAmount("500");
    customerDeatils.sleep(3000);
    customerDeatils.clickWithdrawRes();
    customerDeatils.sleep(3000);
    customerDeatils.clickTransactionButton();
    customerDeatils.sleep(3000);
    customerDeatils.clickBackButton();
    customerDeatils.sleep(3000);
    customerDeatils.logoutButton();


  }
  @AfterClass
  public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

    
}
