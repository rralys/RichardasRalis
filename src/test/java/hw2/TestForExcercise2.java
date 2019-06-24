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

// TODO What is the length line of code in Java Code Convention?
public class TestForExcercise2 extends RunTestsForHomework2 {

    // TODO Code duplication with verifyLeftSectionMenuItems
    public void verifyHeaderMenuItems() {
        List<String> headerMenuItemsTextListExpected = Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE");
        List<WebElement> headerMenuItems = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a[@href]"));
        List<String> headerMenuItemsTextListActual = new ArrayList<String>();

        for (WebElement headerMenuItem : headerMenuItems) {
            headerMenuItemsTextListActual.add(headerMenuItem.getText().trim());
        }

        assertEquals(headerMenuItemsTextListActual, headerMenuItemsTextListExpected);
    }

    // TODO Code duplication with verifyHeaderMenuItems
    public void verifyLeftSectionMenuItems() {
        List<String> headerMenuItemsTextListExpected = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance");
        List<WebElement> headerMenuItems = driver.findElements(By.xpath("//ul[@class='sub']//li[@ui='label']"));
        List<String> headerMenuItemsTextListActual = new ArrayList<String>();

        for (WebElement headerMenuItem : headerMenuItems) {
            headerMenuItemsTextListActual.add(headerMenuItem.getText().trim());
        }

        assertEquals(headerMenuItemsTextListActual, headerMenuItemsTextListExpected);
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
        returnElementByXpath("//li[@class='dropdown']//a[@class='dropdown-toggle']").click();
        verifyHeaderMenuItems();
        // 6. Click the "Service" sub-category in the left section and verify labels of the appeared menu items.
        returnElementByXpath("//span[text()='Service']").click();
        verifyLeftSectionMenuItems();
        // 7. Open the "Different Elements" page from the header menu by clicking "Services" menu item.
        returnElementByXpath("//li[@class='dropdown']//a[@class='dropdown-toggle']").click();
        // TODO Is xpath required here?
        returnElementByXpath("//a[@href='different-elements.html']").click();
        // TODO Could be extracted as separate method. Please look at the ex1 code
        assertEquals(driver.getTitle(), "Different Elements");
        // 8. Verify the presence of the necessary web elements.
        assertEquals(driver.findElements(By.xpath("//label[@class='label-checkbox']")).size(), 4);
        assertEquals(driver.findElements(By.xpath("//label[@class='label-radio']")).size(), 4);
        assertEquals(driver.findElements(By.xpath("//select[@class='uui-form-element']")).size(), 1);
        assertEquals(driver.findElements(By.xpath("//*[contains(@value, 'Button')]")).size(), 2);
        // 9. Verify there is the right section.
        // TODO Is xpath required here?
        assertNotNull(returnElementByXpath("//div[@name='log-sidebar']"));
        // 10. Verify there is the left section. //div[@name='navigation-sidebar']
        // TODO Is xpath required here?
        assertNotNull(returnElementByXpath("//div[@name='navigation-sidebar']"));
        // 11. Select check-boxes "Water" and "Wind" and verify they are selected.
        // TODO IS it possible made checkbox name as method parameter?
        returnElementByXpath("//label[text()[contains(.,'Water')]]").click();
        // TODO IS it possible made checkbox name as method parameter?
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Water')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // TODO IS it possible made checkbox name as method parameter?
        returnElementByXpath("//label[text()[contains(.,'Wind')]]").click();
        // TODO IS it possible made checkbox name as method parameter?
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Wind')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // 12. Verify that checking and un-checking the checkboxes updates the "Log" section accordingly.
        // TODO IS it possible made checkbox name as method parameter?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Water: condition changed to true')]]"));
        // TODO IS it possible made checkbox name as method parameter?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Wind: condition changed to true')]]"));
        returnElementByXpath("//label[text()[contains(.,'Earth')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Earth: condition changed to true')]]"));
        returnElementByXpath("//label[text()[contains(.,'Fire')]]").click();
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Fire: condition changed to true')]]"));
        // 13. Select the "Selen" radiobutton and verify its state, and the log state change is according.
        returnElementByXpath("//label[text()[contains(.,'Selen')]]").click();
        assertTrue(returnElementByXpath("//label[text()[contains(.,'Selen')]]//descendant-or-self::input[@type='radio']").isSelected());
        // 14. Verify that the log state changes according to the radiobuttons selection.
        // TODO Why do you check all parameters? Do you read task?
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
        // TODO IS it possible made checkbox name as method parameter?
        returnElementByXpath("//label[text()[contains(.,'Water')]]").click();
        // TODO IS it possible made checkbox name as method parameter?
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Water')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // TODO IS it possible made checkbox name as method parameter?
        returnElementByXpath("//label[text()[contains(.,'Wind')]]").click();
        // TODO IS it possible made checkbox name as method parameter?
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Wind')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // TODO IS it possible made checkbox name as method parameter?
        // TODO Why do you click here Earth?
        returnElementByXpath("//label[text()[contains(.,'Earth')]]").click();
        // TODO IS it possible made checkbox name as method parameter?
        // TODO Why do you check here Earth?
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Earth')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // TODO IS it possible made checkbox name as method parameter?
        // TODO Why do you click here Fire?
        returnElementByXpath("//label[text()[contains(.,'Fire')]]").click();
        // TODO IS it possible made checkbox name as method parameter?
        // TODO Why do you check here Fire?
        assertFalse(returnElementByXpath("//label[text()[contains(.,'Fire')]]//descendant-or-self::input[@type='checkbox']").isSelected());
        // 18. Verify that log state updated according to the new states of the check-boxes.
        // TODO IS it possible made checkbox name as method parameter?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Water: condition changed to false')]]"));
        // TODO IS it possible made checkbox name as method parameter?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Wind: condition changed to false')]]"));
        // TODO IS it possible made checkbox name as method parameter?
        // TODO Why do you check here Earth?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Earth: condition changed to false')]]"));
        // TODO IS it possible made checkbox name as method parameter?
        // TODO Why do you check here Fire?
        assertNotNull(returnElementByXpath("//li[text()[contains(.,'Fire: condition changed to false')]]"));
    }

}
