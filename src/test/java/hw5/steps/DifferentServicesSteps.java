package hw5.steps;

import hw5.DifferentServices;
import hw5.enums.CheckBoxesToCheck;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.FileUtils;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class DifferentServicesSteps extends BaseSteps {

    private ArrayList<String> checkBoxesToSelect = new ArrayList<>();


    public DifferentServicesSteps(WebDriver dr) {
        driver = dr;
        difServ = PageFactory.initElements(driver, DifferentServices.class);
    }

    @Step("Check the title of the Different elements page.")
    public void verifyDifferentElementsPageTitle() {

        assertEquals(driver.getTitle(),
                FileUtils.readPropertiesFile(propertiesPath + "/pageTitles.properties")
                        .getProperty("different.elements.title"));

    }

    @Step("Check page elements present in the page.")
    public void verifyDifferentElementsPageItems() {

        assertEquals(difServ.getNumberOfCheckBoxes(),
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/elements.properties")
                        .getProperty("check.boxes.count")));

        assertEquals(difServ.getNumberOfRadioButtons(),
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/elements.properties")
                                .getProperty("radiobuttons.count")
                ));

        assertEquals(difServ.getNumberOfDropDowns(),
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/elements.properties")
                                .getProperty("dropdowns.count")
                ));

        assertEquals(difServ.getNumberOfButtons(),
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/elements.properties")
                                .getProperty("buttons.count")));


    }

    @Step("Check the right section in the page.")
    public void verifyRightSectionIsVisible() {
        assertTrue(difServ.isRightSectionVisible());
    }

    @Step("Check the left section in the page.")
    public void verifyLeftSectionIsVisible() {
        assertTrue(difServ.isLeftSectionVisible());
    }

    @Step("Set checkboxes and verify their state.")
    public void selectCheckBoxesAndVerifyChecked() {

        for (CheckBoxesToCheck item : CheckBoxesToCheck.values()) {
            checkBoxesToSelect.add(item.getCheckBoxLabel());
        }

        difServ.selectListOfCheckBoxes(checkBoxesToSelect);

        assertTrue(difServ.isListOfCheckBoxesSelected(checkBoxesToSelect));
    }

    @Step("Un-set the checkboxes and verify their state.")
    public void deselectCheckBoxesAndVerifyUnchecked() {
        difServ.selectListOfCheckBoxes(checkBoxesToSelect);
        assertFalse(difServ.isListOfCheckBoxesSelected(checkBoxesToSelect));
    }

    @Step("Check the log records.")
    public void verifyLogCorrespondsToStateOfCheckBoxes(boolean status) {

        assertTrue(difServ.isLogUpdatedForListOfCheckBoxes(checkBoxesToSelect, status));
    }

    @Step("Select radiobutton.")
    public void selectRadioButton() {

        difServ.setRadioButton(FileUtils.readPropertiesFile(propertiesPath + "/radiobutton.properties")
        .getProperty("radiobutton"));

    }

    @Step("Check the log state.")
    public void verifyLogCorrespondsToRadioButtonSelected() {

       assertTrue( difServ.isLogUpdatedForRadioButton(FileUtils
               .readPropertiesFile(propertiesPath + "/radiobutton.properties")
               .getProperty("radiobutton")));

    }

    @Step("Select dropdown value.")
    public void setDropDownValue() {

        difServ.setColorDropDown(FileUtils
                .readPropertiesFile(propertiesPath + "/dropdown.properties")
                .getProperty("dropdown.selected"));
    }

    @Step("Check the log state.")
    public void verifyLogCorrespondsToDropdownItemSelected() {
        assertTrue(difServ.isLogUpdatedForDropdown(FileUtils
                .readPropertiesFile(propertiesPath + "/dropdown.properties")
                .getProperty("dropdown.selected")));
    }

}
