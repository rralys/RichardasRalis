package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static HomePage instance;

    public HomePage(WebDriver dr) {
        super(dr);
    }

    public static HomePage getInstance(WebDriver dr) {
        if ((instance == null) || (instance.driver != null)) {
            instance = new HomePage(dr);
        }

        return instance;
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement userPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitLoginButton;

    @FindBy(id = "user-name")
    private WebElement userNameLabel;

    @FindAll({
            @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href]")
    })
    List<WebElement> topServiceMenuItems;

    @FindAll({
            @FindBy(xpath = "//ul[@class='sub']//li[@ui='label']")
    })
    List<WebElement> leftSideMenuItems;

    @FindAll({
            @FindBy(className = "benefit-icon")
    })
    List<WebElement> headerImages;

    @FindAll({
            @FindBy(className = "benefit-txt")
    })
    List<WebElement> labelsBelowImages;

    @FindAll({
            @FindBy(xpath = "//h3[@name='main-title']"),
            @FindBy(xpath = "//p[@name='jdi-text']")
    })
    List<WebElement> headerLabels;

    @FindBy(xpath = "//ul[@role='menu']//a[@href='different-elements.html']")
    WebElement differentElementsLink;

    public void login(String uName, String uPass) {
        userIcon.click();
        userNameInput.sendKeys(uName);
        userPasswordInput.sendKeys(uPass);
        submitLoginButton.click();
    }

    public String getUserName() {
        return userNameLabel.getText().trim();
    }

    public int getNumberOfHeaderImages() {
        return headerImages.size();
    }

    public int getNumberOfLabelsBelowPictures() {
        return labelsBelowImages.size();
    }

    public int getNumberOfHeaderLabels() {
        return headerLabels.size();
    }

    public void clickTopMenuItem(String itemLabel) {
        driver.findElement(By.xpath("//a[contains(text(),'" + itemLabel + "')]")).click();
    }

    public void clickLeftMenuItem(String itemLabel) {
        driver.findElement(By.xpath("//span[text()='" + itemLabel + "']")).click();
    }

    public void clickDifferentElementsMenuItem() {
        differentElementsLink.click();
    }

    public ArrayList<String> getServiceMenuItemsLabels() {

        ArrayList<String> serviceMenuItemsLabels = new ArrayList<>();

        for (WebElement element : topServiceMenuItems) {
            serviceMenuItemsLabels.add(element.getText().trim());
        }

        return serviceMenuItemsLabels;

    }

    public ArrayList<String> getLeftServiceMenuItemsLabels() {

        ArrayList<String> serviceMenuItemsLabels = new ArrayList<>();

        for (WebElement element : leftSideMenuItems) {
            serviceMenuItemsLabels.add(element.getText().trim());
        }

        return serviceMenuItemsLabels;

    }

}
