package iodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TrainersWriterReader {

    public static void main(String[] args) {

        List<String> employees = Arrays.asList("John Doe", "Jane Doe", "Jack Doe");
        Path file = Paths.get("employees.txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String employee: employees) {
                double age = 27.5;
                writer.print(employee);
                writer.println(age);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        Path path = Paths.get("classpath/trainers.txt");

        // Files.newBufferedWriter(path, StandardOpenOption.APPEND)

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
