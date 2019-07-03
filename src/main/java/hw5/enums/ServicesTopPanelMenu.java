package hw5.enums;

public enum ServicesTopPanelMenu {

    SUPPORT("//ul[@class='dropdown-menu']//a[@href='support.html']"),
    DATES("//ul[@class='dropdown-menu']//a[@href='dates.html']"),
    SEARCH("//ul[@class='dropdown-menu']//a[@href='search.html']"),
    COMPLEX_TABLE("//ul[@class='dropdown-menu']//a[@href='complex-table.html']"),
    SIMPLE_TABLE("//ul[@class='dropdown-menu']//a[@href='simple-table.html']"),
    USER_TABLE("//ul[@class='dropdown-menu']//a[@href='user-table.html']"),
    TABLE_WITH_PAGES("//ul[@class='dropdown-menu']//a[@href='table-pages.html']"),
    DIFFERENT_ELEMENTS("//ul[@class='dropdown-menu']//a[@href='different-elements.html']"),
    PERFORMANCE("//ul[@class='dropdown-menu']//a[@href='performance.html']");

    final String topPanelMenuItem;

    ServicesTopPanelMenu(String item) {
        topPanelMenuItem = item;
    }

    public String getTopPanelMenuItem() {
        return topPanelMenuItem;
    }

}
