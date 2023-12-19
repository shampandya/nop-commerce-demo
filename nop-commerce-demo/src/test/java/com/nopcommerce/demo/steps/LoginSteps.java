package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps {


    @Given("I am on homepage")
    public void iAmOnHomepage() {
    }

    @When("I click on login link")
    public void iClickOnLoginLink() {
        new HomePage().clickOnLoginLink();
    }


    @Then("I verify the message {string}")
    public void iVerifyTheMessage(String message) {
        Assert.assertEquals(new LoginPage().getWelcomeText(),message , "Message not displayed");

    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        new LoginPage().enterEmailId(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        new LoginPage().enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        Assert.assertTrue(new LoginPage().getErrorMessage().contains(errorMessage),  "Error message not displayed");
    }

    @Then("I should log in successfully")
    public void iShouldLogInSuccessfully() {
    }

    @And("verify its display {string} link")
    public void verifyItsDisplayLink(String logout) {
        Assert.assertEquals(new HomePage().verifyLogoutLink(), logout, "Log out link not displayed");

    }

    @Then("Click on LogOut Link")
    public void clickOnLogOutLink() {
        new HomePage().clickOnLogoutLink();
    }


    @And("verify its display loginLink {string}")
    public void verifyItsDisplayLoginLink(String login) {
        Assert.assertEquals(new HomePage().verifyLoginLink(), login, "Log in link not displayed");

    }
}
