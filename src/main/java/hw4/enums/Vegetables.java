package hw4.enums;

public enum Vegetables {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    final String vegetableValue;

    Vegetables(String vegetable) {
        vegetableValue = vegetable;
    }

    public String getVegetableValue() {
        return vegetableValue;
    }
}