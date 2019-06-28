package hw3.steps;

import hw3.basepage.DifferentServices;
import hw3.enums.CheckBoxesToCheck;
import hw3.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DifferentServicesSteps extends BaseSteps{

    private ArrayList<String> checkBoxesToSelect = new ArrayList<>();


    public DifferentServicesSteps(WebDriver dr) {
        driver = dr;
        difServ = PageFactory.initElements(driver, DifferentServices.class);
    }

    public void verifyDifferentElementsPageTitle() {

        assertEquals(driver.getTitle(),
                FileUtils.readPropertiesFile(propertiesPath + "/pageTitles.properties")
                        .getProperty("different.elements.title"));

    }

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

    public void verifyRightSectionIsVisible() {
        assertTrue(difServ.isRightSectionVisible());
    }

    public void verifyLeftSectionIsVisible() {
        assertTrue(difServ.isLeftSectionVisible());
    }

    public void selectCheckBoxesAndVerifyChecked() {

        for (CheckBoxesToCheck item : CheckBoxesToCheck.values()) {
            checkBoxesToSelect.add(item.getCheckBoxLabel());
        }

        difServ.selectListOfCheckBoxes(checkBoxesToSelect);

        assertTrue(difServ.isListOfCheckBoxesSelected(checkBoxesToSelect));
    }

    public void deselectCheckBoxesAndVerifyUnchecked() {
        difServ.selectListOfCheckBoxes(checkBoxesToSelect);
        assertFalse(difServ.isListOfCheckBoxesSelected(checkBoxesToSelect));
    }

    public void verifyLogCorrespondsToStateOfCheckBoxes(boolean status) {

        assertTrue(difServ.isLogUpdatedForListOfCheckBoxes(checkBoxesToSelect, status));
    }

    public void selectRadioButton() {

        difServ.setRadioButton(FileUtils.readPropertiesFile(propertiesPath + "/radiobutton.properties")
        .getProperty("radiobutton"));

    }

    public void verifyLogCorrespondsToRadioButtonSelected() {

       assertTrue( difServ.isLogUpdatedForRadioButton(FileUtils
               .readPropertiesFile(propertiesPath + "/radiobutton.properties")
               .getProperty("radiobutton")));

    }

    public void setDropDownValue() {

        difServ.setColorDropDown(FileUtils
                .readPropertiesFile(propertiesPath + "/dropdown.properties")
                .getProperty("dropdown.selected"));
    }

    public void verifyLogCorrespondsToDropdownItemSelected() {
        assertTrue(difServ.isLogUpdatedForDropdown(FileUtils
                .readPropertiesFile(propertiesPath + "/dropdown.properties")
                .getProperty("dropdown.selected")));
    }

}
