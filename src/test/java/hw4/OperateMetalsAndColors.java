package hw4;

import com.codeborne.selenide.Condition;
import hw4.basepage.MetalsAndColorsPage;
import hw4.builder.MetalsAndColorsBuilder;
import hw4.enums.Elements;
import hw4.enums.Vegetables;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class OperateMetalsAndColors extends RunTestsForHomework4{

    MetalsAndColorsPage mcp = new MetalsAndColorsPage();

    public void setMetalsAndColorsSummary(List<String> summaryLabels) {
        mcp.setSummary(summaryLabels);
    }

    public void setMetalsAndColorsElements(List<Elements> elementsList) {
        mcp.setElementsCheckbox(elementsList);
    }

    public void setMetalsAndColorsColor(String color) {
        mcp.setColorsDropdown(color);
    }

    public void SetMetalsAndColorsMetal(String metal) {
        mcp.setMetalsDropdown(metal);
    }

    public void setMetalsAndColorsVegetables(List<Vegetables> vegetables) {
        if (vegetables == null) { return; }

        List<String> vegetablesLabels = new ArrayList<>();

        for (Vegetables veg : vegetables) {
            vegetablesLabels.add(veg.getVegetableValue());
        }

        mcp.setVegetablesDropdown(vegetablesLabels);
    }

    public void submitForm() {
        mcp.submitClick();
    }

    public String calculateSummary(List<String> summaries) {
        if (summaries == null) { return FileUtils.
                readPropertiesFile(propertiesPath + "/summary.properties").
                getProperty("summary.default"); }

        int sum = 0;

        for (String summary : summaries) {
            sum += Integer.valueOf(summary);
        }

        return String.valueOf(sum);

    }

    public void verifySubmittedForm(MetalsAndColorsBuilder build) {
        // TODO Could be used static import for the Condition.matchesText — I'm not sure I understand what to do here.
        mcp.getSummaryLog().shouldHave(Condition.matchesText(calculateSummary(build.getSummaryRadio())));
        if (build.getElements() != null) {
            for (Elements elementItem : build.getElements()) {
                mcp.getElementsLog().shouldHave(Condition.matchesText(elementItem.getElementValue()));
            }
        }

        if (build.getColors() != null) {
            mcp.getColorLog().shouldHave(Condition.matchesText(build.getColors()));
        } else {
            mcp.getColorLog().shouldHave(Condition.matchesText(FileUtils.
                    readPropertiesFile(propertiesPath + "/log.properties").
                    getProperty("default.color")));
        }

        if (build.getMetal() != null) {
            mcp.getMetalLog().shouldHave(Condition.matchesText(build.getMetal()));
        } else {
            mcp.getMetalLog().shouldHave(Condition.matchesText(FileUtils.
                    readPropertiesFile(propertiesPath + "/log.properties").
                    getProperty("default.metal")));
        }

        if (build.getVegetables() != null) {
            for (Vegetables veg : build.getVegetables()) {
                mcp.getVegetablesLog().shouldHave(Condition.matchesText(veg.getVegetableValue()));
            }
        } else {
            mcp.getVegetablesLog().shouldHave(Condition.matchesText(FileUtils.
                    readPropertiesFile(propertiesPath + "/log.properties").
                    getProperty("default.vegetable")));
        }

    }

}
