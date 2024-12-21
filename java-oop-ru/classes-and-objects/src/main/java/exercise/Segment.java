package exercise;

import lombok.Getter;

// BEGIN
@Getter
final class Segment {
    final Point beginPoint;
    final Point endPoint;
    final Point midPoint;

    public Segment(Point begin, Point end) {
        beginPoint = begin;
        endPoint = end;
        midPoint = buildMidPoint();
    }

    private Point buildMidPoint() {
        final int x = endPoint.getX() - beginPoint.getX();
        final int y = endPoint.getY() - beginPoint.getY();
        return new Point(x, y);
    }
}
// END
