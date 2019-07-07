package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "start-maximized");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        TestContext.setDriver(driver);

    }

    @After
    public void tearDown() {
        TestContext.getDriver().close();
    }
}
