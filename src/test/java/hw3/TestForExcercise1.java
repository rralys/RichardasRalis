package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestForExcercise1 extends RunTestsForHomework3 {

    @Test
    public void TestScenario1() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        // 1. Open the page.
        //driver.get("https://epam.github.io/JDI/");
        // 2. Check page title.
        assertEquals(driver.getTitle(), "Home Page");
        // 3. Login.
        hp.login("epam", "1234");
        // 4. Verify user name.
        assertEquals(getTextFromElementAndTrim("//span[@id='user-name']"),"PITER CHAILOVSKII");
        // 5. Verify page title after login.
        assertEquals(driver.getTitle(), "Home Page");
        // 6. Verify that header has the correct four items.
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@href='index.html']")), "HOME");
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@href='contacts.html']")), "CONTACT FORM");
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@class='dropdown-toggle']")), "SERVICE");
        assertEquals(getTextFromElementAndTrim(barPrefix.concat("//a[@href='metals-colors.html']")), "METALS & COLORS");
        // 7. Verify that index page has four images present and displayed.
        assertEquals(driver.findElements(By.xpath("//div[@class='benefit']")).size(), 4);
        assertNotNull(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-practise']"));
        assertNotNull(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-custom']"));
        assertNotNull(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-multi']"));
        assertNotNull(returnElementByXpath("//div[@class='benefit']//span[@class='icons-benefit icon-base']"));
        // 8. Verify that index page contains four text elements below the images and the text content is correct.
        assertEquals(driver.findElements(By.xpath("//ancestor::div[@class='benefit-icon']//following-sibling::span[@class='benefit-txt']")).size(), 4);
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-practise']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-custom']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "To be flexible and\ncustomizable");
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-multi']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "To be multiplatform");
        assertEquals(getTextFromElementAndTrim("//span[@class='icons-benefit icon-base']//ancestor::div[@class='benefit']//following-sibling::span[@class='benefit-txt']"), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");
        // 9. Verify text in headers.
        assertEquals(getTextFromElementAndTrim("//h3[@ui='title']"), "EPAM FRAMEWORK WISHES\u2026");
        assertEquals(getTextFromElementAndTrim("//p[@ui='text']"), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        // 10. Verify that there is a frame element.
        assertEquals(driver.findElements(By.tagName("iframe")).size(), 1);
        // 11. Switch to that frame and verify there is the EPAM logo in the frame.
        driver.switchTo().frame("iframe");
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
        assertNotNull(returnElementByXpath("//div[@name='navigation-sidebar']"));
        // 16. Verify there is footer.
        assertNotNull(returnElementByXpath("//div[@class='footer-content overflow']"));
        // 17. Close browser. — see test teardown.
    }
}
