package exercise;

import lombok.Getter;

// BEGIN
@Getter
final class Segment {
    private final Point beginPoint;
    private final Point endPoint;
    private final Point midPoint;

    Segment(Point begin, Point end) {
        beginPoint = begin;
        endPoint = end;
        midPoint = buildMidPoint();
    }

    private Point buildMidPoint() {
        final int x = calculateMid(beginPoint.getX(), endPoint.getX());
        final int y = calculateMid(beginPoint.getY(), endPoint.getY());
        return new Point(x, y);
    }

    private int calculateMid(int a, int b) {
        return (a + b) / 2;
    }
}
// END
