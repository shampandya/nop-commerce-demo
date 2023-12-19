package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class computer {
    @When("I click on Computer link")
    public void iClickOnComputerLink() {
        new ComputerPage().clickOnMenuTab("Computers");
    }

    @Then("I verify text {string}")
    public void iVerifyText(String Computers) {
        Assert.assertEquals(new ComputerPage().getComputerText(), Computers, "Computer text not displayed");
    }

    @And("I click on Desktop link")
    public void iClickOnDesktopLink() {
        new ComputerPage().clickOnDesktops("Desktops");
    }

    @Then("I verify {string}")
    public void iVerify(String Desktops) {
        Assert.assertEquals(new ComputerPage().getDesktopsText(), Desktops, "Desktops text not displayed");

    }

    @And("I Click on product name {string}")
    public void iClickOnProductName(String arg0) {
        new ComputerPage().clickOnBuildYourOwnComputer();
    }

    @And("^I select processoe \"([^\"]*)\"$")
    public void iSelectProcessoe(String processor) {
        new BuildYourOwnComputerPage().selectProcessor(processor);
    }

    @And("^I select RAM \"([^\"]*)\"$")
    public void iSelectRAM(String ram) {
        new BuildYourOwnComputerPage().selectRam(ram);
    }

    @And("^I select HDD \"([^\"]*)\"$")
    public void iSelectHDD(String hdd) {
        new BuildYourOwnComputerPage().selectHDD(hdd);
    }

    @And("^I select OS \"([^\"]*)\"$")
    public void iSelectOS(String os) {
        new BuildYourOwnComputerPage().selectOS(os);
    }

    @And("^I select Software \"([^\"]*)\"$")
    public void iSelectSoftware(String software) {
        new BuildYourOwnComputerPage().selectSoftware(software);
    }

    @And("^I click on Add to Cart Button$")
    public void iClickOnAddToCartButton() {
        new BuildYourOwnComputerPage().clickOnAddToCartButton();
    }

    @Then("I Verify message {string}")
    public void iVerifyMessage(String arg0) {
        Assert.assertEquals(new BuildYourOwnComputerPage().getProductNameText(), "Build your own computer", "Text displayed");
    }

}