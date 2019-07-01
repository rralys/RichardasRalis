package hw4.enums;

public enum Elements {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final String elementValue;

    Elements(String element) {
        elementValue = element;
    }

    public String getElementValue() {
        return elementValue;
    }

}
