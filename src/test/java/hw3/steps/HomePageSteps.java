package hw3.steps;

import hw3.basepage.HomePage;
import hw3.enums.*;
import hw3.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageSteps extends BaseSteps {

    private FileUtils propertiesFile = new FileUtils();

    public HomePageSteps(WebDriver dr) {
        driver = dr;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public void verifyHomePageTitle() {
        assertEquals(driver.getTitle(),
                FileUtils.readPropertiesFile(propertiesPath + "/pageTitles.properties")
                .getProperty("home.page.title"));
    }

    public void loginToHomePage() {
        Properties userProperties = FileUtils.readPropertiesFile(propertiesPath + "/user.properties");

        homePage.login(userProperties.getProperty("user.name"),
                userProperties.getProperty("user.password"));
    }

    public void verifyUserName() {
        assertEquals(homePage.getUserName(), FileUtils
                .readPropertiesFile(propertiesPath + "/user.properties")
                .getProperty("user.user.name"));
    }

    public void verifyHeaderSectionItems() {
        List<String> expectedTopPanelItemsLabels = TopPanelMenuLabels
                .getListOfTopPanelMenuItems();

        List<String> topPanelItemsXpathes = TopPanelMenuXpathes.getTopPanelMenuXpathesList();

        List<String> actualTopPanelItemsLabels = homePage.getTopPanelMenuItemsLabelsAsList(topPanelItemsXpathes);

        assertEquals(actualTopPanelItemsLabels, expectedTopPanelItemsLabels);
    }

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

    public void verifyIndexTextLabels() {

        List<String> indexTextXpathes = HeaderSectionTextsXpathes.getListOfHeaderSectionTextXpathes();
        List<String> actualIndexTextLabels = homePage.getHeaderSectionTextActualLabels(indexTextXpathes);
        List<String> expectedIndexTextLabels = HeaderSectionTextsLabels.getListOfHeaderSectionTextLabels();


        assertEquals(actualIndexTextLabels, expectedIndexTextLabels);

    }

    public void verifyMainHeadersText() {

        List<String> mainHeaderLabelsXpathes = MainHeaderTextXpathes.getListOfMainHeaderTextXpathes();
        List<String> actualMainHeaderTextLabels = homePage.getMainHeaderTextActualLabels(mainHeaderLabelsXpathes);
        List<String> expectedMainHeaderLabels = MainHeaderTextLabels.getListOfMainHeaderTextLabels();

        assertEquals(actualMainHeaderTextLabels, expectedMainHeaderLabels);
    }

    public void verifyIframeIsVisible() {
        assertTrue(homePage.isIFramePresent());
    }

    public void switchToIFrame() {
        homePage.switchToFrame();
    }

    public void verifyFrameHasEpamLogo() {
        homePage.isLogoDisplayed();
    }

    public void switchBackToMainFrame() {
        homePage.switchToMainFrame();
    }

    public void verifyTextInSubHeader() {

        String actualSubHeaderText = homePage.getSubHeaderLabel();
        String expectedSubHeaderText = SubHeaderTextLabels.valueOf("SUB_HEADER_TEXT_LABEL").getSubHeaderTextLabel();

        assertEquals(actualSubHeaderText, expectedSubHeaderText);
    }

    public void verifySubHeaderHasProperLink() {

        String expectedLink = FileUtils.readPropertiesFile(propertiesPath + "/subheaderlink.properties").getProperty("subheader.link");
        String actualLink = homePage.getSubHeaderLink();

        assertEquals(actualLink, expectedLink);
    }

    public void verifyLeftSectionIsDisplayed() {
        assertTrue(homePage.isLeftSectionDisplayed());
    }

    public void verifyFooterIsDisplayed() {
        assertTrue(homePage.isFooterDisplayed());
    }

    public void clickServiceSubcategoryInHeader() {
        homePage.clickServiceItemInHeader();
    }

    public void serviceDropdownHasCorrectOptions() {

        List<String> actualTopServiceDropdownLabels = homePage.getServiceMenuItemsLabels();
        List<String> expectedTopServiceDropdownLabels = HeaderServiceDropdownItems.getHeaderServiceDropdownAsList();

        assertEquals(actualTopServiceDropdownLabels, expectedTopServiceDropdownLabels);

    }

    public void clickServiceSubcategoryInLeftSection() {
        homePage.clickServiceMenu();
    }

    public void serviceMenuInLeftSectionHasCorrectOptions() {

        List<String> actualLeftSideServiceMenuLabels = homePage.getLeftServiceMenuItemsLabels();
        List<String> expectedLeftSideServiceMenuLabels = ServicesLeftSidePanelMenuLabels.getServiceLeftSidePanelMenuItemsList();

        assertEquals(actualLeftSideServiceMenuLabels, expectedLeftSideServiceMenuLabels);

    }

    public void openDifferentElementsPageViaTopServiceMenu() {
        homePage.clickServiceItemInHeader();
        homePage.clickTopPanelServicesMenuItem(ServicesTopPanelMenu.valueOf("DIFFERENT_ELEMENTS"));
    }

}
