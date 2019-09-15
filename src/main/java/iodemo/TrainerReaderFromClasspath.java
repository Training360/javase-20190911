package iodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class TrainerReaderFromClasspath {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        TrainerReaderFromClasspath.class.getResourceAsStream("trainers.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
