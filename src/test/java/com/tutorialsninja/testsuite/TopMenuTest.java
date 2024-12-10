package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DeskTopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {


    HomePage homePage = new HomePage();
    DeskTopsPage desktopsPage = new DeskTopsPage();
    LaptopsAndNotebooksPage notebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    @Test(groups = {"sanity"})
    public void selectMenu(String menu) {
        homePage.clickOnMenuOption(menu);
    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        // Mouse hover on the “Desktops” Tab and click
        homePage.mouseHoverOnDesktop();
        Thread.sleep(2000);

        // call the selectMenu() method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");

        // Verify the text ‘Desktops
        Assert.assertEquals(desktopsPage.getDesktopPageTitle(), "Desktops",
                "Not navigate to Desktop page");

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        // Mouse hover on the “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopAndNotBook();

        // call selectMenu() method and pass the menu = “Show AllLaptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        // Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(notebooksPage.getTitleOfLaptopAndNotBookPage(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }


    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        // Mouse hover on the “Components” Tab and click
        homePage.mouseHoverOnComponents();

        // call the selectMenu() method and pass the menu = “Show AllComponents
        selectMenu("Show AllComponents");

        // Verify the text ‘Components
        Assert.assertEquals(componentsPage.getPageTitleOfComponents(), "Components",
                "Not navigate to Components page");
    }
}
