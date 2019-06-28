package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum MainHeaderTextXpathes {

    MAIN_TITLE_XPATH("//h3[@ui='title']"),
    MAIN_TEXT_PATH("//p[@ui='text']");

    final String mainHeaderTextXpath;

    MainHeaderTextXpathes(String item) {
        mainHeaderTextXpath = item;
    }

    public String getMainHeaderTextXpath() {
        return mainHeaderTextXpath;
    }

    public static List<String> getListOfMainHeaderTextXpathes() {
        List<String> textXpathes = new ArrayList<>();

        for (MainHeaderTextXpathes xpath : MainHeaderTextXpathes.values()) {
            textXpathes.add(xpath.getMainHeaderTextXpath());
        }

        return textXpathes;
    }

}
