package exercise;

// BEGIN
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LabelTag implements TagInterface {
    private final String text;
    private final TagInterface child;

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", text, child.render());
    }
}
// END
