//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class HoverTests {
//}
////public class CheckBoxesTests {
////}
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.assertTrue;

public class HoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkboxesTest() throws InterruptedException {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
        WebElement ele1 = driver.findElement(By.xpath("(//div[@class='example']/div)[1]"));
        WebElement ele2 = driver.findElement(By.xpath("(//div[@class='example']/div)[2]"));
        WebElement ele3 = driver.findElement(By.xpath("(//div[@class='example']/div)[3]"));
        WebElement text1 = driver.findElement(By.xpath("(//div[@class='figcaption'])[1]"));
        WebElement text2 = driver.findElement(By.xpath("(//div[@class='figcaption'])[2]"));
        WebElement text3 = driver.findElement(By.xpath("(//div[@class='figcaption'])[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(ele1).build().perform();
        Assert.assertTrue(text1.isDisplayed());
        Thread.sleep(1500);

        actions.moveToElement(ele2).build().perform();
        Assert.assertTrue(text2.isDisplayed());
        Thread.sleep(1500);

        actions.moveToElement(ele3).build().perform();
        Assert.assertTrue(text3.isDisplayed());
        Thread.sleep(1500);
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}