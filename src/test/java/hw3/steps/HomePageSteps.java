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

    // TODO It could be extracted to the BaseStep class — Done.

    // TODO It could be extracted to the BaseStep class — Done.

    // TODO It could be extracted to the BaseStep class — Declared static method, so do not need this declaration anymore.
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
        // TODO Why do you decide use ArrayList instead of List? — Changed to List.

        List<String> expectedTopPanelItemsLabels = TopPanelMenuLabels
                .getListOfTopPanelMenuItems();

        List<String> topPanelItemsXpathes = TopPanelMenuXpathes.getTopPanelMenuXpathesList();

        List<String> actualTopPanelItemsLabels = homePage.getTopPanelMenuItemsLabelsAsList(topPanelItemsXpathes);

        //for (TopPanelMenuLabels item : TopPanelMenuLabels.values()) {
            // TODO it will be better if you have static method in TopPanelMenuLabels which return List<String> — extracted to static method.
        //    expectedTopPanelItemsLabels.add(item.getTopPanelMenuItemLabel());
        //}

        //for (TopPanelMenuXpathes item : TopPanelMenuXpathes.values()) {
            // TODO I think that these two loops could be combined into one — now using a separate method.
        //    actualTopPanelItemsLabels.add(homePage.getTopPanelMenuItemElementLabel(item));
        //}

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
            // TODO this if is redundant here. Test will failed in the previous line — Removed.
        }

    }

    public void verifyIndexTextLabels() {

        List<String> indexTextXpathes = HeaderSectionTextsXpathes.getListOfHeaderSectionTextXpathes();
        List<String> actualIndexTextLabels = homePage.getHeaderSectionTextActualLabels(indexTextXpathes);
        List<String> expectedIndexTextLabels = HeaderSectionTextsLabels.getListOfHeaderSectionTextLabels();

        // TODO I think that these two loops could be combined into one — Moved into different methods.
        //for (HeaderSectionTextsXpathes xpath : HeaderSectionTextsXpathes.values()) {
            // TODO it will be better if you have static method in HeaderSectionTextsXpathes which return List<String> — Done.
        //    actualIndexTextLabels.add(homePage.getHeaderSectionTextActualLabel(xpath));
        //}

        assertEquals(actualIndexTextLabels, expectedIndexTextLabels);

    }

    // TODO What is the purpose of the current method — this method verifies that main header texts are correct (step 9 from exercise 1).
    // Forgot to add assertion :-(. Now added.
    public void verifyMainHeadersText() {

        List<String> mainHeaderLabelsXpathes = MainHeaderTextXpathes.getListOfMainHeaderTextXpathes();
        List<String> actualMainHeaderTextLabels = homePage.getMainHeaderTextActualLabels(mainHeaderLabelsXpathes);
        List<String> expectedMainHeaderLabels = MainHeaderTextLabels.getListOfMainHeaderTextLabels();

        assertEquals(actualMainHeaderTextLabels, expectedMainHeaderLabels);
    }

    // TODO verifyIFrameIsVisible — Done.
    public void verifyIframeIsVisible() {
        assertTrue(homePage.isIFramePresent());
    }

    // TODO switchToIFrame — Done.
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

        //for (HeaderServiceDropdownItems item : HeaderServiceDropdownItems.values()) {
            // TODO it will be better if you have static method in HeaderServiceDropdownItems which return List<String> — Done.
        //    expectedTopServiceDropdownLabels.add(item.getHeaderServiceDropDownItem());
        //}

        assertEquals(actualTopServiceDropdownLabels, expectedTopServiceDropdownLabels);

    }

    public void clickServiceSubcategoryInLeftSection() {
        homePage.clickServiceMenu();
    }

    public void serviceMenuInLeftSectionHasCorrectOptions() {

        List<String> actualLeftSideServiceMenuLabels = homePage.getLeftServiceMenuItemsLabels();
        List<String> expectedLeftSideServiceMenuLabels = ServicesLeftSidePanelMenuLabels.getServiceLeftSidePanelMenuItemsList();

        //for (ServicesLeftSidePanelMenuLabels item : ServicesLeftSidePanelMenuLabels.values()) {
            // TODO it will be better if you have static method in ServicesLeftSidePanelMenuLabels which return List<String> — Done.
        //    expectedLeftSideServiceMenuLabels.add(item.getServiceLeftSidePanelMenuItem());
        //}

        assertEquals(actualLeftSideServiceMenuLabels, expectedLeftSideServiceMenuLabels);

    }

    public void openDifferentElementsPageViaTopServiceMenu() {
        homePage.clickServiceItemInHeader();
        homePage.clickTopPanelServicesMenuItem(ServicesTopPanelMenu.valueOf("DIFFERENT_ELEMENTS"));
    }

}
