package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DifferentServices {

    private WebDriver driver;

    public DifferentServices(WebDriver wd) {
        driver = wd;
        PageFactory.initElements(driver, this);
    }

}


