package hw3.steps;

import hw3.HomePage;
import hw3.enums.*;
import hw3.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageSteps {

    private WebDriver driver;

    private HomePage homePage;

    private FileUtils propertiesFile = new FileUtils();

    public HomePageSteps(WebDriver dr) {
        driver = dr;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public void verifyHomePageTitle() {
        assertEquals(driver.getTitle(),
                propertiesFile.readPageTitleFromFile().getProperty("home.page.title"));
    }

    public void loginToHomePage() {
        homePage.login(propertiesFile.readUserPropertiesFromFile().getProperty("user.name"),
                propertiesFile.readUserPropertiesFromFile().getProperty("user.password"));
    }

    public void verifyUserName() {
        assertEquals(homePage.getUserName(), propertiesFile.readUserPropertiesFromFile()
                .getProperty("user.user.name"));
    }

    public void verifyHeaderSectionItems() {
        ArrayList<String> expectedTopPanelItemsLabels = new ArrayList<>();

        ArrayList<String> actualTopPanelItemsLabels = new ArrayList<>();

        for (TopPanelMenuLabels item : TopPanelMenuLabels.values()) {
            expectedTopPanelItemsLabels.add(item.getTopPanelMenuItemLabel());
        }

        for (TopPanelMenuXpathes item : TopPanelMenuXpathes.values()) {
            actualTopPanelItemsLabels.add(homePage.getTopPanelMenuItemElementLabel(item));
        }

        assertEquals(actualTopPanelItemsLabels, expectedTopPanelItemsLabels);
    }

    public void verifyIndexImages() {

        ArrayList<Boolean> isImagesDisplayed = new ArrayList<>();

        for (HeaderSectionImagesXpathes item : HeaderSectionImagesXpathes.values()) {
            Boolean isImageVisible = homePage.isHeaderSectionImageVisible(item);
            assertTrue(isImageVisible);
            if (isImageVisible) {
                isImagesDisplayed.add(isImageVisible);
            }
        }

        assertEquals(isImagesDisplayed.size(),
                Integer.parseInt(
                propertiesFile.readElementsCountsFromFile().
                        getProperty("index.page.images.count")));

    }

    public void verifyIndexTextLabels() {

        ArrayList<String> actualIndexTextLabels = new ArrayList<>();
        ArrayList<String> expectedIndexTextLabels = new ArrayList<>();

        for (HeaderSectionTextsXpathes xpath : HeaderSectionTextsXpathes.values()) {
            actualIndexTextLabels.add(homePage.getHeaderSectionTextActualLabel(xpath));
        }

        for (HeaderSectionTextsLabels label : HeaderSectionTextsLabels.values()) {
            expectedIndexTextLabels.add(label.getHeaderSectionTextLabel());
        }

        assertEquals(actualIndexTextLabels, expectedIndexTextLabels);

    }

    public void verifyMainHeadersText() {

        ArrayList<String> actualMainHeaderLabels = new ArrayList<>();
        ArrayList<String> expectedMainHeaderLabels = new ArrayList<>();

        for (MainHeaderTextXpathes xpath : MainHeaderTextXpathes.values()) {
            actualMainHeaderLabels.add(homePage.getMainHeaderTextActualLabel(xpath));
        }

        for (MainHeaderTextLabels label : MainHeaderTextLabels.values()) {
            expectedMainHeaderLabels.add(label.getMainHeaderTextLabel());
        }
    }

    public void verifyIframeIsVisible() {
        assertTrue(homePage.isIframePresent());
    }

    public void switchToIframe() {
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

        String expectedLink = propertiesFile.readSubHeaderLinkFromFile().getProperty("subheader.link");
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

        ArrayList<String> actualTopServiceDropdownLabels = homePage.getServiceMenuItemsLabels();
        ArrayList<String> expectedTopServiceDropdownLabels = new ArrayList<>();

        for (HeaderServiceDropdownItems item : HeaderServiceDropdownItems.values()) {
            expectedTopServiceDropdownLabels.add(item.getHeaderServiceDropDownItem());
        }

        assertEquals(actualTopServiceDropdownLabels, expectedTopServiceDropdownLabels);

    }

    public void clickServiceSubcategoryInLeftSection() {
        homePage.clickServiceMenu();
    }

    public void serviceMenuInLeftSectionHasCorrectOptions() {

        ArrayList<String> actualLeftSideServiceMenuLabels = homePage.getLeftServiceMenuItemsLabels();
        ArrayList<String> expectedLeftSideServiceMenuLabels = new ArrayList<>();

        for (ServicesLeftSidePanelMenuLabels item : ServicesLeftSidePanelMenuLabels.values()) {
            expectedLeftSideServiceMenuLabels.add(item.getServiceLeftSidePanelMenuItem());
        }

        assertEquals(actualLeftSideServiceMenuLabels, expectedLeftSideServiceMenuLabels);

    }

    public void openDifferentElementsPageViaTopServiceMenu() {
        homePage.clickServiceItemInHeader();
        homePage.clickTopPanelServicesMenuItem(ServicesTopPanelMenu.valueOf("DIFFERENT_ELEMENTS"));
    }

}
