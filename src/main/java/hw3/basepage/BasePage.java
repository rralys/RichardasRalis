package hw3.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver wd) {
        driver = wd;
        PageFactory.initElements(driver, this);
    }
}
