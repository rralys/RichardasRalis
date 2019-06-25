package hw3.enums;

public enum TopPanelMenu {

    HOME("//a[@href='index.html']"),
    CONTACT_FORM("//a[@href='contacts.html']"),
    SERVICE("//a[@class='dropdown-toggle']"),
    METALS_AND_COLORS("//a[@href='metals-colors.html']");

    final String leftSideMenuItem;

    TopPanelMenu(String item) {
        leftSideMenuItem = item;
    }

    public String getLeftSidePanelMenuItem() {
        return leftSideMenuItem;
    }

}
