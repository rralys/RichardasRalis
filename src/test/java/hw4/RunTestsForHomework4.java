package hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.HeaderServiceDropdownItems;
import hw4.enums.ServicesLeftSidePanelMenuLabels;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.FileUtils;

import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static hw4.basepage.HomePage.*;
import static hw4.basepage.TableWithPagesPage.*;

public class RunTestsForHomework4 {
    protected ChromeOptions options;
    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();


    public void loginUsingUserProperties() {
        Properties userProperties = FileUtils.readPropertiesFile(propertiesPath + "/user.properties");

        login(userProperties.getProperty("user.name"),
                userProperties.getProperty("user.password"));

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

    @BeforeMethod
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterMethod
    public void tearDown() {
        getWebDriver().close();
    }

}
