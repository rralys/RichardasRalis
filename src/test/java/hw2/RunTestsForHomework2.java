package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class RunTestsForHomework2 {
    protected WebDriver driver;
    protected ChromeOptions options;
    protected String driverPath = this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath();
    protected String barPrefix = "//ul[@class='uui-navigation nav navbar-nav m-l8']";

    protected WebElement returnElementByXpath(String xpathStr) {
        return driver.findElement(By.xpath(xpathStr));
    }

    protected String getTextFromElementAndTrim(String xpathStr, int... number) {
        return returnElementByXpath(xpathStr).getText().trim();
    }

    protected void login(String userName, String password) {
        returnElementByXpath("//img[@id='user-icon']").click();
        returnElementByXpath("//input[@id='name']").sendKeys(userName);
        returnElementByXpath("//input[@id='password']").sendKeys(password);
        returnElementByXpath("//button[@type='submit']").click();
    }

    @BeforeClass
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        options = new ChromeOptions();
        options.addArguments("--no-sandbox",  "start-maximized");
        driver = new ChromeDriver(options);

        System.out.println("Driver is ready.");
    }

    @AfterClass
    public void destroyDriver() {
        driver.close();
    }

}
