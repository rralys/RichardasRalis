package hw3;

import hw3.enums.ServicesLeftSidePanelMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver dr) {
        driver = dr;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "user-icon")
    private WebElement userIcon;

    @FindBy (id = "name")
    private WebElement userNameInput;

    @FindBy (id = "password")
    private WebElement userPasswordInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement submitLoginButton;

    @FindBy (id = "user-name")
    private WebElement userNameLabel;

    @FindBy (xpath = "//span[text()='Service']")
    private WebElement serviceMenu;

    public void login(String uName, String uPass) {
        userIcon.click();
        userNameInput.sendKeys(uName);
        userPasswordInput.sendKeys(uPass);
        submitLoginButton.click();
    }

    public void clickServiceMenu() {
     serviceMenu.click();
    }

    public void clickLeftSideServicesMenuItem(ServicesLeftSidePanelMenu item) {
        driver.findElement(By.xpath(item.getLeftSidePanelMenuItem())).click();
    }
}
