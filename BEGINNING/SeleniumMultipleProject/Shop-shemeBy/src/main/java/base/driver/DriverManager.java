package base.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.lang.reflect.Field;

public class DriverManager {

    private static final  ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return webdriver.get();
    }
    public static void setWebdriver(WebDriver driver){
        webdriver.set(driver);
    }
    public static void createInstance(){

        setWebdriver(DriverFactory.createWebdriverInstance("firefox"));
    }
}
