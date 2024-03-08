package com.Capstan.manager;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;


public class ManagerTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
     System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
    driver = new ChromeDriver();

    // System.setProperty("webdriver.firefox.driver", "D:\\Selenium\\geckodriver-v0.34.0-win32\\geckodriver.exe");
    // driver = new FirefoxDriver();
    baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void ManagerTestCase() throws Exception {
    driver.get(baseUrl);
    driver.manage().window().maximize();

    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();
    Thread.sleep(2000);
    // driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).clear();


    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")).click();
    // driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")).clear();
    
    WebElement inputFirstName= driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"));
    inputFirstName.sendKeys("swap");

    Thread.sleep(2000);

    WebElement inputLastName= driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]"));
    inputLastName.sendKeys("shah");
    Thread.sleep(2000);

    WebElement inputPinCode=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]"));
    inputPinCode.sendKeys("444607");
    //click on Add customer
    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);

    //handle Add customer alert
    Alert alert = driver.switchTo().alert();
    System.out.println("Customer added successfully with customer id: " + alert.getText());
    alert.accept();
    Thread.sleep(3000);

    //open account
    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]")).sendKeys(Keys.ENTER);;
    Thread.sleep(2000);
    //select drop down 1
    WebElement dropDownElement=driver.findElement(By.id("userSelect"));
    Thread.sleep(2000);


    Select dropdown = new Select(dropDownElement);
    List<WebElement> options = dropdown.getOptions();
    int lastOptionIndex = options.size() - 1;
    dropdown.selectByIndex(lastOptionIndex);
    Thread.sleep(2000);

    //select drop down currency
    WebElement dropDownElementcurrency=driver.findElement(By.id("currency"));
    Thread.sleep(2000);
    Select dropdowncurrency = new Select(dropDownElementcurrency);
    List<WebElement> optionscurrency = dropdowncurrency.getOptions();
    int lastOptionIndexcurrency = optionscurrency.size() - 1;
    dropdowncurrency.selectByIndex(lastOptionIndexcurrency);
    Thread.sleep(2000);

    //click on process button
    driver.findElement(By.xpath("//button[contains(text(),'Process')]")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);

    //handle process button alert
    Alert alertprocess = driver.switchTo().alert();
    System.out.println("Alert Text: " + alertprocess.getText());
    alert.accept();
    
    //click on Customers button
    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[3]")).click();
    // driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]"));
    Thread.sleep(5000);
    
        ///////// Customer Login ///////////

    // click on home button
    driver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();
    Thread.sleep(3000);
    
    //Click on Customer Login
    driver.findElement(By.xpath("//button[contains(text(),'Customer Login')]")).click();
    Thread.sleep(3000);

    //select drop down Your name
    WebElement dropDownElementYourName=driver.findElement(By.id("userSelect"));
    Thread.sleep(2000);
    Select dropdownYourName = new Select(dropDownElementYourName);
    List<WebElement> optionsYourName = dropdownYourName.getOptions();
    int lastOptionIndexYourName = optionsYourName.size() - 1;
    dropdownYourName.selectByIndex(lastOptionIndexYourName);
    Thread.sleep(2000);

    //click on login button
    driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    Thread.sleep(3000);

    // click on Deposit
    driver.findElement(By.xpath("//button[contains(text(),'Deposit')]")).click();
    Thread.sleep(3000);

    // enter amount Deposit
    WebElement InputAmountDeposit = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]"));
    InputAmountDeposit.sendKeys("2000");
    Thread.sleep(3000);
    // click on show Transactions
    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    //click on Transactions
    driver.findElement(By.xpath("//button[contains(text(),'Transactions')]")).click();
    Thread.sleep(3000);
    // click on Back
    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    Thread.sleep(3000);
    // click on Withdrawl button
    driver.findElement(By.xpath("//button[contains(text(),'Withdrawl')]")).click();
    Thread.sleep(3000);
    // enter amount withdrawl
    WebElement InputAmountWithdrawl = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]"));
    InputAmountWithdrawl.sendKeys("500");
    Thread.sleep(3000);

    // enter withdraw
    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")).click();
    Thread.sleep(3000);

   
    // click on Logout
    driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();
    Thread.sleep(3000);
    driver.quit();
   }

}

