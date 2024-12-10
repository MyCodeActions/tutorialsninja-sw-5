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

public class DeskTopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopTitle;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProduct;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement productSorting;


    public String getDesktopPageTitle() {
        Reporter.log("Getting desktop page tiltle");
        CustomListeners.test.log(Status.PASS, "Getting desktop page tiltle");
        return getTextFromElement(desktopTitle);
    }

    public List<WebElement> getListsOfProduct() {
        Reporter.log("Getting list of products");
        CustomListeners.test.log(Status.PASS, "Getting list of products");
        return getWebElements(listOfProduct);
    }

    public void selectSortByZToA(String option) {
        selectByVisibleTextFromDropDown(productSorting, option);
        Reporter.log("Select option from dropdown");
        CustomListeners.test.log(Status.PASS, "Select option from dropdown");
    }

    public void clickOnYourSelectedProduct(String productName) {
        clickOnElement(By.linkText(productName));
        Reporter.log("Clicking on product name");
        CustomListeners.test.log(Status.PASS, "Clicking on product name");
    }
}

