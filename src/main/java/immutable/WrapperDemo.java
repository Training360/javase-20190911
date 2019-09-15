package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WrapperDemo {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("John Doe");
        names.add("John Doe");
        names.add("John Doe");

        List<String> um = Collections.unmodifiableList(names);

        names.add("JACK DOE");

        System.out.println(um);
    }
}
