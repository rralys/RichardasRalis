package hw4.basepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class HomePage {

    private static SelenideElement userIcon = element(By.id("user-icon"));

    private static SelenideElement userNameInput = element(By.id("name"));

    private static SelenideElement userPasswordInput = element(By.id("password"));

    private static SelenideElement submitLoginButton = element(By.
            xpath("//button[@type='submit']"));

    private static SelenideElement userNameLabel = element(By.id("user-name"));

    private static SelenideElement topServiceMenu = element(By.
            xpath("//a[@class='dropdown-toggle']"));

    private static SelenideElement serviceMenu = element(By.
            xpath("//span[text()='Service']"));

    private static ElementsCollection topServiceMenuItems = elements(By.
            xpath("//ul[@class='dropdown-menu']//a[@href]"));

    private static ElementsCollection leftServiceMenuItems = elements(By.
            xpath("//ul[@class='sub']//li[@ui='label']"));

    private static SelenideElement tableWithPages = element(By.
            linkText("table-pages.html"));

    public static SelenideElement getUserNameLabel() {
        return userNameLabel;
    }

    public static SelenideElement getTopServiceMenu() {
        return topServiceMenu;
    }

    public static SelenideElement getServiceMenu() {
        return serviceMenu;
    }

    public static ElementsCollection getTopServiceMenuItems() {
        return topServiceMenuItems;
    }

    public static ElementsCollection getLeftServiceMenuItems() {
        return leftServiceMenuItems;
    }

    public static SelenideElement getTableWithPages() {
        return tableWithPages;
    }

    public static void login(String userName, String userPass) {
        userIcon.click();
        userNameInput.sendKeys(userName);
        userPasswordInput.sendKeys(userPass);
        submitLoginButton.click();
    }
}

