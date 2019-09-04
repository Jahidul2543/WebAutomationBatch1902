import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

    @Test
    public void search() {

        /**
         *  https://chromedriver.chromium.org/getting-started
         * */
        System.setProperty("webdriver.chrome.driver", "/Users/jahidul/IdeaProjects/WebAutomationBatch1902/driver/chromedriver");

        WebDriver  driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
      //  driver.findElement(By.id("search_query_top")).sendKeys("T Shirt");
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T Shirt");
        driver.findElement(By.name("submit_search")).click();
        String actualValue =  driver.findElement(By.className("product-count")).getText();
        System.out.println(actualValue);
        String expectedValue = "Showing 1 - 1 of 1 item";
        Assert.assertEquals(actualValue,expectedValue);

        driver.close();

    }

}
