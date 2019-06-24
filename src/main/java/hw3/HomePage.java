package hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy (xpath = "//span[@id='user-name']")
    private WebElement userIcon;

    @FindBy (xpath = "//input[@id='name']")
    private WebElement userNameInput;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement userPasswordInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement submitLoginButton;

    public void login(String uName, String uPass) {
        userIcon.click();
        userNameInput.sendKeys(uName);
        userPasswordInput.sendKeys(uPass);
        submitLoginButton.click();
    }
}
