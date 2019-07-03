package hw5.enums;

import java.util.ArrayList;
import java.util.List;

public enum TopPanelMenuLabels {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String topPanelMenuItemLabel;

    TopPanelMenuLabels(String item) {
        topPanelMenuItemLabel = item;
    }

    public String getTopPanelMenuItemLabel() {
        return topPanelMenuItemLabel;
    }

    public static List<String> getListOfTopPanelMenuItems() {

        List<String> topPanelMenuItems = new ArrayList<>();

        for (TopPanelMenuLabels item : TopPanelMenuLabels.values()) {
            topPanelMenuItems.add(item.getTopPanelMenuItemLabel());
        }

        return topPanelMenuItems;

    }

}
