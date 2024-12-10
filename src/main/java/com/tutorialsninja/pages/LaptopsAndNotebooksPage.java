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

public class LaptopsAndNotebooksPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement LaptopAndNotBook;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    By listOfProductPrice;

    @CacheLookup
    @FindBy(xpath = "input-sort")
    By productSorting;


    public String getTitleOfLaptopAndNotBookPage() {
        Reporter.log("Getting title of laptop and notebook");
        CustomListeners.test.log(Status.PASS, "Getting title of laptop and notebook");
        return getTextFromElement(LaptopAndNotBook);
    }

    public List<WebElement> getListsOfProductPrice(){
        Reporter.log("Getting list of product");
        CustomListeners.test.log(Status.PASS, "Getting list of product");
        return getWebElements(listOfProductPrice);
    }

    public void selectSortByZToA(String option){
        selectByVisibleTextFromDropDown(productSorting, option);
        Reporter.log("Select product from dropdown");
        CustomListeners.test.log(Status.PASS, "Select product from dropdown");
    }

    public void clickOnYourSelectedProduct(String productName){
        clickOnElement(By.linkText(productName));
        Reporter.log("Click on selected product");
        CustomListeners.test.log(Status.PASS, "Click on selected product");
    }
}