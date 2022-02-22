package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FailedLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        WebElement singOnLink = driver.findElement(By.xpath("//*[@id='MenuContent']/a[2]"));
        singOnLink.click();

        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.sendKeys("Wrong");

        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.clear();
        inputPassword.sendKeys("WrongPassword");

        WebElement buttonLogIn = driver.findElement(By.xpath("//input[@value='Login']"));
        buttonLogIn.click();

        WebElement wrondDataText = driver.findElement(By.xpath("//*[@id='Content']/ul/li"));
        Assert.assertEquals(wrondDataText.getText(),"Invalid username or password. Signon failed.");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();

        driver.quit();
    }
}
