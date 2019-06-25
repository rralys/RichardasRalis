package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestForExcercise2 extends RunTestsForHomework2 {

    public void verifyHeaderMenuItems() {
        List<String> headerMenuItemsTextListExpected = Arrays.asList("SUPPORT",
                "DATES",
                "SEARCH",
                "COMPLEX TABLE",
                "SIMPLE TABLE",
                "USER TABLE",
                "TABLE WITH PAGES",
                "DIFFERENT ELEMENTS",
                "PERFORMANCE");
        verifyListOfLabelsFromXpath("//ul[@class='dropdown-menu']//a[@href]", headerMenuItemsTextListExpected);
    }

    // TODO Code duplication with verifyHeaderMenuItems
    public void verifyLeftSectionMenuItems() {
        List<String> headerMenuItemsTextListExpected = Arrays.asList("Support",
                "Dates",
                "Complex Table",
                "Simple Table",
                "Search",
                "User Table",
                "Table with pages",
                "Different elements",
                "Performance");
        verifyListOfLabelsFromXpath("//ul[@class='sub']//li[@ui='label']", headerMenuItemsTextListExpected);
    }

    @Test
    public void TestScenario2() {
        // 1. Open the page.
        driver.get("https://epam.github.io/JDI/");
        // 2. Check page title.
        assertEquals(driver.getTitle(), "Home Page");
        // 3. Login.
        login("epam", "1234");
        // 4. Verify user name.
        assertEquals(getTextFromElementAndTrim("//span[@id='user-name']"),"PITER CHAILOVSKII");
        // 5. Click the "Service" sub-category in the header and verify labels of the appeared menu items.
        clickElementByXpath("//li[@class='dropdown']//a[@class='dropdown-toggle']");
        verifyHeaderMenuItems();
        // 6. Click the "Service" sub-category in the left section and verify labels of the appeared menu items.
        clickElementByXpath("//span[text()='Service']");
        verifyLeftSectionMenuItems();
        // 7. Open the "Different Elements" page from the header menu by clicking "Services" menu item.
        clickElementByXpath("//li[@class='dropdown']//a[@class='dropdown-toggle']");
        // TODO Is xpath required here? — I guess so, the method requires xpath here.
        // TODO Is it possible do not use xpath here?
        clickElementByXpath("//a[@href='different-elements.html']");
        verifyPageTitle("Different Elements");
        // 8. Verify the presence of the necessary web elements.
        assertEquals(driver.findElements(By.xpath("//label[@class='label-checkbox']")).size(), 4);
        assertEquals(driver.findElements(By.xpath("//label[@class='label-radio']")).size(), 4);
        assertEquals(driver.findElements(By.xpath("//select[@class='uui-form-element']")).size(), 1);
        assertEquals(driver.findElements(By.xpath("//*[contains(@value, 'Button')]")).size(), 2);
        // 9. Verify there is the right section.
        // TODO Is xpath required here? — I think so, the method returning the element requires xpath.
        // TODO Please read requirements for the HW
        assertTrue(returnElementByXpath("//div[@name='log-sidebar']").isDisplayed());
        // 10. Verify there is the left section. //div[@name='navigation-sidebar']
        // TODO Is xpath required here? — As above
        //          // TODO Please read requirements for the HW.
        assertTrue(returnElementByXpath("//div[@name='navigation-sidebar']").isDisplayed());
        // 11. Select check-boxes "Water" and "Wind" and verify they are selected.
        clickCheckBoxAndVerifyChecked("Water");
        clickCheckBoxAndVerifyChecked("Wind");
        // 12. Verify that checking and un-checking the checkboxes updates the "Log" section accordingly.
        verifyLogStateAfterCheckBoxClick("Water", true);
        verifyLogStateAfterCheckBoxClick("Wind", true);
        clickCheckBoxAndVerifyChecked("Earth");
        verifyLogStateAfterCheckBoxClick("Earth", true);
        clickCheckBoxAndVerifyChecked("Fire");
        verifyLogStateAfterCheckBoxClick("Fire", true);
        // 13. Select the "Selen" radiobutton and verify its state, and the log state change is according.
        returnElementByXpath("//label[text()[contains(.,'Selen')]]").click();
        // TODO Locator is too complicated
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Selen')]]//descendant-or-self::input[@type='radio']").isSelected());
        // 14. Verify that the log state changes according to the radiobuttons selection.
        // TODO Why do you check all parameters? Do you read task?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'metal: value changed to  Selen')]]"));
        // 15. Select the "Yellow" dropdown value.
        Select colorDrp = new Select(returnElementByXpath("//select[@class='uui-form-element']"));
        colorDrp.selectByVisibleText("Yellow");
        // 16. Verify that the log state changed according to the selected value.
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Colors: value changed to Yellow')]]"));
        // 17. Un-select check-boxes and verify their state changed accordingly.
        clickCheckBoxAndVerifyUnchecked("Water");
        clickCheckBoxAndVerifyUnchecked("Wind");
        // 18. Verify that log state updated according to the new states of the check-boxes.
        verifyLogStateAfterCheckBoxClick("Water", false);
        verifyLogStateAfterCheckBoxClick("Wind", false);
    }

}
