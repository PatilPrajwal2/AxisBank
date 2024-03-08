package com.Capstan.CustomerLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomerDeatils {
    private WebDriver driver;

        // Locators
    private By depositButton = By.xpath("//button[contains(text(),'Deposit')]");
    private By enterDepositAmount = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]");
    private By DepositRes = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]");

    private By withdrawlButton = By.xpath("//button[contains(text(),'Withdrawl')]");
    private By WithdrawlAmount = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]");
    private By WithdrawRes = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]");

    private By transactionsButton = By.xpath("//button[contains(text(),'Transactions')]");
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    private By logoutButton = By.xpath("//button[contains(text(),'Logout')]");

    public CustomerDeatils(WebDriver driver){
        this.driver = driver;

    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickDepositButton() {
        WebElement depositButtonElement = driver.findElement(depositButton);
        depositButtonElement.click();
    }
    public void enterDepoAmount(String amount) {
        WebElement depositamountElement = driver.findElement(enterDepositAmount);
        depositamountElement.clear();
        depositamountElement.sendKeys(amount);
        // NameElement.sendKeys(Keys.ENTER);
    }

    public void clickDepositRes() {
        WebElement depositButtonElement = driver.findElement(DepositRes);
        depositButtonElement.click();
    }

    public void clickWithdrawlButton() {
        WebElement WithdrawlElement = driver.findElement(withdrawlButton);
        WithdrawlElement.click();
    }
    public void enterWithdrawlAmount(String amount) {
        WebElement withdrawlamountElement = driver.findElement(WithdrawlAmount);
        withdrawlamountElement.clear();
        withdrawlamountElement.sendKeys(amount);
        // NameElement.sendKeys(Keys.ENTER);
    }

    public void clickWithdrawRes() {
        WebElement WithdrawResElement = driver.findElement(WithdrawRes);
        WithdrawResElement.click();
    }

    public void clickTransactionButton() {
        WebElement transactionsElement = driver.findElement(transactionsButton);
        transactionsElement.click();
    }

    public void clickBackButton() {
        WebElement backElement = driver.findElement(backButton);
        backElement.click();
    }

    public void logoutButton() {
        WebElement logoutElement = driver.findElement(logoutButton);
        logoutElement.click();
    }

    
    
}
