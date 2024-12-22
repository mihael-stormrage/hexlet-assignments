package exercise;

// BEGIN
import lombok.NoArgsConstructor;

@NoArgsConstructor
class NegativeRadiusException extends Exception {
    NegativeRadiusException(String message) {
        super(message);
    }
}
// END
