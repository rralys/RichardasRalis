package hw3.enums;

public enum ServicesLeftSidePanelMenu {

    SUPPORT("//ul[@class='sub']//a[@href='support.html']"),
    DATES("//ul[@class='sub']//a[@href='dates.html']"),
    COMPLEX_TABLE("//ul[@class='sub']//a[@href='complex-table.html']"),
    SIMPLE_TABLE("//ul[@class='sub']//a[@href='simple-table.html']"),
    SEARCH("//ul[@class='sub']//a[@href='search.html']"),
    USER_TABLE("//ul[@class='sub']//a[@href='user-table.html']"),
    TABLE_WITH_PAGES("//ul[@class='sub']//a[@href='table-pages.html']"),
    DIFFERENT_ELEMENTS("//ul[@class='sub']//a[@href='different-elements.html']"),
    PERFORMANCE("//ul[@class='sub']//a[@href='performance.html']");

    final String leftSidePanelMenuItem;

    ServicesLeftSidePanelMenu(String item) {
        leftSidePanelMenuItem = item;
    }

    public String getLeftSidePanelMenuItem() {
        return leftSidePanelMenuItem;
    }

}
