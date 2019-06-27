package hw3.steps;

import hw3.DifferentServices;
import hw3.enums.CheckBoxesToCheck;
import hw3.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DifferentServicesSteps {
    // TODO It could be extracted to the BaseStep class
    private WebDriver driver;

    // TODO It could be extracted to the BaseStep class
    private DifferentServices difServ;

    // TODO It could be extracted to the BaseStep class
    private FileUtils propertiesFile = new FileUtils();

    private ArrayList<String> checkBoxesToSelect = new ArrayList<>();


    public DifferentServicesSteps(WebDriver dr) {
        driver = dr;
        difServ = PageFactory.initElements(driver, DifferentServices.class);
    }

    public void verifyDifferentElementsPageTitle() {
        assertEquals(driver.getTitle(),
                propertiesFile.readPageTitleFromFile().getProperty("different.elements.title"));
    }

    public void verifyDifferentElementsPageItems() {

        assertEquals(difServ.getNumberOfCheckBoxes(),
                Integer.parseInt(
                        propertiesFile.readElementsCountsFromFile().
                                getProperty("check.boxes.count")));

        assertEquals(difServ.getNumberOfRadioButtons(),
                Integer.parseInt(
                        propertiesFile.readElementsCountsFromFile()
                                .getProperty("radiobuttons.count")
                ));

        assertEquals(difServ.getNumberOfDropDowns(),
                Integer.parseInt(
                        propertiesFile.readElementsCountsFromFile()
                                .getProperty("dropdowns.count")
                ));

        assertEquals(difServ.getNumberOfButtons(),
                Integer.parseInt(
                        propertiesFile.readElementsCountsFromFile().
                                getProperty("buttons.count")));


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

        difServ.setRadioButton(propertiesFile.readRadioButtonToSelectFromFile().
                getProperty("radiobutton"));
    }

    public void verifyLogCorrespondsToRadioButtonSelected() {

       assertTrue( difServ.isLogUpdatedForRadioButton(propertiesFile.
               readRadioButtonToSelectFromFile().
               getProperty("radiobutton")));

    }

    public void setDropDownValue() {
        difServ.setColorDropDown(propertiesFile.readDropdownItemToSelectFromFile()
                .getProperty("dropdown.selected"));
    }

    public void verifyLogCorrespondsToDropdownItemSelected() {
        assertTrue(difServ.isLogUpdatedForDropdown(propertiesFile.
                readDropdownItemToSelectFromFile()
                .getProperty("dropdown.selected")));
    }

}
