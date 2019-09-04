import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {


    public void search() {

        /**
         *  https://chromedriver.chromium.org/getting-started
         * */
        System.setProperty("webdriver.chrome.driver", "/Users/jahidul/IdeaProjects/WebAutomationBatch1902/driver/chromedriver");

        WebDriver  driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.findElement(By.id("search_query_top")).sendKeys("T Shirt");
        driver.findElement(By.name("submit_search")).click();
        driver.close();

    }

}
