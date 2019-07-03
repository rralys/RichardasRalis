package hw5;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AttachmentListener.class)
public class TestForExercise2 extends RunTestsForHomework5 {
    @Test
    public void TestScenario2() {
        HomePageSteps hps = new HomePageSteps(driver);
        hps.verifyHomePageTitle();
        hps.loginToHomePage();
        hps.verifyUserName();
        hps.verifyHomePageTitle();
        hps.verifyHeaderSectionItems();
        hps.verifyIndexImages();
        hps.verifyIndexTextLabels();
        hps.verifyMainHeadersText();
        hps.verifyIFrameIsVisible();
        hps.switchToIFrame();
        hps.verifyFrameHasEpamLogo();
        hps.switchBackToMainFrame();
        hps.verifyTextInSubHeader();
        hps.verifySubHeaderHasProperLink();
        hps.verifyLeftSectionIsDisplayed();
        hps.verifyFooterIsNotDisplayed();
    }

}
