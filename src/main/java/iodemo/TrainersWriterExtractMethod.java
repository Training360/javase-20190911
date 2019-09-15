package iodemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TrainersWriterExtractMethod {

    public void write(List<String> names, Writer w)
        throws IOException {
        for (String name: names) {
            w.write(name + ";");
        }
    }

    public static void main(String[] args) {
        Path file = Paths.get("names.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            new TrainersWriterExtractMethod().write(
                    Arrays.asList("John Doe", "Jack Doe"),
                    writer
            );
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
