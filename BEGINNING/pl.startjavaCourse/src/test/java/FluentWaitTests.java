import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTests {



    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }
    @Test
    public void fluentWaitTest(){
        WebElement textHellowWorld = driver.findElement(By.xpath("//*[@id='finish']/h4"));
        FluentWait<WebDriver>fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(10));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(NoSuchElementException.class);
        Assert.assertFalse(textHellowWorld.isDisplayed());
        WebElement buttonStart = driver.findElement(By.cssSelector("#start>button"));
        buttonStart.click();
        fluentWait.until(ExpectedConditions.visibilityOf(textHellowWorld));
        Assert.assertTrue(textHellowWorld.isDisplayed());

    }
}
