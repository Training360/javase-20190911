package upper;

import java.util.ArrayList;
import java.util.List;

public class UppercaserMain {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String> l = UppercaserCollections.uppercaser(names);

        l.add("John Doe");

        System.out.println(names);
        System.out.println(l);
    }
}
