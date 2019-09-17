package pageobjectstest;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import reader.MyDataReader;

public class LoginPageTest extends BrowserDriver {
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

    @DataProvider
    public Object[][] readData() throws Exception {

        // Show where is file--> Done
        // Read the file
        MyDataReader dataReader = new MyDataReader();
        String path = System.getProperty("user.dir") +"/testData/TestData.xlsx";
        dataReader.setExcelFile(path);
       Object[][] data = dataReader.getExcelSheetData("Sheet3");
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
