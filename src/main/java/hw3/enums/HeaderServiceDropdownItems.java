package hw3.enums;

public enum HeaderServiceDropdownItems {

    SUPPORT_TOP_MENU_ITEM("SUPPORT"),
    DATES_TOP_MENU_ITEM("DATES"),
    SEARCH_TOP_MENU_ITEM("SEARCH"),
    COMPLEX_TOP_MENU_ITEM("COMPLEX TABLE"),
    SIMPLE_TOP_MENU_ITEM("SIMPLE TABLE"),
    USER_TOP_MENU_ITEM("USER TABLE"),
    TABLE_TOP_MENU_ITEM("TABLE WITH PAGES"),
    DIFFERENT_TOP_MENU_ITEM("DIFFERENT ELEMENTS"),
    PERFORMANCE_TOP_MENU_ITEM("PERFORMANCE");

    final String headerServiceDropDownItem;

    HeaderServiceDropdownItems(String item) {
        headerServiceDropDownItem = item;
    }

    public String getHeaderServiceDropDownItem() {
        return headerServiceDropDownItem;
    }

}
