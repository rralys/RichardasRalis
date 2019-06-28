package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class RunTestsForHomework3 {
    protected WebDriver driver;
    protected ChromeOptions options;

    @BeforeSuite
    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void createDriver() {
        options = new ChromeOptions();
        options.addArguments("--no-sandbox",  "start-maximized");
        driver = new ChromeDriver(options);

        System.out.println("Driver is ready.");

        driver.get("https://epam.github.io/JDI/");
    }

    @AfterMethod
    public void destroyDriver() {
        driver.close();
    }

}
