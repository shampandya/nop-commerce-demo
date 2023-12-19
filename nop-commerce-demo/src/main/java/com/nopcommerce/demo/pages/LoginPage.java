package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Jay Vaghani
 */
public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy (id = "ConfirmPassword")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        log.info("Getting text from : " + welcomeText.toString());
        return message;
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        Reporter.log("Enter Email : '" + email + "' to email field" + "<br>");
        log.info("Enter Email : '" + email + "' to email field");
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Enter Password : '" + password + "' to password field" + "<br>");
        log.info("Enter Password : '" + password + "' to password field");
    }

    public void enterConfirmPassword(String password) {
        sendTextToElement(confirmPassword, password);
        Reporter.log("Enter Confirm password : '" + confirmPassword + "' to confirm password field" + "<br>");
        log.info("Enter Confirm password : '" + confirmPassword + "' to confirm " + "password field");
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on 'login' button" + "<br>");
        clickOnElement(loginButton);
        log.info("Click on 'login' button");

    }

    public String getErrorMessage() {
        log.info("Getting Error Message : " + errorMessage.toString());
        return getTextFromElement(errorMessage);
    }
}
