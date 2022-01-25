import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SelectorsAutomatedTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void mySecondTest() {
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
        driver.findElement(By.id("LogoContent"));
        driver.findElement(By.name("img_cart"));
//        driver.findElement(By.xpath("//a[@href='/jpetstore/actions/Account.action?signonForm=']"));
        driver.findElement(By.xpath("//a[@href='../help.html']"));
        driver.findElement(By.name("keyword"));
        driver.findElement(By.xpath("(//div[@id='QuickLinks']/a)[1]"));
        driver.findElement(By.xpath("(//div[@id='QuickLinks']/a)[2]"));
        driver.findElement(By.xpath("(//div[@id='QuickLinks']/a)[3]"));
        driver.findElement(By.xpath("(//div[@id='QuickLinks']/a)[4]"));
        driver.findElement(By.xpath("(//div[@id='QuickLinks']/a)[5]"));

        driver.findElement(By.xpath("(//div[@id='SidebarContent']/a)[1]"));
        driver.findElement(By.xpath("(//div[@id='SidebarContent']/a)[2]"));
        driver.findElement(By.xpath("(//div[@id='SidebarContent']/a)[3]"));
        driver.findElement(By.xpath("(//div[@id='SidebarContent']/a)[4]"));
        driver.findElement(By.xpath("(//div[@id='SidebarContent']/a)[5]"));
        driver.findElement(By.id("MainImageContent"));
        driver.findElement(By.xpath("//div[@id='PoweredBy']/a"));

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}