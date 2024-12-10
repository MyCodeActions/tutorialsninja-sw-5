package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement components;

    public String getPageTitleOfComponents() {
        Reporter.log("Getting components");
        CustomListeners.test.log(Status.PASS, "Getting components");
        return getTextFromElement(components);
    }
}