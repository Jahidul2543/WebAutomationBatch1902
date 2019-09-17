package pageobjectstest;

import api.GoogleSheetReader;
import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import reader.MyDataReader;

public class UsingGoogleSheetLoginPageTest extends BrowserDriver {
    LoginPage objLoginPage = null;
    HomePage objHomePage = null;


    @BeforeMethod
    public void initializationOfElements() {

        objLoginPage= PageFactory.initElements(driver, LoginPage.class);
        objHomePage = PageFactory.initElements(driver, HomePage.class);
    }
    /**
     *
     * Read Data from XLSX file
     *
     * */

    /**
     *
     * Read data from Google Sheet
     * Make sure you have created client_secret.json from your account where you have Google Sheet Data file
     * Delete .credentials directory from your module if it is exists. Other wise it will take existing/old credentials
     * thus it may give unauthorized access error(error code starting with 4, such as 403,404)
     * We can supply data to test method by two ways
     * 1. We can use @DataProvider to feed data to the test method
     * 2. We can supply data to the test method directly
     *
     * */

    @DataProvider
    public Object[][] readData() throws Exception {

        // Show where is file--> Done
        // Read the file

        GoogleSheetReader googleSheetReader = new GoogleSheetReader();

       Object[][] data = googleSheetReader.getSpreadSheetRecordsToSupplyDataProvider("1qNyDpYD8hN-gt7QDrcwkNpZlkFa2q5DoRYM2sLnxTYc", "Sheet2!A1:C");
       return data;

    }

    @Test(dataProvider ="readData" )
    public void loginTest(String email, String password, String expectedMessage){
        objHomePage.getLogInPage();
        objLoginPage.login(email, password);
        String actualText = objLoginPage.getErroMessage();
        Assert.assertEquals(actualText, expectedMessage);
    }

}
