package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class RegisterPage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement registerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='gender']//label")
    List<WebElement> genderRadios;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;

    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;

    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYear;

    @CacheLookup
    @FindBy(xpath = "//a[@class = 'ico-register']")
    WebElement registerBtn;

    @CacheLookup
    @FindBy(className = "field-validation-error")
    List<WebElement> fieldValidationErrors;

    @CacheLookup
    @FindBy(css = ".result")
    WebElement yourRegCompletedText;

    @CacheLookup
    @FindBy(css = ".button-1.register-continue-button")
    WebElement continueBtn;


    public String getRegisterText() {
        log.info("Get registerText : " + registerText.getText());
        return getTextFromElement(registerText);
    }
    public void selectGender(String gender) {
        for (WebElement radio : genderRadios) {
            if (radio.getText().contains(gender)) {
                Reporter.log("Select '" + gender + "' radio button" + "<br>");
                log.info("Select '" + gender + "' radio button");
                clickOnElement(radio);
                break;
            }
        }
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
        Reporter.log("Enter Firstname : '" + firstName + "' to firstName field" + "<br>");
        log.info("Enter Firstname : '" + firstName + "' to firstName field");
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
        Reporter.log("Enter Lastname : '" + lastName + "' to lastName field" + "<br>");
        log.info("Enter Lastname : '" + lastName + "' to lastName field");
    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectByVisibleTextFromDropDown(dateOfBirthDay, day);
        selectByVisibleTextFromDropDown(dateOfBirthMonth, month);
        selectByVisibleTextFromDropDown(dateOfBirthYear, year);
        Reporter.log("Select day : '" + day + "', month : '" + month + "', year : '" + year + "'" + "<br>");
        log.info("Select day : '" + day + "', month : '" + month + "', year : '"
                + year + "' for DateOfBirth");
    }

        public void clickOnRegisterButton() {
        Reporter.log("Click on 'REGISTER' button" + "<br>");
        clickOnElement(registerBtn);
        log.info("Click on 'REGISTER' button");
    }

    public String getYourRegCompletedText() {
        String message = getTextFromElement(yourRegCompletedText);
        Reporter.log("Get your reg completed text : " + yourRegCompletedText.getText() + "<br>");
        log.info("Get your reg completed text : " + yourRegCompletedText.getText());
        return message;
    }

    public String getValidationErrorMessageForField(String fieldName) {
        String validationMessage = null;
        for (WebElement message : fieldValidationErrors) {
            if (message.getAttribute("data-valmsg-for").equals(fieldName)) {
                validationMessage = message.getText();
                Reporter.log("Click on 'REGISTER' button" + "<br>");
                log.info("Validation message : '" + message.getText() + "' for " +
                        "fieldName '" + fieldName + "'");
                break;
            }
        }
        return validationMessage;
    }
    public void clickOnContinueButton() {
        Reporter.log("Click on 'CONTINUE' button" + "<br>");
        log.info("Click on 'CONTINUE' button");
        clickOnElement(continueBtn);
    }
}
