package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuPage extends Utility {
    // Constructor to initialize WebDriver
    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to select a menu
    public void selectMenu(String menu) {
        By menuLocator = By.linkText(menu);
        clickOnElement(By.linkText(menu));
    }

//    By desktopsTab = By.linkText("Desktops");
//    By laptopsTab = By.linkText("Laptops & Notebooks");
//    By componentsTab = By.linkText("Components");
//    By topMenuItems = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
//    By desktopsHeader = By.xpath("//h2[normalize-space()='Desktops']");
//    By laptopsHeader = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
//    By componentsHeader = By.xpath("//h2[contains(text(),'Components')]");
//
//
//    public void selectMenu(String menu) {
//        List<WebElement> topMenuList = getListOfElements(topMenuItems);
//        try {
//            for (WebElement element : topMenuList) {
//                if (element.getText().equalsIgnoreCase(menu)) {
//                    element.click();
//                    break;
//                }
//            }
//        } catch (StaleElementReferenceException e) {
//            topMenuList = getListOfElements(topMenuItems);
//        }
//    }
//
//
//    public void navigateToDesktopsPage(String menu) {
//        mouseHoverToElementAndClick(desktopsTab);
//        selectMenu(menu);
//    }
//
//
//    public void navigateToLaptopsPage(String menu) {
//        mouseHoverToElementAndClick(laptopsTab);
//        selectMenu(menu);
//    }
//
//
//    public void navigateToComponentsPage(String menu) {
//        mouseHoverToElementAndClick(componentsTab);
//        selectMenu(menu);
//    }
//
//
//    public String getPageHeader(By headerLocator) {
//        return getTextFromElement(headerLocator);
//    }
//
//    // Header locators to verify text
//    public By getDesktopsHeader() {
//        return desktopsHeader;
//    }
//
//    public By getLaptopsHeader() {
//        return laptopsHeader;
//    }
//
//    public By getComponentsHeader() {
//        return componentsHeader;
//    }

}
