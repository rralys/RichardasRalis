package hw4.basepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Elements;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class MetalsAndColorsPage {
    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();

    private ElementsCollection elementsCheckbox = elements(By
            .xpath("//section[@id='elements-checklist']//label"));

    private SelenideElement colorsDropdown = element(By
            .id("colors"));

    private SelenideElement metalsDropdown = element(By
            .xpath("//div[@id='metals']/input"));

    private SelenideElement vegetablesDropdown = element(By
            .id("vegetables"));

    private SelenideElement submitButton = element(By
            .id("submit-button"));

    private SelenideElement summaryLog = element(By
            .className("summ-res"));

    private SelenideElement elementsLog = element(By
            .className("elem-res"));

    private SelenideElement colorLog = element(By
            .className("col-res"));

    private SelenideElement metalLog = element(By
            .className("met-res"));

    private SelenideElement vegetablesLog = element(By
            .className("sal-res"));

    public void setSummary(List<String> labels) {
        if (labels == null) {
            return;
        }
        for (String label : labels) {
            element(By.xpath("//label[text()='" + label + "']")).click();
        }
    }

    public void setElementsCheckbox(List<Elements> elementsList) {
        if (elementsList == null) {
            return;
        }

        for (SelenideElement elementCheckbox : elementsCheckbox) {
            for (Elements elementItem : elementsList) {
                if (elementCheckbox.text().equals(elementItem.getElementValue())) {
                    elementCheckbox.click();
                }
            }
        }
    }

    public void setColorsDropdown(String color) {
        if (color == null) {
            return;
        }

        colorsDropdown.click();
        element(By.xpath("//span[text()='" + color + "']")).click();
    }

    public void setMetalsDropdown(String metal) {
        if (metal == null) {
            return;
        }

        metalsDropdown.clear();
        metalsDropdown.sendKeys(metal);
    }

    public void setVegetablesDropdown(List<String> vegs) {
        vegetablesDropdown.click();
        element(By.xpath("//label[text()='Vegetables']")).click();
        vegetablesDropdown.click();
        for (String veg : vegs) {
            element(By.xpath("//label[text()='" + veg + "']")).click();
        }
    }

    public void submitClick() {
        submitButton.click();
    }

    public SelenideElement getSummaryLog() {
        return summaryLog;
    }

    public SelenideElement getElementsLog() {
        return elementsLog;
    }

    public SelenideElement getColorLog() {
        return colorLog;
    }

    public SelenideElement getMetalLog() {
        return metalLog;
    }

    public SelenideElement getVegetablesLog() {
        return vegetablesLog;
    }
}
