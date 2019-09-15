package upper;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> s = new HashMap<>();
        s.put("kutya", "dog");
        s.put("macska", "cat");

        // Map<String, String> m = Map.of("kutya", "dog", "macska", "cat");
    }
}
