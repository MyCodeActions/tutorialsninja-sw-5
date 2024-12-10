package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    By topMenuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement desktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    By laptopAndNotBook;

    @CacheLookup
    @FindBy(linkText = "Components")
    By components;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    By currency;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    By selectPound;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    By listOfAccountOption;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement confirmationMsgOfLogOut;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement btnContinue;




    public List<WebElement> getTopMenuList() {
        Reporter.log("Getting list of top menu");
        CustomListeners.test.log(Status.PASS, "Getting list of top menu");
        return getWebElements(topMenuList);
    }

    public void clickOnMenuOption(String name) {
        clickOnElement(By.linkText(name));
        Reporter.log("Clicking on menu");
        CustomListeners.test.log(Status.PASS, "Clicking on menu");
    }

    public void mouseHoverOnDesktop() {
        mouseHoverToElement(desktop);
        Reporter.log("Moving mouse on Desktop");
        CustomListeners.test.log(Status.PASS, "Moving mouse on Desktop");
    }

    public void mouseHoverOnLaptopAndNotBook() {
        mouseHoverToElement(laptopAndNotBook);
        Reporter.log("Hovering mouse on laptop and Notebook");
        CustomListeners.test.log(Status.PASS, "Hovering mouse on laptop and Notebook");
    }

    public void mouseHoverOnComponents() {
        mouseHoverToElement(components);
        Reporter.log("Hovering mouse on components");
        CustomListeners.test.log(Status.PASS, "Hovering mouse on components");
    }

    public void mouseHoverOnCurrencyAndClickOn(){
        mouseHoverToElementAndClick(currency);
        Reporter.log("Hovering and clicking mouse on currency");
        CustomListeners.test.log(Status.PASS, "Hovering and clicking mouse on currency");
    }

    public void selectCurrencyAsAPound(String option){
        selectByContainsTextFromDropDown(selectPound, option);
        Reporter.log("Select currency as a pound from dropdown");
        CustomListeners.test.log(Status.PASS, "Select currency as a pound from dropdown");

    }

    public List<WebElement> getListOfMyAccountOption() {
        Reporter.log("Getting list of account options");
        CustomListeners.test.log(Status.PASS, "Getting list of account options");
        return getWebElements(listOfAccountOption);
    }

    public void clickOnMyAccount(){
        clickOnElement(myAccount);
        Reporter.log("Clicking on account");
        CustomListeners.test.log(Status.PASS, "Clicking on account");
    }

    public String getConfirmationMessageOfLogout(){
        Reporter.log("Getting confirmation message of log out");
        CustomListeners.test.log(Status.PASS, "Getting confirmation message of log out");
        return getTextFromElement(confirmationMsgOfLogOut);
    }

    public void clickOnContinueButton(){
        clickOnElement(btnContinue);
        Reporter.log("Clicking on continue button");
        CustomListeners.test.log(Status.PASS, "Clicking on continue button");
    }

}