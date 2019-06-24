package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class RunTestsForHomework2 {
    protected WebDriver driver;
    protected ChromeOptions options;
    protected String driverPath = this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath();
    protected String barPrefix = "//ul[@class='uui-navigation nav navbar-nav m-l8']";

    protected WebElement returnElementByXpath(String xpathStr) {
        return driver.findElement(By.xpath(xpathStr));
    }

    // TODO Number is unused parameter
    protected String getTextFromElementAndTrim(String xpathStr, int... number) {
        return returnElementByXpath(xpathStr).getText().trim();
    }

    protected void clickElementByXpath(String xpath) {
        returnElementByXpath(xpath).click();
    }

    protected void clickCheckBoxAndVerifyChecked(String checkBoxName) {
        String xpath = "//label[text()[contains(.,'" + checkBoxName + "')]]";
        clickElementByXpath(xpath);
        assertTrue(returnElementByXpath(xpath + "//descendant-or-self::input[@type='checkbox']").isSelected());
    }

    protected void clickCheckBoxAndVerifyUnchecked(String checkBoxName) {
        String xpath = "//label[text()[contains(.,'" + checkBoxName + "')]]";
        clickElementByXpath(xpath);
        assertFalse(returnElementByXpath(xpath + "//descendant-or-self::input[@type='checkbox']").isSelected());
    }

    protected void verifyLogStateAfterCheckBoxClick(String checkBoxName, boolean state) {
        assertTrue(returnElementByXpath("//li[text()[contains(.,'" + checkBoxName + ": condition changed to " + String.valueOf(state) +"')]]").isDisplayed());
    }

    protected void login(String userName, String password) {
        clickElementByXpath("//img[@id='user-icon']");
        returnElementByXpath("//input[@id='name']").sendKeys(userName);
        returnElementByXpath("//input[@id='password']").sendKeys(password);
        clickElementByXpath("//button[@type='submit']");
    }

    protected void verifyPageTitle(String expTitle) {
        assertEquals(driver.getTitle(), expTitle);
    }

    protected void verifyListOfLabelsFromXpath(String elementXpath, List<String> expLabels) {
        List<WebElement> itemsToVerify = driver.findElements(By.xpath(elementXpath));
        List<String> actualLabels = new ArrayList<String>();

        for (WebElement item : itemsToVerify) {
            actualLabels.add(item.getText().trim());
        }

        assertEquals(actualLabels, expLabels);
    }

    protected void verifyListOfLabelsFromListOfXpathes(List<String> elementsXpathes, List<String> expLabels) {
        List<String> actualLabels = new ArrayList<String>();

        for (String curXpath : elementsXpathes) {
            actualLabels.add((driver.findElement(By.xpath(curXpath)).getText().trim()));
        }

        assertEquals(actualLabels, expLabels);
    }

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeMethod
    public void createDriver() {
        options = new ChromeOptions();
        options.addArguments("--no-sandbox",  "start-maximized");
        driver = new ChromeDriver(options);

        System.out.println("Driver is ready.");
    }

    @AfterMethod
    public void destroyDriver() {
        driver.close();
    }

}
