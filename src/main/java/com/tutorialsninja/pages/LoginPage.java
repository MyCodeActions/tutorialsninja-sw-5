package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginPageTile;

    @CacheLookup
    @FindBy(xpath = "input-email")
    WebElement email ;

    @CacheLookup
    @FindBy(xpath = "input-password")
    WebElement  password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement  btnLogin;


    public String getLoginPageTitle(){
        Reporter.log("Getting login page title");
        CustomListeners.test.log(Status.PASS, "Getting login page title");
        return getTextFromElement(loginPageTile);
    }

    public void enterEmail(String mail) {
        sendTextToElement(email, mail);
        Reporter.log("Enter email id "+email);
        CustomListeners.test.log(Status.PASS, "Enter email id " +email );
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        Reporter.log("Enter password "+password);
        CustomListeners.test.log(Status.PASS, "Enter password "+password );
    }

    public void clickOnLogInButton() {
        clickOnElement(btnLogin);
        Reporter.log("Click on log in button");
        CustomListeners.test.log(Status.PASS, "Click on login button");
    }
}