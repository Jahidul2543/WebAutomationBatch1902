package pageobjectstest;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ContactUsPage;
import pageobjects.HomePage;

public class ContactUsPageTest extends BrowserDriver {
    HomePage objHomePage;
    ContactUsPage objContactPage;

    @BeforeMethod
    public void initElements(){
        objHomePage = PageFactory.initElements(driver, HomePage.class);
        objContactPage = PageFactory.initElements(driver, ContactUsPage.class);

    }

    @Test
    public  void sendMessage(){
        objHomePage.gotToContactUsPage();
       String actualText =  objContactPage.selectCustomerService();
        Assert.assertEquals(actualText,"Your message has been successfully sent to our team." );
    }

}
