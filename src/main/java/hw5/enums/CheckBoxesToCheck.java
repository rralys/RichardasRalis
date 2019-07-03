package hw5.enums;

public enum CheckBoxesToCheck {

    WATER("Water"),
    WIND("Wind");

    private final String checkBox;

    CheckBoxesToCheck(String item) {
        checkBox = item;
    }

    public String getCheckBoxLabel() {
        return checkBox;
    }

}
