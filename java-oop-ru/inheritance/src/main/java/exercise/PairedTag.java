package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private final String text;
    private final List<Tag> children;

    PairedTag(String type, Map<String, String> attributes, String text, List<Tag> children) {
        super(type, attributes);
        this.text = text;
        this.children = children;
    }

    @Override
    public String toString() {
        String renderedChildren = children.stream()
            .map(Tag::toString)
            .collect(Collectors.joining(""));

        return String.format("%s%s%s</%s>", super.toString(), text, renderedChildren, type);
    }
}
// END
