package hw4.builder;

import hw4.enums.Elements;
import hw4.enums.Vegetables;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class MetalsAndColorsBuilder {

    private List<String> summaryRadio;
    private List<Elements> elements;
    private List<Vegetables> vegetables;
    private String colors;
    private String metal;
}
