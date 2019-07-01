package hw4;

import org.testng.annotations.Test;

public class TestForExercise1 extends RunTestsForHomework4 {

    @Test
    public void TestScenario1() {
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
