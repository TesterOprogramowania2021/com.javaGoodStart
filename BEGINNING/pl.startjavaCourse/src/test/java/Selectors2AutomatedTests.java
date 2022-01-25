//public class Selectors2AutomatedTests {
//}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Selectors2AutomatedTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void mySecondTest() {
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=");

        driver.findElement(By.name("username"));
        driver.findElement(By.name("password"));
        driver.findElement(By.name("account.languagePreference"));
        driver.findElement(By.name("account.favouriteCategoryId"));
        driver.findElement(By.name("account.listOption"));
        driver.findElement(By.name("account.bannerOption"));
        driver.findElement(By.name("newAccount"));


    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}