package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;

import static org.testng.Assert.assertEquals;

public class TestForExercise1 {

    private WebDriver driver;
    private String driverPath = this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath();
    private String barPrefix = "//ul[@class='uui-navigation nav navbar-nav m-l8']";

    protected WebElement returnElementByNumber(String xpathStr, int... number ) {
        /*
        * The method returns the 1st element by default, if no number is specified, if the number is specified it returns the element with that number.*/

        WebElement element;

        if (number.length == 0) {
            element = driver.findElements(By.xpath(xpathStr)).get(0);
        } else {
            element = driver.findElements(By.xpath(xpathStr)).get(number[0]);
        }

        return element;
    }

    protected void login(String userName, String password) {
        returnElementByNumber("//img[@id='user-icon']").click();
        returnElementByNumber("//input[@id='name']").sendKeys(userName);
        returnElementByNumber("//input[@id='password']").sendKeys(password);
        returnElementByNumber("//button[@type='submit']").click();
    }

    @BeforeTest
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--verbose --log-path=chromedriver.log",  "start-maximized");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);

        System.out.println("Driver is ready.");
    }

    @Test
    public void TestScenario1() {
        driver.get("https://epam.github.io/JDI/");
        assertEquals(driver.getTitle(), "Home Page");
        login("epam", "1234");
        assertEquals(returnElementByNumber("//span[@id='user-name']").getText(),"Piter Chailovskii");
        assertEquals(driver.getTitle(), "Home Page");
        assertEquals(returnElementByNumber(barPrefix.concat("//a[@href='index.html']")).getText(), "Home");
        assertEquals(returnElementByNumber(barPrefix.concat("//a[@href='contacts.html']")).getText(), "Contact form");
        assertEquals(returnElementByNumber(barPrefix.concat("//a[@class='dropdown-toggle']")).getText().trim(), "Service");
        assertEquals(returnElementByNumber(barPrefix.concat("//a[@href='metals-colors.html']")).getText(), "Metals & Colors");


    }

    @AfterTest
    public void destroyDriver() {
        driver.close();
    }
}
