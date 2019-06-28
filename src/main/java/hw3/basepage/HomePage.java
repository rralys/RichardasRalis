package hw3.basepage;

import hw3.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    // TODO Could be extracted to thew BasePage class — Done.

    // TODO Could be extracted to thew BasePage class — Done.
    public HomePage(WebDriver dr) {
        super(dr);
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

    @FindAll({
            @FindBy(className = "benefit-icon")
    })
    List<WebElement> headerImages;

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

    public List<String> getTopPanelMenuItemsLabelsAsList(List<String> xpathes) {
        List<String> topPanelMenuItemsLabels = new ArrayList<>();

        for (String xpath : xpathes) {
            topPanelMenuItemsLabels.add(driver.findElement(By.xpath(xpath)).getText().trim());
        }

        return topPanelMenuItemsLabels;
    }

    public int getNumberOfHeaderImages() {
        return headerImages.size();
    }

    public boolean isHeaderSectionImageVisible(HeaderSectionImagesXpathes imageItem) {
        return driver.findElement(By.xpath(imageItem.getHeaderSectionImageXpath())).isDisplayed();
    }

    public List<String> getHeaderSectionTextActualLabels(List<String> textXpathes) {
        List<String> actualLabels = new ArrayList<>();

        for (String xpath : textXpathes) {
            actualLabels.add(driver.findElement(By.xpath(xpath)).getText().trim());
        }

        return actualLabels;
    }

    public String getMainHeaderTextActualLabel(MainHeaderTextXpathes headerItem) {
        return driver.findElement(By.xpath(headerItem.getMainHeaderTextXpath())).getText().trim();
    }

    public List<String> getMainHeaderTextActualLabels(List<String> headerTextXpathes) {
        List<String> actualTextLabels = new ArrayList<>();

        for (String xpath : headerTextXpathes) {
            actualTextLabels.add(driver.findElement(By.xpath(xpath)).getText().trim());
        }

        return actualTextLabels;
    }

    // TODO isIFramePresent — Fixed.
    public boolean isIFramePresent() {
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
