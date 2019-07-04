package hw5;

import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AttachmentListener.class)
public class TestForExercise1 extends RunTestsForHomework5 {

    @Feature("JDI site workflows.")
    @Story("JDI home page.")
    @Test
    public void TestScenario1() {
        HomePageSteps hps = new HomePageSteps(driver);
        hps.verifyHomePageTitle();
        hps.loginToHomePage(uName, uPass);
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
        hps.verifyFooterIsDisplayed();
    }
}
