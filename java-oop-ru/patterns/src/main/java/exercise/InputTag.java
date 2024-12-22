package exercise;

// BEGIN
import lombok.AllArgsConstructor;

@AllArgsConstructor
class InputTag implements TagInterface {
    private final String type;
    private final String value;

    @Override
    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", type, value);
    }
}
// END
