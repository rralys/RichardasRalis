package hw5;

import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected WebDriver driver;
    protected HomePage homePage;

    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();
}
