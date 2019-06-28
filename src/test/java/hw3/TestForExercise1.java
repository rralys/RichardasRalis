package hw3;

import hw3.steps.HomePageSteps;
import org.testng.annotations.Test;

public class TestForExercise1 extends RunTestsForHomework3 {

    @Test
    public void TestScenario1() {
        HomePageSteps hps = new HomePageSteps(driver);
        hps.verifyHomePageTitle();
        hps.loginToHomePage();
        hps.verifyUserName();
        hps.verifyHomePageTitle();
        hps.verifyHeaderSectionItems();
        hps.verifyIndexImages();
        hps.verifyIndexTextLabels();
        hps.verifyMainHeadersText();
        hps.verifyIframeIsVisible();
        hps.switchToIFrame();
        hps.verifyFrameHasEpamLogo();
        hps.switchBackToMainFrame();
        hps.verifyTextInSubHeader();
        hps.verifySubHeaderHasProperLink();
        hps.verifyLeftSectionIsDisplayed();
        hps.verifyFooterIsDisplayed();
    }
}
