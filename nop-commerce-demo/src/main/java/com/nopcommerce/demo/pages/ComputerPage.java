package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/child::ul[1]/li/a")
    List<WebElement> topMenuList;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='category-grid sub-category-grid']//h2/a")
    List<WebElement> desktopsLink;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopText;

    @CacheLookup
    @FindBy(linkText = "Build your own computer")
    WebElement buildYourOwnComputer;


    public void clickOnMenuTab(String tab) {
        for (WebElement menu : topMenuList) {
            if (menu.getText().contains(tab)) {
                log.info("Click on '" + tab + "' tab <br>");
                clickOnElement(menu);
                break;
            }
        }
    }

    public String getComputerText() {
        return getTextFromElement(computerText);
    }
    public void clickOnDesktops(String subTab) {
        for (WebElement menu : desktopsLink) {
            if (menu.getText().contains(subTab)) {
                clickOnElement(menu);
                log.info("Click on '" + subTab + "' link <br>");
                break;
            }
        }
    }

    public String getDesktopsText() {
        log.info("Get your desktop text : " + desktopText.getText());
        return getTextFromElement(desktopText);
    }

    public void clickOnBuildYourOwnComputer() {
        clickOnElement(buildYourOwnComputer);
        log.info("Click on build your own computer link");

    }
}
