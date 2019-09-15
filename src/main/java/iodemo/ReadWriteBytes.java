package iodemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadWriteBytes {

    public static void main(String[] args) {
        Path path = Paths.get("data.dat");

        byte[] bytes = new byte[100];
        Arrays.fill(bytes,(byte) 97);
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            byte[] bytesFromFile = Files.readAllBytes(path);
            System.out.println(Arrays.toString(bytesFromFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
