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

    @FindBy (xpath = "//img[@id='user-icon']")
    private WebElement userIcon;

    @FindBy (xpath = "//input[@id='name']")
    private WebElement userNameInput;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement userPasswordInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement submitLoginButton;

    @FindBy (xpath = "//span[@id='user-name']")
    private WebElement userNameLabel;

    public void login(String uName, String uPass) {
        userIcon.click();
        userNameInput.sendKeys(uName);
        userPasswordInput.sendKeys(uPass);
        submitLoginButton.click();
    }

    public void clickLeftSideServicesMenuItem(ServicesLeftSidePanelMenu item) {
        driver.findElement(By.xpath(item.getLeftSidePanelMenuItem())).click();
    }
}
