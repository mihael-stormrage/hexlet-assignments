package exercise;

// BEGIN
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
class Circle {
    private final Point center;

    @Getter
    private final int radius;

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException();
        }
        return Math.pow(radius, 2) * Math.PI;
    }
}
// END
