package iodemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class WriteString {

    public static void main(String[] args) {
        Path path = Paths.get("trainers-output.txt");

        try {
            Files.write(path, Arrays.asList("Jack Doe", "John Doe"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
