package sort;

import java.util.*;

public class SortDemo {

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("alma");
        s.add("korte");

        List<String> l = new ArrayList<>(s);


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode() - o2.hashCode();
            }
        };

        List<String> names = new ArrayList<>(Arrays.asList("John Doe", "Jane Doe", "Jack Doe"));



        names.add("John Smith");

       // Collections.sort(names, comparator);

        names.sort(comparator);

        int index = Collections.binarySearch(names, "Jane Doe", comparator);
        System.out.println(index);

        System.out.println(names);
    }
}
