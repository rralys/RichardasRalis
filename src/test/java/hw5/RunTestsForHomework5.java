package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.FileUtils;

public class RunTestsForHomework5 {
    protected WebDriver driver;
    protected ChromeOptions options;

    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();

    protected String uName;
    protected String uPass;

    private void getUserProperties() {

        uName = FileUtils.readPropertiesFile(propertiesPath + "/user.properties")
                .getProperty("user.name");

        uPass = FileUtils.readPropertiesFile(propertiesPath + "/user.properties")
                .getProperty("user.password");

    }


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

        getUserProperties();
    }

    @AfterMethod
    public void destroyDriver() {
        driver.close();
    }

}
