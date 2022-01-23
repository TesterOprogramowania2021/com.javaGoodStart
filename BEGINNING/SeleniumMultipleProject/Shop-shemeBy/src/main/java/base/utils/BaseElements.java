package base.utils;

import base.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseElements {

    WebDriver driver = DriverManager.getDriver();

    WebDriverWait wait = new WebDriverWait(driver,10);
    By locator;

    protected BaseElements(By locator) {
        this.locator = locator;
    }
    protected WebElement waitUntilVisibleBase(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitUntilClicableBase(){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement waitUnitlPresentedBase(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected void sendTextBase(String text){
        waitUntilVisibleBase().clear();
        waitUntilVisibleBase().sendKeys(text);
    }
    protected void clickOnElementBase(){
        waitUntilClicableBase().click();
    }
}
