package hw4.basepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class TableWithPagesPage {

    private SelenideElement showEntriesDropdown = element(By.
            name("table-with-pages_length"));

    private SelenideElement rightSection = element(By.name("log-sidebar"));

    private SelenideElement leftSection = element(By.name("navigation-sidebar"));

    private SelenideElement logSection = element(By.className("info-panel-section"));

    private ElementsCollection tableElements = elements(By.xpath("//tbody/tr[@role='row']"));

    private SelenideElement inputSearch = element(By.xpath("//input[@type='search']"));

    public SelenideElement getShowEntriesDropdown() {
        return showEntriesDropdown;
    }

    public void setShowEntriesDropdown(String value) {
        showEntriesDropdown.selectOptionByValue(value);
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public SelenideElement getLogSection() {
        return logSection;
    }

    public ElementsCollection getTableElements() {
        return tableElements;
    }

    public void setInputSearch(String input) {
        inputSearch.sendKeys(input);
    }
}
