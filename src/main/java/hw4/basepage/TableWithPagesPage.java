package hw4.basepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;
// TODO Why this Page has only static member?
// TODO Did you have a chance to read requirements of the home task?
public class TableWithPagesPage {

    private static SelenideElement showEntriesDropdown = element(By.
            name("table-with-pages_length"));

    private static SelenideElement rightSection = element(By.name("log-sidebar"));

    private static SelenideElement leftSection = element(By.name("navigation-sidebar"));

    private static SelenideElement logSection = element(By.className("info-panel-section"));

    private static ElementsCollection tableElements = elements(By.xpath("//tbody/tr[@role='row']"));

    private static SelenideElement inputSearch = element(By.xpath("//input[@type='search']"));

    public static SelenideElement getShowEntriesDropdown() {
        return showEntriesDropdown;
    }

    public static void setShowEntriesDropdown(String value) {
        showEntriesDropdown.selectOptionByValue(value);
    }

    public static SelenideElement getRightSection() {
        return rightSection;
    }

    public static SelenideElement getLeftSection() {
        return leftSection;
    }

    public static SelenideElement getLogSection() {
        return logSection;
    }

    public static ElementsCollection getTableElements() {
        return tableElements;
    }

    public static void setInputSearch(String input) {
        inputSearch.sendKeys(input);
    }
}
