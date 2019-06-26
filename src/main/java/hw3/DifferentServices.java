package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentServices {

    private WebDriver driver;

    public DifferentServices(WebDriver wd) {
        driver = wd;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(className = "label-checkbox")
    })
    List<WebElement> checkboxes;

    @FindAll({
            @FindBy(className = "label-radio")
    })
    List<WebElement> radioButtons;

    @FindAll({
            @FindBy(xpath = "//select[@class='uui-form-element']")
    })
    List<WebElement> dropDowns;

    @FindAll({
            @FindBy(xpath = "//*[contains(@value, 'Button')]")
    })
    List<WebElement> buttons;

    @FindBy(name = "log-sidebar")
    WebElement rightSection;

    @FindBy(name = "navigation-sidebar")
    WebElement leftSection;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    WebElement colorDropdown;

    public int getNumberOfCheckBoxes() {
        return checkboxes.size();
    }

    public int getNumberOfRadioButtons() {
        return radioButtons.size();
    }

    public int getNumberOfDropDowns() {
        return dropDowns.size();
    }

    public int getNumberOfButtons() {
        return buttons.size();
    }

    public boolean isRightSectionVisible() {
        return rightSection.isDisplayed();
    }

    public boolean isLeftSectionVisible() {
        return leftSection.isDisplayed();
    }

    public void selectCheckBox(String checkboxLabel) {
        String xpath = "//label[text()[contains(.,'" + checkboxLabel + "')]]";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void selectListOfCheckBoxes(List<String> checkboxes) {
        for (String item : checkboxes) {
            selectCheckBox(item);
        }
    }

    public boolean isCheckboxSelected(String checkboxLabel) {
        String xpath = "//label[text()[contains(.,'" + checkboxLabel + "')]]" +
                "//descendant-or-self::input[@type='checkbox']";

        return driver.findElement(By.xpath(xpath)).isSelected();
    }

    public boolean isListOfCheckBoxesSelected(List<String> checkboxes) {
        boolean areAllSelected = true;
        for (String item : checkboxes) {
            areAllSelected = areAllSelected && isCheckboxSelected(item);
        }

        return areAllSelected;
    }

    public boolean isLogUpdatedForCheckBox(String checkBoxName, boolean state) {
        return driver.findElement(By.xpath("//li[text()[contains(.,'" + checkBoxName +
                ": condition changed to " + String.valueOf(state) +"')]]")).isDisplayed();
    }

    public boolean isLogUpdatedForListOfCheckBoxes(List<String> checkboxes, boolean state) {
        boolean isUpdated = true;
        for (String item : checkboxes) {
            isUpdated = isUpdated && isLogUpdatedForCheckBox(item, state);
        }

        return isUpdated;
    }

    public void setRadioButton(String item) {

        driver.findElement(By.xpath("//label[contains(.,'"+item+"')]")).click();

    }

    public boolean isLogUpdatedForRadioButton(String radio) {
        return driver.findElement(By.xpath("//li[text()[contains(.,'metal: value changed to  " + radio + "')]]")).isDisplayed();
    }

    public void setColorDropDown(String item) {
        new Select(colorDropdown).selectByVisibleText(item);
    }

    public boolean isLogUpdatedForDropdown(String item) {
        return driver.findElement(By.xpath("//li[text()[contains(.,'Colors: value changed to " + item + "')]]")).isDisplayed();
    }
}


