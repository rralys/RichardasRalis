package hw3.enums;

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

}
