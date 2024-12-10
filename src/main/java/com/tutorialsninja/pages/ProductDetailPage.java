package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ProductDetailPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    By dateButton ;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    By  monthAndYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    By nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    By allDates ;

    @CacheLookup
    @FindBy(name = "quantity")
    By quantity;


    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddCart;


    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    By productAddMsg;


    @CacheLookup
    @FindBy(linkText = "shopping cart")
    By shoppingCart;




    public String getPageTitle(){
        Reporter.log("Getting page title");
        CustomListeners.test.log(Status.PASS, "Getting page title");
        return getTextFromElement(pageTitle);
    }

    public void selectDeliveryDate(String year, String month, String date){
        selectDateFromDatePicker(year, month, date, dateButton, monthAndYear, nextButton, allDates);
        Reporter.log("Select date from calender");
        CustomListeners.test.log(Status.PASS, "Select date from calender");
    }

    public void enterQuantity(String qty){
        sendTextToElementWithClearText(quantity, qty);
        Reporter.log("Enter quantity");
        CustomListeners.test.log(Status.PASS, "Enter quantity");
    }

    public void clickOnAddToCartButton(){
        clickOnElement(btnAddCart);
        Reporter.log("Click on add to cart");
        CustomListeners.test.log(Status.PASS, "Click on add to cart");
    }

    public String getProductAddToCartSuccessMessage(){
        // return waitUntilVisibilityOfElementLocated(productAddMsg, 5).getText();
        Reporter.log("Getting successful message after adding product");
        CustomListeners.test.log(Status.PASS, "Getting successful message after adding product");
        return getTextFromElement(productAddMsg);
    }

    public void clickOnShoppingCartLink(){
        // clickOnElement(waitUntilVisibilityOfElementLocated(shoppingCart ,2));
        //clickOnElement(shoppingCart);
        mouseHoverToElementAndClick(shoppingCart);
        Reporter.log("Click on link of shopping cart");
        CustomListeners.test.log(Status.PASS, "Click on link of shopping cart");
    }
}