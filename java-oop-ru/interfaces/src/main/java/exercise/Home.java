package exercise;

// BEGIN
interface Home extends Comparable<Home> {
    double getArea();

    @Override
    default int compareTo(Home o) {
        return (int) Math.signum(getArea() - o.getArea());
    }

    String toString();
}
// END
