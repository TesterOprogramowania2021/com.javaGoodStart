import base.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestDriver {



    @Test
    public void testFirst(){
        DriverManager.createInstance();
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wp.pl");
    }
}
