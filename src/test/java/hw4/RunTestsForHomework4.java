package hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import hw4.builder.MetalsAndColorsBuilder;
import hw4.enums.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static hw4.basepage.HomePage.*;
import static hw4.basepage.MetalsAndColorsPage.*;
import static hw4.basepage.TableWithPagesPage.*;

public class RunTestsForHomework4 {
    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();


    public void loginUsingUserProperties() {
        Properties userProperties = FileUtils.readPropertiesFile(propertiesPath + "/user.properties");

        login(userProperties.getProperty("user.name"),
                userProperties.getProperty("user.password"));

    }

    public void logoutFromApplication() {
        logout();
    }

    public void verifyBrowserTitle(String title) {
        title().equals(title);
    }

    public void verifyUserNameLabel() {
        getUserNameLabel().shouldHave(Condition.text(
                FileUtils.readPropertiesFile(propertiesPath + "/user.properties")
                        .getProperty("user.user.name")
        ));

    }

    public void openTopServiceMenu() {
        getTopServiceMenu().click();
    }

    public void verifyServiceMenuItems() {
        List<String> expectedServiceMenuItems = HeaderServiceDropdownItems.getHeaderServiceDropdownAsList();

        getTopServiceMenuItems().shouldHave(CollectionCondition.texts(expectedServiceMenuItems));
    }

    public void openLeftServiceMenu() {
        getServiceMenu().click();
    }

    public void verifyLeftServiceMenuItems() {
        List<String> expectedServiceMenuItems = ServicesLeftSidePanelMenuLabels.getServiceLeftSidePanelMenuItemsList();

        getLeftServiceMenuItems().shouldHave(CollectionCondition.texts(expectedServiceMenuItems));
    }

    public void openTableWithPages() {
        openTopServiceMenu();
        getTableWithPages().click();
    }

    public void verifySelectedShowDropdown() {

        getShowEntriesDropdown().getSelectedOption().shouldHave(Condition.text(
                FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                        .getProperty("show.dropdown.visible")
        ));

    }

    public void verifyRightSectionIsPresent() {
        getRightSection().shouldBe(Condition.visible);
    }

    public void verifyLeftSectionIsPresent() {
        getLeftSection().shouldBe(Condition.visible);
    }

    public void selectShowValue() {
        setShowEntriesDropdown(
                FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                        .getProperty("show.dropdown.to.select")
        );
    }

    public void verifyLogContainsNewShowValueInfo() {
        getLogSection().shouldHave(Condition.text(
                FileUtils.readPropertiesFile(propertiesPath + "/log.properties")
                        .getProperty("length.new.value")
        ));
    }

    public void verifyNumberOfTableRows() {
        getTableElements().shouldHaveSize(
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                                .getProperty("show.dropdown.to.select")
                ));
    }

    public void setInputSearchValue() {
        setInputSearch(FileUtils.readPropertiesFile(propertiesPath + "/search.properties")
                .getProperty("search.input.value"));
    }

    public void verifySearchHits() {

        for (SelenideElement element : getTableElements()) {
            element.shouldHave(Condition.matchesText(
                    FileUtils.readPropertiesFile(propertiesPath + "/search.properties")
                            .getProperty("search.input.value")
            ));
        }
    }

    public void openMetalsAndColorsPage() {
        getMetalsAndColors().click();

    }

    public void setMetalsAndColorsSummary(List<String> summaryLabels) {
        setSummary(summaryLabels);
    }

    public void setMetalsAndColorsElements(List<Elements> elementsList) {
        setElementsCheckbox(elementsList);
    }

    public void setMetalsAndColorsColor(String color) {
        setColorsDropdown(color);
    }

    public void SetMetalsAndColorsMetal(String metal) {
        setMetalsDropdown(metal);
    }

    public void setMetalsAndColorsVegetables(List<Vegetables> vegetables) {
        if (vegetables == null) { return; }

        List<String> vegetablesLabels = new ArrayList<>();

        for (Vegetables veg : vegetables) {
            vegetablesLabels.add(veg.getVegetableValue());
        }

        setVegetablesDropdown(vegetablesLabels);
    }

    public void submitForm() {
        submitClick();
    }

    public String calculateSummary(List<String> summaries) {
        if (summaries == null) { return FileUtils.
                readPropertiesFile(propertiesPath + "/summary.properties").
                getProperty("summary.default"); }

        int sum = 0;

        for (String summary : summaries) {
            sum += Integer.valueOf(summary);
        }

        return String.valueOf(sum);

    }

    public void verifySubmittedForm(MetalsAndColorsBuilder build) {
        getSummaryLog().shouldHave(Condition.matchesText(calculateSummary(build.getSummaryRadio())));
        if (build.getElements() != null) {
            for (Elements elementItem : build.getElements()) {
                getElementsLog().shouldHave(Condition.matchesText(elementItem.getElementValue()));
            }
        }

        if (build.getColors() != null) {
            getColorLog().shouldHave(Condition.matchesText(build.getColors()));
        } else {
            getColorLog().shouldHave(Condition.matchesText(FileUtils.
                    readPropertiesFile(propertiesPath + "/log.properties").
                    getProperty("default.color")));
        }

        if (build.getMetal() != null) {
            getMetalLog().shouldHave(Condition.matchesText(build.getMetal()));
        } else {
            getMetalLog().shouldHave(Condition.matchesText(FileUtils.
                    readPropertiesFile(propertiesPath + "/log.properties").
                    getProperty("default.metal")));
        }

        if (build.getVegetables() != null) {
            for (Vegetables veg : build.getVegetables()) {
                getVegetablesLog().shouldHave(Condition.matchesText(veg.getVegetableValue()));
            }
        } else {
            getVegetablesLog().shouldHave(Condition.matchesText(FileUtils.
                    readPropertiesFile(propertiesPath + "/log.properties").
                    getProperty("default.vegetable")));
        }

    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "FIREFOX";
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100;
        Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
        open("https://epam.github.io/JDI");
        verifyBrowserTitle(FileUtils
                .readPropertiesFile(propertiesPath + "/pageTitles.properties")
                .getProperty("home.page.title"));
        loginUsingUserProperties();

    }

    @AfterMethod
    public void tearDown() {
        logoutFromApplication();
    }

}
