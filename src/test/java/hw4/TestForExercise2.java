package hw4;

import hw4.builder.MetalsAndColorsBuilder;
import org.testng.annotations.Test;

public class TestForExercise2 extends RunTestsForHomework4 {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testData")
    public void TestScenario2(MetalsAndColorsBuilder build) {
        openMetalsAndColorsPage();
        setMetalsAndColorsSummary(build.getSummaryRadio());
        setMetalsAndColorsElements(build.getElements());
        setMetalsAndColorsColor(build.getColors());
        SetMetalsAndColorsMetal(build.getMetal());
        setMetalsAndColorsVegetables(build.getVegetables());
        submitForm();
        verifySubmittedForm(build);
    }
}
