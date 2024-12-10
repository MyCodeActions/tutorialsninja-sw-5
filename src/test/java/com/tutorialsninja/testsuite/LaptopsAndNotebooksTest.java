package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.ProductDetailPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage notebooksPage = new LaptopsAndNotebooksPage();
    ProductDetailPage detailPage = new ProductDetailPage();
    ShoppingCartPage cartPage = new ShoppingCartPage();

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        notebooksPage = new LaptopsAndNotebooksPage();
        detailPage = new ProductDetailPage();
        cartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // Mouse hover on the Laptops & Notebooks Tab. and click
        homePage.mouseHoverOnLaptopAndNotBook();

        // Click on “Show AllLaptops & Notebooks”
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");

        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : notebooksPage.getListsOfProductPrice()) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        // Select the Sort By "Price (High > Low)"
        notebooksPage.selectSortByZToA("Price (High > Low)");

        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : notebooksPage.getListsOfProductPrice()) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);

        // Verify the Product price will be arranged in High to Low orders.
        Assert.assertEquals(afterSortByPrice, originalProductsPrice,
                "Product not sorted by price High to Low");

    }

    @Test(groups = {"smoke"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        homePage.mouseHoverOnCurrencyAndClickOn();
        homePage.selectCurrencyAsAPound("£Pound Sterling");
        homePage.mouseHoverOnLaptopAndNotBook();
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");
        notebooksPage.selectSortByZToA("Price (High > Low)");
        notebooksPage.clickOnYourSelectedProduct("MacBook");
        softAssert.assertEquals(detailPage.getPageTitle(), "MacBook",
                "Product not display");
        Thread.sleep(200);
        detailPage.clickOnAddToCartButton();
        Thread.sleep(200);
        softAssert.assertTrue(detailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(5000);
        detailPage.clickOnShoppingCartLink();
        Thread.sleep(5000);
        softAssert.assertTrue(cartPage.getShoppingCartPageTitle().contains("Shopping Cart"));
        softAssert.assertEquals(cartPage.getProductName(), "MacBook",
                "Product name not matched");
        cartPage.changeQuantity("2");
        cartPage.clickOnUpdateButton();
        softAssert.assertTrue(cartPage.getProductUpdateSuccessMessage().contains("Success: You have modified your shopping cart!"),
                "Cart not modified");
        softAssert.assertEquals(cartPage.getProductTotalPrise(), "£737.45",
                "Total not matched");
        softAssert.assertAll();
    }
}
