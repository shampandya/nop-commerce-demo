package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class register {
    @When("I click on Register link")
    public void iClickOnRegisterLink() {
        new HomePage().clickOnRegisterLink();
    }

    @Then("I verify {string} text")
    public void iVerifyText(String register) {
        Assert.assertEquals(new RegisterPage().getRegisterText(), register, "Register text not displayed");
    }

    @When("I click on Register button")
    public void iClickOnRegisterButton() throws InterruptedException {
        Thread.sleep(2000);
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("I get Validation Error Message For Field \\({string}, {string}, {string},{string}, {string} )")
    public void iGetValidationErrorMessageForField(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) throws InterruptedException {
        Thread.sleep(2000);
        new RegisterPage().getValidationErrorMessageForField(FirstName);
        Thread.sleep(2000);
        new RegisterPage().getValidationErrorMessageForField(LastName);
        Thread.sleep(2000);
        new RegisterPage().getValidationErrorMessageForField(Email);
        Thread.sleep(2000);
        new RegisterPage().getValidationErrorMessageForField(Password);
        Thread.sleep(2000);
        new RegisterPage().getValidationErrorMessageForField(ConfirmPassword);
    }

    @And("I select gender {string}")
    public void iSelectGender(String Female) {
        new RegisterPage().selectGender(Female);
    }

    @And("I enter firstname {string}")
    public void iEnterFirstname(String FirstName) {
        new RegisterPage().enterFirstName(FirstName);
    }

    @And("I enter lastname {string}")
    public void iEnterLastname(String LastName) {
        new RegisterPage().enterLastName(LastName);
    }

    @And("I enter confirm Password {string}")
    public void iEnterConfirmPassword(String pass) throws InterruptedException {
        Thread.sleep(2000);
        new LoginPage().enterConfirmPassword(pass);
    }

    @And("I enter date of birth  {string}, {string}, {string}")
    public void iEnterDateOfBirth(String date, String month, String year) {
        new RegisterPage().selectDateOfBirth("20", "January", "2001");
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertTrue(new RegisterPage().getYourRegCompletedText().contains(message),"Error msg not found" );
    }



}

