package hw4.enums;

public enum Metals {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String metalValue;

    Metals(String metal) {
        metalValue = metal;
    }

    public String getMetalValue() {
        return metalValue;
    }

}
