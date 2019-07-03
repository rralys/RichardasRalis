package hw5.enums;

import java.util.ArrayList;
import java.util.List;

public enum MainHeaderTextLabels {

    MAIN_TITLE_LABEL("EPAM FRAMEWORK WISHES…"),
    MAIN_TEXT_LABEL("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
            " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
            "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT" +
            " IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    final String mainHeaderTextLabel;

    MainHeaderTextLabels(String item) {
        mainHeaderTextLabel = item;
    }

    public String getMainHeaderTextLabel() {
        return mainHeaderTextLabel;
    }

    public static List<String> getListOfMainHeaderTextLabels() {
        List<String> textLabels = new ArrayList<>();

        for (MainHeaderTextLabels label : MainHeaderTextLabels.values()) {
            textLabels.add(label.getMainHeaderTextLabel());
        }

        return textLabels;
    }
}
