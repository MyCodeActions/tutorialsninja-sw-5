package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;



    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName ;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate ;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement productModel;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice ;



    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    By changeQuantity;


    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement messageOfProductUpdate ;



    public String getShoppingCartPageTitle() {
        Reporter.log("Getting shoppoing cart title");
        CustomListeners.test.log(Status.PASS, "Getting shoppoing cart title");
        return getTextFromElement(pageTitle);
    }

    public String getProductName() {
        Reporter.log("Getting product name");
        CustomListeners.test.log(Status.PASS, "Getting product name");
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        Reporter.log("Getting delivery date" +deliveryDate);
        CustomListeners.test.log(Status.PASS, "Getting delivery date" +deliveryDate);
        return getTextFromElement(deliveryDate);
    }

    public String getProductModel() {
        Reporter.log("Getting product model " +productModel);
        CustomListeners.test.log(Status.PASS, "Getting product model " +productModel);
        return getTextFromElement(productModel);
    }

    public String getProductTotalPrise() {
        Reporter.log("Getting product total price " +totalPrice);
        CustomListeners.test.log(Status.PASS, "Getting product total price " +totalPrice);
        return getTextFromElement(totalPrice);
    }

    public void changeQuantity(String qty){
        sendTextToElementWithClearText(changeQuantity, qty);
        Reporter.log("Changing quantity");
        CustomListeners.test.log(Status.PASS, "Changing quantity");
    }

    public void clickOnUpdateButton(){
        clickOnElement(updateBtn);
        Reporter.log("Clicking on update button");
        CustomListeners.test.log(Status.PASS, "Clicking on update button");
    }

    public String getProductUpdateSuccessMessage() {
        Reporter.log("Getting update successful message");
        CustomListeners.test.log(Status.PASS, "Getting update successful message");
        return getTextFromElement(messageOfProductUpdate);
    }

}