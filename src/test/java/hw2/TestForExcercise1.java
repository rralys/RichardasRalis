package hw2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

// TODO What is the length line of code in Java Code Convention?
public class TestForExcercise1 extends RunTestsForHomework2 {

    @Test
    public void TestScenario1() {
        // 1. Open the page.
        driver.get("https://epam.github.io/JDI/");
        // 2. Check page title.
        // TODO It could be extracted to the separate method
        assertEquals(driver.getTitle(), "Home Page");
        // 3. Login.
        login("epam", "1234");
        // 4. Verify user name.
        // TODO Is it required using xpath here?
        assertEquals(getTextFromElementAndTrim("//span[@id='user-name']"),"PITER CHAILOVSKII");
        // 5. Verify page title after login.
        // TODO It could be extracted to the separate method
        assertEquals(driver.getTitle(), "Home Page");
        // 6. Verify that header has the correct four items.
        // TODO Please try to avoid getting each element from the menu
        // TODO Loop could be used here
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@href='index.html']")), "HOME");
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@href='contacts.html']")), "CONTACT FORM");
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@class='dropdown-toggle']")), "SERVICE");
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@href='metals-colors.html']")), "METALS & COLORS");
        // 7. Verify that index page has four images present and displayed.
        assertEquals(driver.findElements(By.xpath("//div[@class='benefit']")).size(), 4);
        // TODO Please try to avoid getting each element of the images
        // TODO Loop could be used here
        // TODO Too long locators, could be improved
        assertTrue(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-practise']").isDisplayed());
        assertTrue(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-custom']").isDisplayed());
        assertTrue(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-multi']").isDisplayed());
        assertTrue(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-base']").isDisplayed());
        // 8. Verify that index page contains four text elements below the images and the text content is correct.
        assertEquals(driver.findElements(By.xpath("//ancestor::div[@class='benefit-icon']//following-sibling::span[@class='benefit-txt']")).size(), 4);
        // TODO Too long locators, could be improved
        // TODO Please try to avoid getting each element of the images
        // TODO Loop could be used here
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-practise']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-custom']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "To be flexible and\ncustomizable");
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-multi']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "To be multiplatform");
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-base']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");
        // 9. Verify text in headers.
        // TODO What does \u2026 mean?
        assertEquals(getTextFromElementAndTrim("//h3[@ui='title']"), "EPAM FRAMEWORK WISHES\u2026");
        assertEquals(getTextFromElementAndTrim("//p[@ui='text']"), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        // 10. Verify that there is a frame element.
        assertEquals(driver.findElements(By.tagName("iframe")).size(), 1);
        // 11. Switch to that frame and verify there is the EPAM logo in the frame.
        driver.switchTo().frame("iframe");
        // TODO Why do you use xpath here?
        assertNotNull(driver.findElement(By.xpath("//div[@class='epam-logo']")));
        // 12. Switch to the main window.
        driver.switchTo().parentFrame();
        // 13. Verify the text in the sub-header.
        assertEquals(getTextFromElementAndTrim("//h3[@class='text-center']/a"), "JDI GITHUB");
        // 14. Verify the link behind the sub-header.
        String ref = returnElementByXpath("//h3[@class='text-center']/a").getAttribute("href");
        assertNotNull(ref);
        assertEquals(ref, "https://github.com/epam/JDI");
        // 15. Verify there is left section.
        // TODO Why do you use xpath here?
        assertNotNull(returnElementByXpath("//div[@name='navigation-sidebar']"));
        // 16. Verify there is footer.
        // TODO Why do you use xpath here?
        assertNotNull(returnElementByXpath("//div[@class='footer-content overflow']"));
        // 17. Close browser. — see test teardown.
    }
}
