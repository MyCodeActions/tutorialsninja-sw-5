package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountPageTile;

    public String getMyAccountPageTitle(){
        Reporter.log("Getting account page title");
        CustomListeners.test.log(Status.PASS, "Getting account page title");
        return getTextFromElement(myAccountPageTile);
    }
}