package exercise;

// BEGIN
final class ReversedSequence implements CharSequence {
    private final String reversed;

    ReversedSequence(String str) {
        reversed = new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return reversed.length();
    }

    @Override
    public char charAt(int index) {
        return reversed.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reversed.subSequence(start, end);
    }

    @Override
    public String toString() {
        return reversed;
    }
}
// END
