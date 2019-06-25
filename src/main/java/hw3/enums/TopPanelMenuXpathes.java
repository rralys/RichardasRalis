package hw3.enums;

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

}
