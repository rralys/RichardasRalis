package hw4;

import com.codeborne.selenide.SelenideElement;
import hw4.basepage.TableWithPagesPage;
import utils.FileUtils;

import static com.codeborne.selenide.Condition.*;

public class OperateTableWithPages extends RunTestsForHomework4 {
    TableWithPagesPage twp = new TableWithPagesPage();

    public void verifySelectedShowDropdown() {

        twp.getShowEntriesDropdown().getSelectedOption().shouldHave(text(
                FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                        .getProperty("show.dropdown.visible")
        ));

    }

    public void verifyRightSectionIsPresent() {
        twp.getRightSection().shouldBe(visible);
    }

    public void verifyLeftSectionIsPresent() {
        twp.getLeftSection().shouldBe(visible);
    }

    public void selectShowValue() {
        twp.setShowEntriesDropdown(
                FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                        .getProperty("show.dropdown.to.select")
        );
    }

    public void verifyLogContainsNewShowValueInfo() {
        twp.getLogSection().shouldHave(text(
                FileUtils.readPropertiesFile(propertiesPath + "/log.properties")
                        .getProperty("length.new.value")
        ));
    }

    public void verifyNumberOfTableRows() {
        twp.getTableElements().shouldHaveSize(
                Integer.parseInt(
                        FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                                .getProperty("show.dropdown.to.select")
                ));
    }

    public void setInputSearchValue() {
        twp.setInputSearch(FileUtils.readPropertiesFile(propertiesPath + "/search.properties")
                .getProperty("search.input.value"));
    }

    public void verifySearchHits() {

        for (SelenideElement element : twp.getTableElements()) {
            element.shouldHave(matchesText(
                    FileUtils.readPropertiesFile(propertiesPath + "/search.properties")
                            .getProperty("search.input.value")
            ));
        }
    }

}
