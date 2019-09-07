package pageobjectstest;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import static base.BrowserDriver.driver;

public class HomePageTest extends BrowserDriver {


    /**
     * I want this method to run before every test cases
     * How should I do it?
     *
     * */

    HomePage objHomePage = null;

    @BeforeMethod
    public void initElements(){
        objHomePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void searchTest() {

        /**
         *  https://chromedriver.chromium.org/getting-started
         * */

        String actualValue = objHomePage.search();
        System.out.println(actualValue);
        String expectedValue = "Showing 1 - 1 of 1 item";
        Assert.assertEquals(actualValue,expectedValue);

    }

}
