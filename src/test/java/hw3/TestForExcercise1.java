package hw3;

import hw3.steps.HomePageSteps;
import hw3.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//import static hw3.utils.FileUtils.readUserPropertiesFromFile;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestForExcercise1 extends RunTestsForHomework3 {

    @Test
    public void TestScenario1() {
        HomePageSteps hps = new HomePageSteps(driver);
        hps.verifyHomePageTitle();
        hps.loginToHomePage();
        hps.verifyUserName();
        hps.verifyHomePageTitle();
        hps.verifyHeaderSectionItems();
        hps.verifyIndexImages();
    }
}
