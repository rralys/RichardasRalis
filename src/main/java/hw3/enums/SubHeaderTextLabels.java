package hw3.enums;

public enum SubHeaderTextLabels {

    SUB_HEADER_TEXT_LABEL("JDI GITHUB");

    final String subHeaderTextLabel;

    SubHeaderTextLabels(String item) {
        subHeaderTextLabel = item;
    }

    public String getSubHeaderTextLabel() {
        return subHeaderTextLabel;
    }

}
