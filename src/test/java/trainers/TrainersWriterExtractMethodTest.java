package trainers;

import iodemo.TrainersWriter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TrainersWriterExtractMethodTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void writeTrainers() throws IOException {
        System.out.println(temporaryFolder.getRoot());

        Path file = temporaryFolder.getRoot().toPath().resolve("employees.txt");

        new TrainersWriter().writeTrainers(
                Arrays.asList("John Doe", "Jack Doe"),
                file
        );

        List<String> lines = Files.readAllLines(file);
        assertEquals(Arrays.asList("John Doe", "Jack Doe"), lines);
    }
}