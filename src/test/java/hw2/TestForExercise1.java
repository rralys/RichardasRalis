package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestForExercise1 {

    private WebDriver driver;
    private String driverPath = this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath();
    private String barPrefix = "//ul[@class='uui-navigation nav navbar-nav m-l8']";

    protected WebElement returnFirstElement(String xpathStr) {
        return driver.findElements(By.xpath(xpathStr)).get(0);
    }

    protected void login(String userName, String password) {
        returnFirstElement("//img[@id='user-icon']").click();
        returnFirstElement("//input[@id='name']").sendKeys(userName);
        returnFirstElement("//input[@id='password']").sendKeys(password);
        returnFirstElement("//button[@type='submit']").click();
    }

    @BeforeTest
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void TestScenario1() {
        driver.navigate().to("https://epam.github.io/JDI/");
        assertEquals(driver.getTitle(), "Home page");
        login("epam", "1234");
        assertEquals(returnFirstElement("//span[@id='user-name']").getText(),"Piter Chailovskii");
        assertEquals(driver.getTitle(), "Home page");
        assertEquals(returnFirstElement(barPrefix.concat("//a[@href='index.html']")).getText(), "Home");
        assertEquals(returnFirstElement(barPrefix.concat("//a[@href='contacts.html']")).getText(), "Contact form");
        assertEquals(returnFirstElement(barPrefix.concat("//a[@class='dropdown-toggle']")).getText().trim(), "Service");
        assertEquals(returnFirstElement(barPrefix.concat("//a[@href='metals-colors.html']")).getText(), "Metals & Colors");


    }

    @AfterTest
    public void destroyDriver() {
        driver.close();
    }
}
