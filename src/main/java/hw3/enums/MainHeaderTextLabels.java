package hw3.enums;

public enum MainHeaderTextLabels {

    MAIN_TITLE_LABEL("EPAM FRAMEWORK WISHES…"),
    MAIN_TEXT_LABEL("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD\n" +
            "                    TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD\n" +
            "                    EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
            "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN\n" +
            "                    REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    final String mainHeaderTextLabel;

    MainHeaderTextLabels(String item) {
        mainHeaderTextLabel = item;
    }

    public String getMainHeaderTextLabel() {
        return mainHeaderTextLabel;
    }
}
