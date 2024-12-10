package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterAccountPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement pageTitle;



    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;



    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;



    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;



    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phoneNumber;



    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;


    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;



    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    By subScribe;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmationMessage;


    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueConfirmation;


    public String getRegisterAccountTitle() {
        return getTextFromElement(pageTitle);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstName, fName);
        Reporter.log("Enter first name "+firstName);
        CustomListeners.test.log(Status.PASS, "Enter first name "+firstName);
    }

    public void enterLastName(String lNmae) {
        sendTextToElement(lastName, lNmae);
        Reporter.log("Enter last name "+lastName);
        CustomListeners.test.log(Status.PASS, "Enter last name "+lastName);
    }

    public void enterEmail(String mail) {
        sendTextToElement(email, mail);
        Reporter.log("Enter email "+email);
        CustomListeners.test.log(Status.PASS, "Enter email "+email);
    }

    public void enterPhoneNumber(String number) {
        sendTextToElement(phoneNumber, number);
        Reporter.log("Enter phone number  "+phoneNumber);
        CustomListeners.test.log(Status.PASS, "Enter phone number  "+phoneNumber);
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        Reporter.log("Enter password "+password);
        CustomListeners.test.log(Status.PASS, "Enter password "+password);
    }

    public void enterConfirmPassword(String cPass) {
        sendTextToElement(confirmPassword, cPass);
        Reporter.log("Enter confirm password "+confirmPassword);
        CustomListeners.test.log(Status.PASS, "Enter confirm password "+confirmPassword);
    }

    public void selectSubscribe(String option) {
        selectByContainsTextFromListOfElements(subScribe, option);
        Reporter.log("Select subscribe ");
        CustomListeners.test.log(Status.PASS, "Select subscribe ");
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicy);
        Reporter.log("Click on privacy policy ");
        CustomListeners.test.log(Status.PASS, "Click on privacy policy ");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button ");
        CustomListeners.test.log(Status.PASS, "Click on continue button ");
    }

    public String getAccountRegistrationConformationMessage() {
        Reporter.log("Getting account registration confirmation message ");
        CustomListeners.test.log(Status.PASS, "Getting account registration confirmation message ");
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        clickOnElement(continueConfirmation);
        Reporter.log("Click on continue button ");
        CustomListeners.test.log(Status.PASS, "Click on continue button ");
    }

}