package hw3;

import hw3.steps.DifferentServicesSteps;
import hw3.steps.HomePageSteps;
import org.testng.annotations.Test;

public class TestForExercise2 extends RunTestsForHomework3 {
    @Test
    public void TestScenario2() {
        HomePageSteps hps = new HomePageSteps(driver);
        DifferentServicesSteps ds = new DifferentServicesSteps(driver);
        hps.verifyHomePageTitle();
        hps.loginToHomePage();
        hps.verifyUserName();
        hps.clickServiceSubcategoryInHeader();
        hps.serviceDropdownHasCorrectOptions();
        hps.clickServiceSubcategoryInLeftSection();
        hps.serviceMenuInLeftSectionHasCorrectOptions();
        hps.openDifferentElementsPageViaTopServiceMenu();
        ds.verifyDifferentElementsPageTitle();
        ds.verifyDifferentElementsPageItems();
        ds.verifyRightSectionIsVisible();
        ds.verifyLeftSectionIsVisible();
        ds.selectCheckBoxesAndVerifyChecked();
        ds.verifyLogCorrespondsToStateOfCheckBoxes(true);
        ds.selectRadioButton();
        ds.verifyLogCorrespondsToRadioButtonSelected();
        ds.setDropDownValue();
        ds.verifyLogCorrespondsToDropdownItemSelected();
        ds.deselectCheckBoxesAndVerifyUnchecked();
        ds.verifyLogCorrespondsToStateOfCheckBoxes(false);
    }
}
