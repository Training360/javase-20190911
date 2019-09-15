package iodemo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassReader {

    public static void main(String[] args) {
        Path file = Paths.get("target", "classes", "col", "CollMain.class");
        try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = new byte[4];
            is.read(bytes);

            System.out.println(bytesToHex(bytes));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
