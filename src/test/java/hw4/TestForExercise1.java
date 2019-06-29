package hw4;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestForExercise1 extends RunTestsForHomework4 {

    @Test
    public void TestScenario1() {
        open("https://epam.github.io/JDI");
        loginUsingUserProperties();
        verifyUserNameLabel();
        openTopServiceMenu();
        verifyServiceMenuItems();
        openLeftServiceMenu();
        verifyLeftServiceMenuItems();
        openTableWithPages();
        verifySelectedShowDropdown();
        verifyRightSectionIsPresent();
        verifyLeftSectionIsPresent();
        selectShowValue();
        verifyLogContainsNewShowValueInfo();
        verifyNumberOfTableRows();
        setInputSearchValue();
        verifySearchHits();
    }
}
