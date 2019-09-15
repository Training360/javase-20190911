package iodemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileAsString {

    public static void main(String[] args) {
        Path file = Paths.get("classpath/trainers.txt");
        try {
            //String content = Files.readString(file);
            // Charset.forName("ISO-8859-2")
            // StandardCharsets.UTF_8
            List<String> content = Files.readAllLines(file);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace(); // SOHA DE SOHA ILYET NEM CSINALUNK
        }
    }
}
