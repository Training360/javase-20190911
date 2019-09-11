package innerclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSample {

    public static void main(String[] args) {
        Map<String, String> words = new HashMap<>();
        words.put("kutya", "dog");
        words.put("macska", "cat");

        for (String key: words.keySet()) {
            System.out.println(key + " " + words.get(key));
        }

        for (Map.Entry entry: words.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        Map<String, String> simple = new HashMap(){{
            put("alma", "apple");
            put("narancs", "orange");
        }};

        List numbers = new ArrayList<>();
        numbers.add(5);

        List<String> s = new ArrayList<>();

        // NEM FORDUL: List<Object> o = s;
     }
}
