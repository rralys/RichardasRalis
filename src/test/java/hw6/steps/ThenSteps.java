package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.hooks.TestContext;
import hw6.users.UserElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hw6.users.UserElementList.getDescriptionsList;
import static hw6.users.UserElementList.getIDsList;
import static hw6.users.UserElementList.getNamesList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps extends BaseStep {

    @Then("The index page has the '(.*)' title")
    public void verifyHomePageTitle(String expectedTitle) {
        assertEquals(TestContext.getDriver().getTitle(), expectedTitle);
    }

    @Then("User name should be '(.*)'")
    public void verifyUserName(String userName) {
        assertEquals(hp.getUserName(), userName);
    }

    @Then("Home Page contains '(.+)' pictures")
    public void verifyThePresentPictures(int pics) {
        assertEquals(hp.getNumberOfHeaderImages(), pics);
    }

    @Then("Home Page contains '(.+)' text labels under the pictures")
    public void verifyThePresentLabelsUnderPictures(int labels) {
        assertEquals(hp.getNumberOfLabelsBelowPictures(), labels);
    }

    @Then("Home Page contains '(.+)' text labels above the pictures")
    public void verifyLabelsAbovePictures(int labels) {
        assertEquals(hp.getNumberOfHeaderLabels(), labels);
    }

    @Then("Top service menu contains the following items")
    public void verifyTheTopServiceMenuItems(List<String> expectedItems) {
        assertEquals(hp.getServiceMenuItemsLabels(), expectedItems);
    }

    @Then("The left service menu contains the following items")
    public void verifyTheLeftServicemenuItems(List<String> expectedItems) {
        assertEquals(hp.getLeftServiceMenuItemsLabels(), expectedItems);
    }

    @Then("The page has '(.*)' title")
    public void verifyDifferentElementsPageTitle(String expectedTitle) {
        assertEquals(TestContext.getDriver().getTitle(), expectedTitle);
    }

    @Then("The Different Elements page contains '(.*)' checkboxes")
    public void verifyTheNumberOfCheckboxes(int checkboxes) {
        assertEquals(dsp.getNumberOfCheckBoxes(), checkboxes);
    }

    @Then("The Different Elements page contains '(.*)' radio buttons")
    public void verifyTheNumberOfRadioButtons(int radios) {
        assertEquals(dsp.getNumberOfRadioButtons(), radios);
    }

    @Then("The Different Elements page contains '(.*)' dropdowns")
    public void verifyTheNumberOfDropdowns(int dropdowns) {
        assertEquals(dsp.getNumberOfDropDowns(), dropdowns);
    }

    @Then("The Different Elements page contains '(.*)' buttons")
    public void verifyTheNumberOfButtons(int buttons) {
        assertEquals(dsp.getNumberOfButtons(), buttons);
    }

    @Then("The Different Elements page contains right section")
    public void verifyThereIsTheRightSection() {
        assertTrue(dsp.isRightSectionVisible());
    }

    @Then("The Different Elements page contains left section")
    public void verifyThereIsTheLeftSection() {
        assertTrue(dsp.isLeftSectionVisible());
    }

    @Then("The log is updated for the following checkboxes")
    public void verifyCheckboxesUpdatedLog(Map<String, Boolean> states) {
        List<String> checkboxes = new ArrayList<>();
        checkboxes.addAll(states.keySet());

        for (String checkbox : checkboxes) {
            boolean state = states.get(checkbox);
            assertTrue(dsp.isLogUpdatedForCheckBox(checkbox, state));
        }

    }

    @Then("The log is updated for the '(.*)' radio button")
    public void verifyRadioButtonUpdatedLog(String radioLabel) {
        assertTrue(dsp.isLogUpdatedForRadioButton(radioLabel));
    }

    @Then("The log is updated for the '(.*)' value in the drop down")
    public void verifyDropDownUpdatedLog(String value) {
        assertTrue(dsp.isLogUpdatedForDropdown(value));
    }

    @Then("The User Table page contains '(.*)' dropdowns")
    public void verifyNumberOfDropDownsInTheUserTablePage(int dropDowns) {
        assertEquals(utp.getNumberOfDropDowns(), dropDowns);
    }

    @Then("The User Table page contains '(.*)' user names")
    public void verifyNumberOfUsersInTheUserTablePage(int users) {
        assertEquals(utp.getNumberOfUserNames(), users);
    }

    @Then("The User Table page contains '(.*)' user images")
    public void verifyNumberOfUserImagesInTheUserTablePage(int images) {
        assertEquals(utp.getNumberOfUserImages(), images);
    }

    @Then("The User Table page contains '(.*)' user descriptions")
    public void verifyNumberOfUserDescriptionsInTheUserTablePage(int descriptions) {
        assertEquals(utp.getNumberOfUserDescriptions(), descriptions);
    }

    @Then("The User Table page contains '(.*)' check boxes")
    public void verifyNumberOfCheckBoxesInTheUserTablePage(int checkBoxes) {
        assertEquals(utp.getNumberOfUserCheckBoxes(), checkBoxes);
    }

    @Then("The User Table page contains the following values")
    public void verifyUsersContent(List<UserElement> users) {

        List<String> expectedUserNames = getNamesList(users);
        List<String> expectedUserIDs = getIDsList(users);
        List<String> expectedUserDescriptions = getDescriptionsList(users);

        List<String> actualUserNames = utp.getUserNamesInThePage();
        List<String> actualUserIDs = utp.getUserIDsInThePage();
        List<String> actualUserDescriptions = utp.getUserDescriptionsInThePage();

        assertEquals(actualUserIDs, expectedUserIDs);
        assertEquals(actualUserNames, expectedUserNames);
        assertEquals(actualUserDescriptions, expectedUserDescriptions);

    }

    @Then("Log contains the '(.*)' record")
    public void verifyLogContainsRecord(String record) {
        assertTrue(utp.getLogText().contains(record));
    }

    @Then("The dropdown for '(.*)' contains the following options")
    public void verifyDropDownContainsOptions(String userName, List<String> expOptions) {

        List<String> actualOptions = utp.getDropDownOptionsForUser(userName);

        assertEquals(actualOptions, expOptions);
    }
}
