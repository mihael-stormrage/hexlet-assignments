package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
import lombok.AllArgsConstructor;

@AllArgsConstructor
abstract class Tag {
    protected final String type;
    private final Map<String, String> attributes;

    public String toString() {
        String attrsLine = attributes.entrySet().stream()
            .map(e -> String.format("%s=\"%s\"", e.getKey(), e.getValue()))
            .collect(Collectors.joining(" "));

        if (!attrsLine.isBlank()) {
            attrsLine = " " + attrsLine;
        }

        return String.format("<%s%s>", type, attrsLine);
    }
}
// END
