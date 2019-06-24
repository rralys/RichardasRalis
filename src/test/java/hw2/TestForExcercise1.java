package hw2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

// TODO What is the length line of code in Java Code Convention? — 80 characters. I'll update the code.
public class TestForExcercise1 extends RunTestsForHomework2 {

    public void verifyHeaderItems() {
        List<String> headerMenuItemsTextListExpected = Arrays.asList("HOME",
                "CONTACT FORM",
                "SERVICE",
                "METALS & COLORS");

        List<String> headerMenuItemsXpathes = Arrays.asList("//a[@href='index.html']",
                "//a[@href='contacts.html']",
                "//a[@class='dropdown-toggle']",
                "//a[@href='metals-colors.html']");

        verifyListOfLabelsFromListOfXpathes(headerMenuItemsXpathes, headerMenuItemsTextListExpected);
    }

    public void verifyIndexImagesDisplay() {
        List<String> indexImagesXpathes = Arrays.asList("icon-practise",
                "icon-custom",
                "icon-multi",
                "icon-base");

        for (String indexImageXpath : indexImagesXpathes) {
            assertTrue(returnElementByXpath("//span[contains(@class,'" +
                    indexImageXpath + "')]").isDisplayed());
        }
    }

    public void verifyTextLabelsBelowImages() {
        List<String> expectedTextLabels = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        List<String> labelsBelowImagesXpathes = Arrays.asList("//span[contains(@class,'practise')]/../following-sibling::span[@class='benefit-txt']",
                "//span[contains(@class,'custom')]/../following-sibling::span[@class='benefit-txt']",
                "//span[contains(@class,'multi')]/../following-sibling::span[@class='benefit-txt']",
                "//span[contains(@class,'base')]/../following-sibling::span[@class='benefit-txt']");

        verifyListOfLabelsFromListOfXpathes(labelsBelowImagesXpathes, expectedTextLabels);
    }

    public void verifyTextInHeaders() {
        List<String> expectedHeaders = Arrays.asList("EPAM FRAMEWORK WISHES…",
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED " +
                        "DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                        "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
                        "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        List<String> headersXpathes = Arrays.asList("//h3[@ui='title']",
                "//p[@ui='text']");

        verifyListOfLabelsFromListOfXpathes(headersXpathes, expectedHeaders);
    }

    @Test
    public void TestScenario1() {
        // 1. Open the page.
        driver.get("https://epam.github.io/JDI/");
        // 2. Check page title.
        // TODO It could be extracted to the separate method — Done.
        verifyPageTitle("Home Page");
        // 3. Login.
        login("epam", "1234");
        // 4. Verify user name.
        // TODO Is it required using xpath here? — I prefer to always search using xpath,
        // I do not get dependent on attributes names, whether they are id, class, href and so on.
        // I can describe elements as unique as possible. Besides, the method here requires xpath.
        assertEquals(getTextFromElementAndTrim("//span[@id='user-name']"), "PITER CHAILOVSKII");
        // 5. Verify page title after login.
        // TODO It could be extracted to the separate method — Done.
        verifyPageTitle("Home Page");
        // 6. Verify that header has the correct four items.
        // TODO Please try to avoid getting each element from the menu — Fixed.
        // TODO Loop could be used here — Fixed.
        verifyHeaderItems();
        // 7. Verify that index page has four images present and displayed.
        assertEquals(driver.findElements(By.xpath("//div[@class='benefit']")).size(), 4);
        // TODO Please try to avoid getting each element of the images — Fixed.
        // TODO Loop could be used here — Done.
        // TODO Too long locators, could be improved — Fixed.
        verifyIndexImagesDisplay();
        // 8. Verify that index page contains four text elements below the images and the text content is correct.
        assertEquals(driver.findElements(By.xpath("//div[@class='benefit-icon']//following::span[@class='benefit-txt']")).size(), 4);
        // TODO Too long locators, could be improved — Tried to fix.
        // TODO Please try to avoid getting each element of the images — Done.
        // TODO Loop could be used here — Done.
        verifyTextLabelsBelowImages();
        // 9. Verify text in headers.
        // TODO What does \u2026 mean? — This is ellipsis. Had issues with encoding. looks like it is fixed by encoding specification in pom.xml.
        verifyTextInHeaders();
        // 10. Verify that there is a frame element.
        assertEquals(driver.findElements(By.tagName("iframe")).size(), 1);
        // 11. Switch to that frame and verify there is the EPAM logo in the frame.
        driver.switchTo().frame("iframe");
        // TODO Why do you use xpath here? — Changed to id.
        assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());
        // 12. Switch to the main window.
        driver.switchTo().parentFrame();
        // 13. Verify the text in the sub-header.
        assertEquals(getTextFromElementAndTrim("//h3[@class='text-center']/a"), "JDI GITHUB");
        // 14. Verify the link behind the sub-header.
        String ref = returnElementByXpath("//h3[@class='text-center']/a").getAttribute("href");
        assertNotNull(ref);
        assertEquals(ref, "https://github.com/epam/JDI");
        // 15. Verify there is left section.
        // TODO Why do you use xpath here? — To shorten code I use the returnElementByXpath, which requires xpath.
        assertTrue(returnElementByXpath("//div[@name='navigation-sidebar']").isDisplayed());
        // 16. Verify there is footer.
        // TODO Why do you use xpath here? — Same as above.
        assertTrue(returnElementByXpath("//div[@class='footer-content overflow']").isDisplayed());
        // 17. Close browser. — see test teardown.
    }
}
