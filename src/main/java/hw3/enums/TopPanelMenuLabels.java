package hw3.enums;

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

}
