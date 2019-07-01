package hw4;

import hw4.builder.MetalsAndColorsBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.Metals.*;
import static hw4.enums.Colors.*;
import static hw4.enums.Elements.*;
import static hw4.enums.Vegetables.*;

public class DataProviders {

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{
                {MetalsAndColorsBuilder.builder()
                        .elements(Arrays.asList(EARTH))
                        .colors(YELLOW.getColorValue())
                        .metal(GOLD.getMetalValue())
                        .build()},
                {MetalsAndColorsBuilder.builder()
                        .summaryRadio(Arrays.asList("3", "8"))
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO))
                        .build()},
                {MetalsAndColorsBuilder.builder()
                        .summaryRadio(Arrays.asList("3", "2"))
                        .elements(Arrays.asList(WIND, FIRE, WATER))
                        .metal(BRONZE.getMetalValue())
                        .vegetables(Arrays.asList(ONION))
                        .build()},
                {MetalsAndColorsBuilder.builder()
                        .elements(Arrays.asList(FIRE))
                        .colors(BLUE.getColorValue())
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO, VEGETABLES))
                        .build()},
                {MetalsAndColorsBuilder.builder()
                        .summaryRadio(Arrays.asList("6", "5"))
                        .elements(Arrays.asList(WATER))
                        .colors(GREEN.getColorValue())
                        .metal(SELEN.getMetalValue())
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO, ONION, VEGETABLES))
                        .build()}
        };
    }
}


