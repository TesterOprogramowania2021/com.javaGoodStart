package pages.shopify;

import base.utils.Button;
import base.utils.InputTextBox;
import org.openqa.selenium.By;

public class HomePage {
    InputTextBox searchField;
    Button searchButton;

    public HomePage(){
        searchField = new InputTextBox(By.name("q"));
    }

}
