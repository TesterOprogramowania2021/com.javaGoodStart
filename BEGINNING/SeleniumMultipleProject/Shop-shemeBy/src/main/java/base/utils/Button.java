package base.utils;

import org.openqa.selenium.By;

public class Button extends BaseElements{
    protected Button(By locator) {
        super(locator);
    }

    public void clickOnElement(){
        clickOnElementBase();
    }
}
