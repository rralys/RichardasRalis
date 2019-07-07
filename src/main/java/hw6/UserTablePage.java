package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends BasePage {

    private static UserTablePage instance;

    public static UserTablePage getInstance(WebDriver dr) {
        if ((instance == null) || (instance.driver != null)) {
            instance = new UserTablePage(dr);
        }

        return instance;
    }

    public UserTablePage(WebDriver dr) {
        super(dr);
    }

    @FindAll({
            @FindBy(xpath = "//tr/td/select")
    })
    private List<WebElement> dropDowns;

    @FindAll({
            @FindBy(xpath = "//table[@id='user-table']//td[contains(text(), .)]")
    })
    private List<WebElement> userIDs;

    @FindAll({
            @FindBy(xpath = "//tr/td/a[@href]")
    })
    private List<WebElement> userNames;

    @FindAll({
            @FindBy(xpath = "//tr/td/img")
    })
    private List<WebElement> userImages;

    @FindAll({
            @FindBy(xpath = "//div[@class='user-descr']/span")
    })
    private List<WebElement> userDesc;

    @FindAll({
            @FindBy(xpath = "//tr/td//input")
    })
    private List<WebElement> checkBoxes;

    @FindBy(className = "info-panel-section")
    private WebElement logRecord;

    public int getNumberOfDropDowns() {
        return dropDowns.size();
    }

    public int getNumberOfUserNames() {
        return userNames.size();
    }

    public int getNumberOfUserImages() {
        return userImages.size();
    }

    public int getNumberOfUserDescriptions() {
        return userDesc.size();
    }

    public int getNumberOfUserCheckBoxes() {
        return checkBoxes.size();
    }

    public List<String> getUserNamesInThePage() {
        List<String> names = new ArrayList<>();

        for (WebElement element : userNames) {
            names.add(element.getText());
        }

        return names;
    }

    public List<String> getUserIDsInThePage() {
        List<String> IDs = new ArrayList<>();

        for (WebElement element : userIDs) {
            IDs.add(element.getText());
        }

        return IDs;
    }

    public List<String> getUserDescriptionsInThePage() {
        List<String> descs = new ArrayList<>();

        for (WebElement element : userDesc) {
            descs.add(element.getText().replace("\n", " "));
        }

        return descs;
    }

    public void setUserCheckBoxByLabel(String label) {
        driver.findElement(By
                .xpath("//a[text()='" + label + "']//ancestor::td//following-sibling::td//input"))
                .click();
    }

    public String getLogText() {
        return logRecord.getText();
    }

    public void clickDropDownForUser(String userName) {
        driver.findElement(By
                .xpath("//a[text()='" + userName + "']//ancestor::td//preceding::td//select"))
                .click();
    }

    public List<String> getDropDownOptionsForUser(String userName) {
        List<WebElement> options = driver.findElements(By
        .xpath("//a[text()='" + userName + "']//ancestor::td//preceding::td//option"));

        List<String> optionLabels = new ArrayList<>();

        for (WebElement option : options) {
            optionLabels.add(option.getText().trim());
        }

        return optionLabels;
    }
}
