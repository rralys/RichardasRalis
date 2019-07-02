package hw4.basepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Elements;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

// TODO Why this Page has only static member?
// TODO Did you have a chance to read requirements of the home task?
public class MetalsAndColorsPage {
    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();

    private static ElementsCollection elementsCheckbox = elements(By
            .xpath("//section[@id='elements-checklist']//label"));

    private static SelenideElement colorsDropdown = element(By
            .id("colors"));

    private static SelenideElement metalsDropdown = element(By
            .xpath("//div[@id='metals']/input"));

    private static SelenideElement vegetablesDropdown = element(By
            .id("vegetables"));

    private static SelenideElement submitButton = element(By
            .id("submit-button"));

    private static SelenideElement summaryLog = element(By
            .className("summ-res"));

    private static SelenideElement elementsLog = element(By
            .className("elem-res"));

    private static SelenideElement colorLog = element(By
            .className("col-res"));

    private static SelenideElement metalLog = element(By
            .className("met-res"));

    private static SelenideElement vegetablesLog = element(By
            .className("sal-res"));

    public static void setSummary(List<String> labels) {
        if (labels == null) {
            return;
        }
        for (String label : labels) {
            element(By.xpath("//label[text()='" + label + "']")).click();
        }
    }

    public static void setElementsCheckbox(List<Elements> elementsList) {
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

    public static void setColorsDropdown(String color) {
        if (color == null) {
            return;
        }

        colorsDropdown.click();
        element(By.xpath("//span[text()='" + color + "']")).click();
    }

    public static void setMetalsDropdown(String metal) {
        if (metal == null) {
            return;
        }

        metalsDropdown.clear();
        metalsDropdown.sendKeys(metal);
    }

    public static void setVegetablesDropdown(List<String> vegs) {
        vegetablesDropdown.click();
        element(By.xpath("//label[text()='Vegetables']")).click();
        vegetablesDropdown.click();
        for (String veg : vegs) {
            element(By.xpath("//label[text()='" + veg + "']")).click();
        }
    }

    public static void submitClick() {
        submitButton.click();
    }

    public static SelenideElement getSummaryLog() {
        return summaryLog;
    }

    public static SelenideElement getElementsLog() {
        return elementsLog;
    }

    public static SelenideElement getColorLog() {
        return colorLog;
    }

    public static SelenideElement getMetalLog() {
        return metalLog;
    }

    public static SelenideElement getVegetablesLog() {
        return vegetablesLog;
    }
}
