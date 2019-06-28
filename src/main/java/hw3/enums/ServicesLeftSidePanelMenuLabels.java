package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum ServicesLeftSidePanelMenuLabels {

    SUPPORT_LEFT_SIDE_MENU("Support"),
    DATES_LEFT_SIDE_MENU("Dates"),
    COMPLEX_LEFT_SIDE_MENU("Complex Table"),
    SIMPLE_LEFT_SIDE_MENU("Simple Table"),
    SEARCH_LEFT_SIDE_MENU("Search"),
    USER_LEFT_SIDE_MENU("User Table"),
    TABLE_LEFT_SIDE_MENU("Table with pages"),
    DIFFERENT_ELEMENTS_LEFT_SIDE_MENU("Different elements"),
    PERFORMANCE_LEFT_SIDE_MENU("Performance");

    final String serviceMenuLabel;

    ServicesLeftSidePanelMenuLabels(String item) {
        serviceMenuLabel = item;
    }

    public String getServiceLeftSidePanelMenuItem() {
        return serviceMenuLabel;
    }

    public static List<String> getServiceLeftSidePanelMenuItemsList() {
        List<String> menuItems = new ArrayList<>();

        for (ServicesLeftSidePanelMenuLabels label : ServicesLeftSidePanelMenuLabels.values()) {
            menuItems.add(label.getServiceLeftSidePanelMenuItem());
        }

        return menuItems;
    }
}
