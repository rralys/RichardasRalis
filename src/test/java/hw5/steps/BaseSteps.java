package hw5.steps;

import hw5.DifferentServices;
import hw5.HomePage;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentServices difServ;

    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();
}
