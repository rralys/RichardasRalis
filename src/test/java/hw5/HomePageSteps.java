package hw5;

import hw5.enums.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.FileUtils;

import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageSteps extends BaseSteps {

    public HomePageSteps(WebDriver dr) {
        driver = dr;
        TestProvider.getInstance().setDriver(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Step("Check the home page title.")
    public void verifyHomePageTitle() {
        assertEquals(driver.getTitle(),
                FileUtils.readPropertiesFile(propertiesPath + "/pageTitles.properties")
                .getProperty("home.page.title"));
    }

    @Step("Login to home page as user: {0}.")
    public void loginToHomePage() {
        Properties userProperties = FileUtils.readPropertiesFile(propertiesPath + "/user.properties");

        homePage.login(userProperties.getProperty("user.name"),
                userProperties.getProperty("user.password"));
    }

    @Step("Check the name of the logged in user.")
    public void verifyUserName() {
        assertEquals(homePage.getUserName(), FileUtils
                .readPropertiesFile(propertiesPath + "/user.properties")
                .getProperty("user.user.name"));
    }

    @Step("Check the items present in the header section.")
    public void verifyHeaderSectionItems() {
        List<String> expectedTopPanelItemsLabels = TopPanelMenuLabels
                .getListOfTopPanelMenuItems();

        List<String> topPanelItemsXpathes = TopPanelMenuXpathes.getTopPanelMenuXpathesList();

        List<String> actualTopPanelItemsLabels = homePage.getTopPanelMenuItemsLabelsAsList(topPanelItemsXpathes);

        assertEquals(actualTopPanelItemsLabels, expectedTopPanelItemsLabels);
    }

    @Step("Check that the certain images are present in the page.")
    public void verifyIndexImages() {

        assertEquals(homePage.getNumberOfHeaderImages(),
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/elements.properties")
                                .getProperty("index.page.images.count")
                ));

        for (HeaderSectionImagesXpathes item : HeaderSectionImagesXpathes.values()) {
            Boolean isImageVisible = homePage.isHeaderSectionImageVisible(item);
            assertTrue(isImageVisible);
        }

    }

    @Step("Check text in the index.")
    public void verifyIndexTextLabels() {

        List<String> indexTextXpathes = HeaderSectionTextsXpathes.getListOfHeaderSectionTextXpathes();
        List<String> actualIndexTextLabels = homePage.getHeaderSectionTextActualLabels(indexTextXpathes);
        List<String> expectedIndexTextLabels = HeaderSectionTextsLabels.getListOfHeaderSectionTextLabels();


        assertEquals(actualIndexTextLabels, expectedIndexTextLabels);

    }

    @Step("Check the main header contents.")
    public void verifyMainHeadersText() {

        List<String> mainHeaderLabelsXpathes = MainHeaderTextXpathes.getListOfMainHeaderTextXpathes();
        List<String> actualMainHeaderTextLabels = homePage.getMainHeaderTextActualLabels(mainHeaderLabelsXpathes);
        List<String> expectedMainHeaderLabels = MainHeaderTextLabels.getListOfMainHeaderTextLabels();

        assertEquals(actualMainHeaderTextLabels, expectedMainHeaderLabels);
    }

    @Step("Check frame is present in the page.")
    public void verifyIFrameIsVisible() {
        assertTrue(homePage.isIFramePresent());
    }

    @Step("Switch to the frame.")
    public void switchToIFrame() {
        homePage.switchToFrame();
    }

    @Step("The frame should contain logo.")
    public void verifyFrameHasEpamLogo() {
        homePage.isLogoDisplayed();
    }

    @Step("Switch back to the main frame.")
    public void switchBackToMainFrame() {
        homePage.switchToMainFrame();
    }

    @Step("Check the sub-header contents.")
    public void verifyTextInSubHeader() {

        String actualSubHeaderText = homePage.getSubHeaderLabel();
        String expectedSubHeaderText = SubHeaderTextLabels.valueOf("SUB_HEADER_TEXT_LABEL").getSubHeaderTextLabel();

        assertEquals(actualSubHeaderText, expectedSubHeaderText);
    }

    @Step("Check the sub-header has the correct link.")
    public void verifySubHeaderHasProperLink() {

        String expectedLink = FileUtils.readPropertiesFile(propertiesPath + "/subheaderlink.properties").getProperty("subheader.link");
        String actualLink = homePage.getSubHeaderLink();

        assertEquals(actualLink, expectedLink);
    }

    @Step("Check the left section is displayed.")
    public void verifyLeftSectionIsDisplayed() {
        assertTrue(homePage.isLeftSectionDisplayed());
    }

    @Step("Check the footer is displayed.")
    public void verifyFooterIsDisplayed() {
        assertTrue(homePage.isFooterDisplayed());
    }

    @Step("Check the footer is not displayed.")
    public void verifyFooterIsNotDisplayed() {
        assertFalse(homePage.isFooterDisplayed());
    }
    
}
