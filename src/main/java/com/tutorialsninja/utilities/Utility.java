package com.tutorialsninja.utilities;

import com.tutorialsninja.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Utility extends ManageBrowser {

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will click on given locator path
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     *This method will select dropdown
     */
    public void selectFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // This method will get list of we elements
    public List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }
    public List<WebElement> getWebElements(List<WebElement> element) {
       return element;
    }

    //This method will select the option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {

        List<WebElement> webElementList = driver.findElements(by);
        for (WebElement element : webElementList) {
            if (element.getText().contains(text)) {
                element.click();
                break;
            }
        }
    }


    // This method will help you to pick date from date picker dialog
    public void selectDateFromDatePicker(String year, String month, String date,
                                         By dateButtonXpath , By monthAndYearXpath,
                                         By nextButtonPath, By allDatesXpath){

       /* String year = "2024";
        String month = "November";
        String date = "27";*/
        clickOnElement(dateButtonXpath);
        while (true) {
            String monthAndYear = driver.findElement(monthAndYearXpath).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonPath);
            }
        }
        List<WebElement> allDates = getWebElements(allDatesXpath);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    // this method will send text on element
    public void sendTextToElementWithClearText(By by, String inputText) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(inputText);
    }

    //This method will use to hover mouse on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //This method will use to hover mouse on element
    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    //This method will use to hover mouse on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method is for hover mouse on element and click it
     */
    public void mouseHoverAndClick(By by) {
        WebElement element = driver.findElement(by);
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).click().perform();
    }

    /**
     * This method is for hover mouse on element
     */
    public void mouseToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).perform();
    }

    //This method will select the option by contains text from List of Elements
    public void selectByContainsTextFromListOfElements(By by, String text) {
        List<WebElement> webElementList = driver.findElements(by);
        for (WebElement element : webElementList) {
            if (element.getText().contains(text)) {
                element.click();
                break;
            }
        }
    }

    public void selectByIndexFromDropdown(By by,int value) {
        WebElement dropdownForProcessor = driver.findElement(by);
        Select select1 = new Select(dropdownForProcessor);
        select1.selectByIndex(value);
    }

        public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }
    //************************** ScreenShot Methods *********************************************//
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);

    }


    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * This method will take screenshot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/demo/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/demo/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

//    public static String takeScreenShot(String fileName) {
//        String filePath = System.getProperty("user.dir") + "/test-output/html/";
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
//        String imageName = fileName + currentTimeStamp() + ".jpg";
//        String destination = filePath + imageName;
//        try {
//            FileUtils.copyFile(scr1, new File(destination));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return destination;
//    }
}
