package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssuePriority {

    NONE("none"),
    LOW("low"),
    NORMAL("normal"),
    HIGH("high"),
    URGENT("urgent"),
    IMMEDIATE("immediate");

    private final String value;
}
