package com.Capstan.manager;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OpenAccount extends base {
    private WebDriver driver;
    //Locators
    private By openAccountButton = By.xpath("//button[contains(text(),'Open Account')]");
    private By customerDropDown = By.id("userSelect");
    private By CurrencyDropDown = By.id("currency");
    private By processButton = By.xpath("//button[contains(text(),'Process')]");
    private By customerButton = By.xpath("//button[contains(text(),'Customers')]");
    // private By alertButtonLocator = By.id("alertButtonId");
    // private By addCustButton = By.xpath("//button[contains(text(),'Process')]");

    // Constructor
    public OpenAccount(WebDriver driver) {
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
    public void clickOpenAccountButton() {
        WebElement openAccountButtonElement = driver.findElement(openAccountButton);
        openAccountButtonElement.click();
    }
   
    public void selectCostomerFromDropdown() {
        WebElement dropdownElement = driver.findElement(customerDropDown);
        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();
        WebElement lastOption = options.get(options.size() - 1);

        // Select the last option
        if (!options.isEmpty()) {
            dropdown.selectByIndex(options.size() - 1);
        }

    }
    public void selectCurrencyFromDropdown() {
        WebElement dropdownElement = driver.findElement(CurrencyDropDown);
        Select dropdown = new Select(dropdownElement);

        // Get all options from the dropdown
        List<WebElement> options = dropdown.getOptions();
        
        // Select the last option
        if (!options.isEmpty()) {
            dropdown.selectByIndex(options.size() - 1);
        }
    }
    public void clickProcessButton() {
        WebElement processButtonElement = driver.findElement(processButton);
        processButtonElement.click();
    }
    public void clickCustomerButton() {
        WebElement openCustomerButtonElement = driver.findElement(customerButton);
        openCustomerButtonElement.click();
    }
    public void handleAlert() {
            try {
                Alert alert = driver.switchTo().alert();
                // Handle the alert
                alert.accept();
            } catch (NoAlertPresentException e) {
                // Alert is not present
            }
    }
   
    

    
}
