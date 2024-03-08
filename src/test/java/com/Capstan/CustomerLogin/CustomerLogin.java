package com.Capstan.CustomerLogin;
// import com.example.CustomerLogin.AllLocators

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerLogin {
    private WebDriver driver;

    // Locators
    private By homeButton = By.xpath("//button[contains(text(),'Home')]");
    private By customerLoginButton = By.xpath("//button[contains(text(),'Customer Login')]");
    private By nameDropdown = By.id("userSelect");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");


    // Constructor
    public CustomerLogin(WebDriver driver) {
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
    public void clickCustomerLoginButton() {
        WebElement customerLoginButtonElement = driver.findElement(customerLoginButton);
        customerLoginButtonElement.click();
    }


    public void selectNameDropdown() {
        WebElement dropdownElement = driver.findElement(nameDropdown);
        Select dropdown = new Select(dropdownElement);

        // Get all options from the dropdown
        List<WebElement> options = dropdown.getOptions();
        
        // Select the last option
        if (!options.isEmpty()) {
            dropdown.selectByIndex(options.size() - 1);
        }
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }



}
