package exercise;

// BEGIN
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
class Cottage implements Home {
    @Getter
    private final double area;

    private final int floorCount;

    @Override
    public String toString() {
        return String.format(
            "%s этажный коттедж площадью %s метров",
            floorCount,
            getArea()
        );
    }
}
// END
