package rand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    public List<Integer> generate(Random random) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt(90) + 1);
        }
        return numbers;
    }

    public static void main(String[] args) {
        // new Random(seed)
        System.out.println(new Lotto().generate(new Random()));
    }
}
