import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class WebElementsTests {

    private WebDriver driver;

    public void wait2(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }
    @Test
    public void typingIntoWebElementTest(){

        String userName = "Selenium start";
        WebElement inputUserName = driver.findElement(By.id("username"));
        inputUserName.sendKeys(userName);
        String valueUserField = inputUserName.getAttribute("value");
        assertEquals(userName , valueUserField);
    }
    @Test
    public void filePickingTest(){
        WebElement picUpFile = driver.findElement(By.id("upload_file"));
        picUpFile.sendKeys("C:/drivers/Face-smile.svg.png");
        wait2();
    }
    @Test
    public void typingAndClearingValueInsideWebElementTest(){
        String userName = "Selenium start";
        WebElement inputUserName = driver.findElement(By.id("username"));
        inputUserName.sendKeys(userName);
        wait2();

        String valueUserField = inputUserName.getAttribute("value");
        wait2();

        assertEquals(userName , valueUserField);
        wait2();
        inputUserName.clear();
        wait2();
        String valueUserField2 = inputUserName.getAttribute("value");
        assertEquals("",valueUserField2);

    }
    @Test
    public void checkRadioButtonTest(){
        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@value='male']"));
        WebElement genderRadioButtonFemale = driver.findElement(By.xpath("//input[@value='female']"));
        genderRadioButton.click();

        Assert.assertTrue(genderRadioButton.isSelected());
        genderRadioButtonFemale.click();
        Assert.assertTrue(genderRadioButtonFemale.isSelected());
        wait2();
    }
    @Test
    public void checkboxButtonTest(){
        WebElement pizza = driver.findElement(By.xpath("//input[@value='pizza']"));
        WebElement spaghetti = driver.findElement(By.xpath("//input[@value='spaghetti']"));
        WebElement hamburger = driver.findElement(By.xpath("//input[@value='hamburger']"));

        wait2();
        Assert.assertFalse(pizza.isSelected());
        Assert.assertFalse(spaghetti.isSelected());
        Assert.assertFalse(hamburger.isSelected());
        wait2();

        pizza.click();
        spaghetti.click();
        hamburger.click();

        wait2();
        Assert.assertTrue(pizza.isSelected());
        Assert.assertTrue(spaghetti.isSelected());
        Assert.assertTrue(hamburger.isSelected());



    }
    @Test
    public void dropDownListingTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<>();
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String>expectedNameOfOptions = new ArrayList<>();
        expectedNameOfOptions.add("Germany");
        expectedNameOfOptions.add("Poland");
        expectedNameOfOptions.add("UK");
        Assert.assertEquals(namesOfOptions,expectedNameOfOptions);
    }
    @Test
    public void selectingOptionsFromDropDownTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        wait2();
        countryDropDown.selectByIndex(1);
        wait2();
        Assert.assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Poland");
        wait2();
        countryDropDown.selectByValue("de_DE");
        wait2();
        Assert.assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Germany");
        countryDropDown.selectByVisibleText("UK");
        Assert.assertEquals(countryDropDown.getFirstSelectedOption().getText(),"UK");
        wait2();
    }
    @Test
    public void checkIfElementsOnPageTest(){

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());
    }
    @Test
    public void hoverOverAndClickAndHoldTest() {
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");

        WebElement smileyIcon = driver.findElement(By.id("smiley"));

        Actions action = new Actions(driver);

        action.moveToElement(smileyIcon).click().build().perform();

        wait2();

        Actions secondAction = new Actions(driver);
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        secondAction.clickAndHold(smileyIcon2).build().perform();

        wait2();
    }
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
