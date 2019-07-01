package hw4.enums;

public enum Colors {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String colorValue;

    Colors(String color) {
        colorValue = color;
    }

    public String getColorValue() {
        return colorValue;
    }

}
