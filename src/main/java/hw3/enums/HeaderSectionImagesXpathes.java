package hw3.enums;

public enum HeaderSectionImagesXpathes {

    PRACTICE("//span[contains(@class,'icon-practise')]"),
    CUSTOM("//span[contains(@class,'icon-custom')]"),
    MULTI("//span[contains(@class,'icon-multi')]"),
    BASE("//span[contains(@class,'icon-base')]");

    final String leftSideMenuItem;

    HeaderSectionImagesXpathes(String item) {
        leftSideMenuItem = item;
    }

    public String getHeaderSectionImageXpath() {
        return leftSideMenuItem;
    }

}
