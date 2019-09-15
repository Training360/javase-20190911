package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void add(List<? super Human> humans) {
        humans.add(new Human());
        humans.add(new Student());
    }

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        new Main().add(humans);

        List<Student> students = new ArrayList<>();
//        new Main().add(students);
    }
}
