package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderSectionTextsXpathes {

    PRACTICE_TEXT("//span[contains(@class,'icon-practise')]" +
            "//ancestor::div[@class='benefit']//span[@class='benefit-txt']"),
    CUSTOM_TEXT("//span[contains(@class,'icon-custom')]" +
            "//ancestor::div[@class='benefit']//span[@class='benefit-txt']"),
    MULTI_TEXT("//span[contains(@class,'icon-multi')]" +
            "//ancestor::div[@class='benefit']//span[@class='benefit-txt']"),
    BASE_TEXT("//span[contains(@class,'icon-base')]" +
            "//ancestor::div[@class='benefit']//span[@class='benefit-txt']");

    final String headerSectionText;

    HeaderSectionTextsXpathes(String item) {
        headerSectionText = item;
    }

    public String getHeaderSectionTextXpath() {
        return headerSectionText;
    }

    public static List<String> getListOfHeaderSectionTextXpathes() {
        List<String> textXpathes = new ArrayList<>();

        for (HeaderSectionTextsXpathes xpath : HeaderSectionTextsXpathes.values()) {
            textXpathes.add(xpath.getHeaderSectionTextXpath());
        }

        return textXpathes;
    }

}
