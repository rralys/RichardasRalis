package hw6.steps;

import cucumber.api.java.en.When;

import java.util.List;

public class WhenSteps extends BaseStep {

    @When("I login as the user '([^\"]*)'/'([^\"]*)'")
    public void loginAsUser(String uName, String uPass) {
        hp.login(uName, uPass);
    }

    @When("I click the top menu item '(.*)'")
    public void clickTopMenuItemByLabel(String itemLabel) {
        hp.clickTopMenuItem(itemLabel);
    }

    @When("I click the left menu item '(.*)'")
    public void clickLeftMenuItemByLabel(String itemLabel) {
        hp.clickLeftMenuItem(itemLabel);
    }

    @When("I open Different Elements Page via top Services menu")
    public void openDifferentElementsPage() {
        hp.clickDifferentElementsMenuItem();
    }

    @When("I set the following checkboxes")
    public void setCheckBoxesByLabel(List<String> labels) {
        dsp.selectListOfCheckBoxes(labels);
    }

    @When("I select the '(.*)' radio button")
    public void setRadioButton(String radioLabel) {
        dsp.setRadioButton(radioLabel);
    }

    @When("I select the '(.*)' option in the drop down")
    public void setDropDownValue(String value) {
        dsp.setColorDropDown(value);
    }

    @When("I unset the following checkboxes")
    public void unsetCheckBoxesByLabel(List<String> labels) {
        dsp.selectListOfCheckBoxes(labels);
    }

    @When("I click the '(.*)' button in Service top menu")
    public void clickTheTopServiceMenuItem(String item) {
        hp.clickTopMenuItem(item);
    }

    @When("I set vip checkbox for '(.*)'")
    public void clickTheUserCheckbox(String userName) {
        utp.setUserCheckBoxByLabel(userName);
    }

    @When("I click the dropdown for the user '(.*)'")
    public void clickTheUserDropDownByLabel(String userName) {
        utp.clickDropDownForUser(userName);
    }
}
