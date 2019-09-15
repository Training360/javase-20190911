package iodemo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

    public static void main(String[] args) {
        Path path = Paths.get( "dir1");

        Path file = path.resolve("a.txt");

        System.out.println(file);

        System.out.println(path.getClass().getName());

        System.out.println(path);

        System.out.println(Files.exists(Paths.get("pom.xml")));
    }
}
