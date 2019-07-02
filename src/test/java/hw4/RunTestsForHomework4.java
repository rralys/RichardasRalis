package hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import hw4.basepage.HomePage;
import hw4.basepage.MetalsAndColorsPage;
import hw4.basepage.TableWithPagesPage;
import hw4.builder.MetalsAndColorsBuilder;
import hw4.enums.Elements;
import hw4.enums.HeaderServiceDropdownItems;
import hw4.enums.ServicesLeftSidePanelMenuLabels;
import hw4.enums.Vegetables;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.FileUtils;

import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

// TODO This class contains a lot of page specific methods — Fixed.
// TODO Please reorganize it
public class RunTestsForHomework4 {
    
    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();

    HomePage hp;

    public void loginUsingUserProperties() {
        Properties userProperties = FileUtils.readPropertiesFile(propertiesPath + "/user.properties");

        hp.login(userProperties.getProperty("user.name"),
                userProperties.getProperty("user.password"));

    }

    public void logoutFromApplication() {
        hp.logout();
    }

    public void verifyBrowserTitle(String title) {
        // TODO What do you expect from the current method? — Updated.
        hp.getPageTitle().shouldHave(Condition.attribute("text", title));
    }

    public void verifyUserNameLabel() {
        hp.getUserNameLabel().shouldHave(Condition.text(
                FileUtils.readPropertiesFile(propertiesPath + "/user.properties")
                        .getProperty("user.user.name")
        ));

    }

    public void openTopServiceMenu() {
        hp.getTopServiceMenu().click();
    }

    public void verifyServiceMenuItems() {
        List<String> expectedServiceMenuItems = HeaderServiceDropdownItems.getHeaderServiceDropdownAsList();

        hp.getTopServiceMenuItems().shouldHave(CollectionCondition.texts(expectedServiceMenuItems));
    }

    public void openLeftServiceMenu() {
        hp.getServiceMenu().click();
    }

    public void verifyLeftServiceMenuItems() {
        List<String> expectedServiceMenuItems = ServicesLeftSidePanelMenuLabels.getServiceLeftSidePanelMenuItemsList();

        hp.getLeftServiceMenuItems().shouldHave(CollectionCondition.texts(expectedServiceMenuItems));
    }

    public void openTableWithPages() {
        openTopServiceMenu();
        hp.getTableWithPages().click();
    }

    public void openMetalsAndColorsPage() {
        hp.getMetalsAndColors().click();

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

        hp = open(FileUtils
                .readPropertiesFile(propertiesPath + "/url.properties")
                .getProperty("home.page.url"), HomePage.class);

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
