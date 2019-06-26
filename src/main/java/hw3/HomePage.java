package hw3;

import hw3.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver dr) {
        driver = dr;
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//span[text()='Service']")
    private WebElement serviceMenu;

    @FindBy (tagName = "iframe")
    private WebElement iframe;

    @FindBy (id = "epam_logo")
    private WebElement epamLogo;

    @FindBy (xpath = "//h3[@class='text-center']/a")
    private WebElement subHeader;

    @FindBy (name = "navigation-sidebar")
    private WebElement leftSection;

    @FindBy (tagName = "footer")
    private WebElement footer;

    @FindAll({
           @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href]")
    })
    List<WebElement> topServiceMenuItems;

    @FindAll({
            @FindBy(xpath = "//ul[@class='sub']//li[@ui='label']")
    })
    List<WebElement> leftSideMenuItems;

    public void login(String uName, String uPass) {
        userIcon.click();
        userNameInput.sendKeys(uName);
        userPasswordInput.sendKeys(uPass);
        submitLoginButton.click();
    }

    public String getUserName() {
        return userNameLabel.getText().trim();
    }

    public void clickServiceItemInHeader() {
        String topPanelItem = TopPanelMenuXpathes.valueOf("SERVICE").getTopPanelMenuItemXpath();
        driver.findElement(By.xpath(topPanelItem)).click();
    }

    public void clickServiceMenu() {
        serviceMenu.click();
    }

    public String getTopPanelMenuItemElementLabel(TopPanelMenuXpathes topPanelItem) {
        return driver.findElement(By.xpath(topPanelItem.getTopPanelMenuItemXpath())).getText().trim();
    }

    public boolean isHeaderSectionImageVisible(HeaderSectionImagesXpathes imageItem) {
        return driver.findElement(By.xpath(imageItem.getHeaderSectionImageXpath())).isDisplayed();
    }

    public String getHeaderSectionTextActualLabel(HeaderSectionTextsXpathes textItem) {
        return driver.findElement(By.xpath(textItem.getHeaderSectionTextXpath())).getText().trim();

    }

    public String getMainHeaderTextActualLabel(MainHeaderTextXpathes headerItem) {
        return driver.findElement(By.xpath(headerItem.getMainHeaderTextXpath())).getText().trim();
    }

    public boolean isIframePresent() {
        return iframe.isDisplayed();
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }

    public boolean isLogoDisplayed() {
        return epamLogo.isDisplayed();
    }

    public void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public String getSubHeaderLabel() {
        return subHeader.getText().trim();
    }

    public String getSubHeaderLink() {
        return subHeader.getAttribute("href");
    }

    public boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }

    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    public ArrayList<String> getServiceMenuItemsLabels() {

        ArrayList<String> serviceMenuItemsLabels = new ArrayList<>();

        for(WebElement element : topServiceMenuItems) {
            serviceMenuItemsLabels.add(element.getText().trim());
        }

        return serviceMenuItemsLabels;

    }

    public ArrayList<String> getLeftServiceMenuItemsLabels() {

        ArrayList<String> serviceMenuItemsLabels = new ArrayList<>();

        for(WebElement element : leftSideMenuItems) {
            serviceMenuItemsLabels.add(element.getText().trim());
        }

        return serviceMenuItemsLabels;

    }


    public void clickTopPanelServicesMenuItem(ServicesTopPanelMenu item) {
        driver.findElement(By.xpath(item.getTopPanelMenuItem())).click();
    }
}
