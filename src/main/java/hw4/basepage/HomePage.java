package hw4.basepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class HomePage {

    private SelenideElement userIcon = element(By.id("user-icon"));

    private SelenideElement userNameInput = element(By.id("name"));

    private SelenideElement userPasswordInput = element(By.id("password"));

    private SelenideElement submitLoginButton = element(By.
            xpath("//button[@type='submit']"));

    private SelenideElement userNameLabel = element(By.id("user-name"));

    private SelenideElement logoutButton = element(By.className("logout"));

    private SelenideElement topServiceMenu = element(By.
            xpath("//a[@class='dropdown-toggle']"));

    private SelenideElement serviceMenu = element(By.
            xpath("//span[text()='Service']"));

    private ElementsCollection topServiceMenuItems = elements(By.
            xpath("//ul[@class='dropdown-menu']//a[@href]"));

    private ElementsCollection leftServiceMenuItems = elements(By.
            xpath("//ul[@class='sub']//li[@ui='label']"));

    private SelenideElement tableWithPages = element(By.
            xpath("//a[@href='table-pages.html']"));

    private SelenideElement metalsAndColors = element(By.
            xpath("//a[@href='metals-colors.html']"));

    public SelenideElement getUserNameLabel() {
        return userNameLabel;
    }

    public SelenideElement getTopServiceMenu() {
        return topServiceMenu;
    }

    public SelenideElement getServiceMenu() {
        return serviceMenu;
    }

    public ElementsCollection getTopServiceMenuItems() {
        return topServiceMenuItems;
    }

    public ElementsCollection getLeftServiceMenuItems() {
        return leftServiceMenuItems;
    }

    public SelenideElement getTableWithPages() {
        return tableWithPages;
    }

    public SelenideElement getMetalsAndColors() {
        return metalsAndColors;
    }

    public SelenideElement getPageTitle() {
        return element("title");
    }

    public void login(String userName, String userPass) {
        userIcon.click();
        userNameInput.sendKeys(userName);
        userPasswordInput.sendKeys(userPass);
        submitLoginButton.click();
    }

    public void logout() {
        userNameLabel.click();
        logoutButton.click();
    }
}

