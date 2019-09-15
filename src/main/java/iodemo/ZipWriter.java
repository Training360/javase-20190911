package iodemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter {

    public static void main(String[] args) {
        try (ZipOutputStream outputStream =
                new ZipOutputStream(new BufferedOutputStream(
                        Files.newOutputStream(Paths.get("data.zip"))));
             PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(outputStream))
        ) {

            outputStream.putNextEntry(new ZipEntry("data.txt"));

            System.out.println("ertewwer");

//            byte[] buffer = new byte[100];
//            Arrays.fill(buffer, (byte)97);
//            for (int i = 0; i < 10; i++) {
//                outputStream.write(buffer);
//            }

            printWriter.print("John Doe");
            printWriter.println(200_00);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
