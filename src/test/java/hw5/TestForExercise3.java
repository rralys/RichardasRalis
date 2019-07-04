package hw5;

import hw5.steps.DifferentServicesSteps;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class TestForExercise3 extends RunTestsForHomework5 {

    @Feature("JDI site workflows.")
    @Story("JDI Different elements page.")
    @Test
    public void TestScenario3() {
        HomePageSteps hps = new HomePageSteps(driver);
        DifferentServicesSteps ds = new DifferentServicesSteps(driver);
        hps.verifyHomePageTitle();
        hps.loginToHomePage(uName, uPass);
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
