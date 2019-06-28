package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderSectionTextsLabels {

    PRACTICE_LABEL("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM_LABEL("To be flexible and\ncustomizable"),
    MULTI_LABEL("To be multiplatform"),
    BASE_LABEL("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    final String headerSectionTextLabel;

    HeaderSectionTextsLabels(String item) {
        headerSectionTextLabel = item;
    }

    public String getHeaderSectionTextLabel() {
        return headerSectionTextLabel;
    }

    public static List<String> getListOfHeaderSectionTextLabels() {
        List<String> labelsList = new ArrayList<>();

        for (HeaderSectionTextsLabels label : HeaderSectionTextsLabels.values()) {
            labelsList.add(label.getHeaderSectionTextLabel());
        }

        return labelsList;
    }
}
