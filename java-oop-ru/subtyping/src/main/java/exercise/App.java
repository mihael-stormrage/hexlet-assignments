package exercise;

//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        storage.toMap().forEach((k, v) -> {
            storage.unset(k);
            storage.set(v, k);
        });
    }
}
// END
