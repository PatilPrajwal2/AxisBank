package com.Capstan.manager;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;


public class ManagerLogin extends base{
    private WebDriver driver;
    //Manager Loaators
    private By homeButton = By.xpath("//button[contains(text(),'Home')]");
    private By managerLoginButton = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    private By addCustomerButton = By.xpath("//button[contains(text(),'Add Customer')]");
    private By fnameInput = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
    private By lnameInput = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]");
    private By pinInput = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]");
    private By addCustButton = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");

    // Constructor

    public ManagerLogin(WebDriver driver) {
        this.driver = driver;
    }
    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Methods to interact with elements
    public void clickHomeButton() {
        WebElement homeButtonElement = driver.findElement(homeButton);
        homeButtonElement.click();
    }
    public void clickManagerLoginButton() {
        WebElement ManagerLoginButtonElement = driver.findElement(managerLoginButton);
        ManagerLoginButtonElement.click();
    }
    public void clickAddCustomerButton() {
        WebElement AddCustomerButtonElement = driver.findElement(addCustomerButton);
        AddCustomerButtonElement.click();
    }
    public void enterFName(String fname) {
        WebElement NameElement = driver.findElement(fnameInput);
        NameElement.sendKeys(fname);
       
}
    public void enterLName(String lname) {
        WebElement LastNameElement = driver.findElement(lnameInput);
        LastNameElement.sendKeys(lname);
        // LastNameElement.sendKeys(Keys.ENTER);
    }
    public void enterPin(String pin) {
        WebElement pinElement = driver.findElement(pinInput);
        pinElement.sendKeys(pin);
        // pinElement.sendKeys(Keys.ENTER);

    }
    public void clickaddcustButton() {
        WebElement AddCustButtonElement = driver.findElement(addCustButton);
        AddCustButtonElement.sendKeys(Keys.ENTER);
    }
    public void handleAlert() {
            try {
                Alert alert = driver.switchTo().alert();
                // Handle the alert
                alert.accept();
                Assert.assertEquals(true, true, "Customer added Successfully .");
            } catch (NoAlertPresentException e) {
                // Alert is not present
            }
    }

}

