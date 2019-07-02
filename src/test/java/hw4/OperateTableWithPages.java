package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import hw4.basepage.TableWithPagesPage;
import utils.FileUtils;

public class OperateTableWithPages extends RunTestsForHomework4 {
    TableWithPagesPage twp = new TableWithPagesPage();

    public void verifySelectedShowDropdown() {

        twp.getShowEntriesDropdown().getSelectedOption().shouldHave(Condition.text(
                FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                        .getProperty("show.dropdown.visible")
        ));

    }

    public void verifyRightSectionIsPresent() {
        twp.getRightSection().shouldBe(Condition.visible);
    }

    public void verifyLeftSectionIsPresent() {
        twp.getLeftSection().shouldBe(Condition.visible);
    }

    public void selectShowValue() {
        twp.setShowEntriesDropdown(
                FileUtils.readPropertiesFile(propertiesPath + "/show.properties")
                        .getProperty("show.dropdown.to.select")
        );
    }

    public void verifyLogContainsNewShowValueInfo() {
        twp.getLogSection().shouldHave(Condition.text(
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
            element.shouldHave(Condition.matchesText(
                    FileUtils.readPropertiesFile(propertiesPath + "/search.properties")
                            .getProperty("search.input.value")
            ));
        }
    }

}
