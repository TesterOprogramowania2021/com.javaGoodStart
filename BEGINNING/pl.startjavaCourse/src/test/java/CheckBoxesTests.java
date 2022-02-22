//public class CheckBoxesTests {
//}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckBoxesTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkboxesTest() throws InterruptedException {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[2]"));

        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());

        checkbox1.click();
        checkbox2.click();
         Thread.sleep(2000);

         Assert.assertTrue(checkbox1.isSelected());
         Assert.assertFalse(checkbox2.isSelected());
        Thread.sleep(2000);

    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}