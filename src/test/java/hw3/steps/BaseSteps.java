package hw3.steps;

import hw3.basepage.DifferentServices;
import hw3.basepage.HomePage;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected WebDriver driver;
    protected DifferentServices difServ;
    protected HomePage homePage;

    protected String propertiesPath = this.getClass().getClassLoader().getResource("properties").getPath();
}
