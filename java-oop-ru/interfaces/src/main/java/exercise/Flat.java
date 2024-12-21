package exercise;

// BEGIN
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public String toString() {
        return String.format(
            "Квартира площадью %s метров на %s этаже",
            getArea(),
            floor
        );
    }
}
// END
