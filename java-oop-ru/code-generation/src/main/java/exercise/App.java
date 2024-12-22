package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
import java.io.IOException;

class App {
    public static void save(Path path, Car car) throws IOException {
        Files.writeString(path, car.serialize(), StandardOpenOption.WRITE);
    }

    public static Car extract(Path path) throws IOException {
        return Car.deserialaze(Files.readString(path));
    }
}
// END
