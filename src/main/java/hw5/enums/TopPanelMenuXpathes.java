package hw5.enums;

import java.util.ArrayList;
import java.util.List;

public enum TopPanelMenuXpathes {

    HOME("//a[@href='index.html']"),
    CONTACT_FORM("//a[@href='contacts.html']"),
    SERVICE("//a[@class='dropdown-toggle']"),
    METALS_AND_COLORS("//a[@href='metals-colors.html']");

    final String topPanelMenuItemXpath;

    TopPanelMenuXpathes(String item) {
        topPanelMenuItemXpath = item;
    }

    public String getTopPanelMenuItemXpath() {
        return topPanelMenuItemXpath;
    }

    public static List<String> getTopPanelMenuXpathesList() {
        List<String> topPanelMenuItemsXpathes = new ArrayList<>();

        for (TopPanelMenuXpathes item : TopPanelMenuXpathes.values()) {
            topPanelMenuItemsXpathes.add(item.getTopPanelMenuItemXpath());
        }

        return topPanelMenuItemsXpathes;

    }

}
