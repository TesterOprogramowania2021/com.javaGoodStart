//public class FileUploadTests {
//}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
    WebElement inputFile = driver.findElement(By.id("file-upload"));
    WebElement buttonFile = driver.findElement(By.id("file-submit"));
    inputFile.sendKeys("C:\\drivers\\testFile.jpeg");
    buttonFile.click();
    WebElement confir = driver.findElement(By.id("uploaded-files"));
    String confirmText = confir.getText();
    Thread.sleep(3000);
    assertEquals(confirmText,"testFile.jpeg");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}