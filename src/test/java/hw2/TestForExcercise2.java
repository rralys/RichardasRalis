package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestForExcercise2 extends RunTestsForHomework2 {

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
        returnElementByXpath("//li[@class='dropdown']//a[@class='dropdown-toggle']").click();
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[1]"), "SUPPORT");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[2]"), "DATES");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[3]"), "SEARCH");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[4]"), "COMPLEX TABLE");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[5]"), "SIMPLE TABLE");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[6]"), "USER TABLE");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[7]"), "TABLE WITH PAGES");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[8]"), "DIFFERENT ELEMENTS");
        assertEquals(getTextFromElementAndTrim("//ul[@class='dropdown-menu']//li[9]"), "PERFORMANCE");
        // 6. Click the "Service" sub-category in the left section and verify labels of the appeared menu items.
        returnElementByXpath("//span[text()='Service']").click();
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][1]"), "Support");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][2]"), "Dates");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][3]"), "Complex Table");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][4]"), "Simple Table");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][5]"), "Search");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][6]"), "User Table");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][7]"), "Table with pages");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][8]"), "Different elements");
        assertEquals(getTextFromElementAndTrim("//ul[@class='sub']//li[@ui='label'][9]"), "Performance");
        // 7. Open the "Different Elements" page from the header menu by clicking "Services" menu item.
        returnElementByXpath("//li[@class='dropdown']//a[@class='dropdown-toggle']").click();
        returnElementByXpath("//ul[@class='dropdown-menu']//li[8]").click();
        assertEquals(driver.getTitle(), "Different Elements");
        // 8. Verify the presence of the necessary web elements.
        assertEquals(driver.findElements(By.xpath("//label[@class='label-checkbox']")).size(), 4);
        assertEquals(driver.findElements(By.xpath("//label[@class='label-radio']")).size(), 4);
        assertEquals(driver.findElements(By.xpath("//select[@class='uui-form-element']")).size(), 1);
        assertEquals(driver.findElements(By.xpath("//*[contains(@value, 'Button')]")).size(), 2);
        // 9. Verify there is the right section.
        assertNotNull(returnElementByXpath("//div[@name='log-sidebar']"));
        // 10. Verify there is the left section. //div[@name='navigation-sidebar']
        assertNotNull(returnElementByXpath("//div[@name='navigation-sidebar']"));
        // 11. Select check-boxes "Water" and "Wind" and verify they are selected.
        returnElementByXpath("//label[text()[contains(.,'Water')]]").click();
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Water')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        returnElementByXpath("//label[text()[contains(.,'Wind')]]").click();
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Wind')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // 12. Verify that checking and un-checking the checkboxes updates the "Log" section accordingly.
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Water: condition changed to true')]]"));
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Wind: condition changed to true')]]"));
        returnElementByXpath("//label[text()[contains(.,'Earth')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Earth: condition changed to true')]]"));
        returnElementByXpath("//label[text()[contains(.,'Fire')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Fire: condition changed to true')]]"));
        // 13. Select the "Selen" radiobutton and verify its state, and the log state change is according.
        returnElementByXpath("//label[text()[contains(.,'Selen')]]").click();
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Selen')]]//descendant-or-self::input[@type='radio']").isSelected());
        // 14. Verify that the log state changes according to the radiobuttons selection.
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'metal: value changed to  Selen')]]"));
        returnElementByXpath("//label[text()[contains(.,'Gold')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'metal: value changed to  Gold')]]"));
        returnElementByXpath("//label[text()[contains(.,'Silver')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'metal: value changed to  Silver')]]"));
        returnElementByXpath("//label[text()[contains(.,'Bronze')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'metal: value changed to  Bronze')]]"));
        // 15. Select the "Yellow" dropdown value.
        Select colorDrp = new Select(returnElementByXpath("//select[@class='uui-form-element']"));
        colorDrp.selectByVisibleText("Yellow");
        // 16. Verify that the log state changed according to the selected value.
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Colors: value changed to Yellow')]]"));
        // 17. Un-select check-boxes and verify their state changed accordingly.
        returnElementByXpath("//label[text()[contains(.,'Water')]]").click();
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Water')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        returnElementByXpath("//label[text()[contains(.,'Wind')]]").click();
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Wind')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        returnElementByXpath("//label[text()[contains(.,'Earth')]]").click();
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Earth')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        returnElementByXpath("//label[text()[contains(.,'Fire')]]").click();
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Fire')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // 18. Verify that log state updated according to the new states of the check-boxes.
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Water: condition changed to false')]]"));
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Wind: condition changed to false')]]"));
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Earth: condition changed to false')]]"));
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Fire: condition changed to false')]]"));
    }

}
