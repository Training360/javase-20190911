package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polution {

    @SafeVarargs
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList;
        String s = stringLists[0].get(0);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        List list = names;

        list.add(5);

        String s = names.get(0);

        List<String>[] ss = new List[5];
        ss[0].add("ertetre");
    }
}
