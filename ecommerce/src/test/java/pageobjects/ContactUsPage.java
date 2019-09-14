package pageobjects;

import applicationbasepage.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import reporting.TestLogger;

public class ContactUsPage {

    @FindBy(how = How.ID, using = "id_contact")
    WebElement subjectHeading;

    @FindBy(how = How.ID, using = "email")
    WebElement email;

    @FindBy(how = How.ID, using = "id_order")
    WebElement otherReferences;

    @FindBy(how = How.ID, using = "fileUpload")
    WebElement chooseFile;

    @FindBy(how = How.CSS, using = "#message")
    WebElement message;


    @FindBy(how = How.NAME, using = "submitMessage")
    WebElement send;

    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    WebElement textAfterSubmission;


    public String selectCustomerService(){
       // Select select = new Select(subjectHeading);
        //select.selectByIndex(1);
        //select.selectByValue("1");
        HelperMethods.selectByIndex(subjectHeading, 1);
       // email.sendKeys("testdat@gmail.com");

        HelperMethods.sendKeys(email, "Email Box","testdat@gmail.com");
        otherReferences.sendKeys("12334444");
        chooseFile.sendKeys("/Users/jahidul/Downloads/demo.txt");
        message.sendKeys("Hello, Let me know what are the services do you have. Thanks Midul");
        send.click();
        String actualText = textAfterSubmission.getText();
       // System.out.println(actualText);
        TestLogger.log(actualText);
        return actualText;
    }
}
