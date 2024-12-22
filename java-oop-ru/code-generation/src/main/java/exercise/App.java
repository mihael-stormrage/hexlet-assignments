package exercise;

import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
import java.io.IOException;

class App {
    public static void save(Path path, Car car) throws IOException {
        Files.write(path, car.serialize().getBytes());
    }

    public static Car extract(Path path) throws IOException {
        return Car.deserialaze(Files.readString(path));
    }
}
// END
