package hw3.steps;

import hw3.HomePage;
import hw3.enums.HeaderSectionImagesXpathes;
import hw3.enums.TopPanelMenuLabels;
import hw3.enums.TopPanelMenuXpathes;
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
            isImagesDisplayed.add(isImageVisible);
        }

        assertEquals(isImagesDisplayed.size(),
                Integer.parseInt(
                propertiesFile.readElementsCountsFromFile().
                        getProperty("index.page.images.count")));

    }

}
