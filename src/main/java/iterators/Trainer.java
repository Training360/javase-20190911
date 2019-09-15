package iterators;

import java.util.*;

public class Trainer {

    {
        System.out.println("Init");
        this.name = "John Doe";
    }

    public Trainer(String name) {
        System.out.println("const");
        this.name = name;
    }

    private String name;

    public static void main(String[] args) {
        Trainer trainer = new Trainer("Jack Doe");
        System.out.println(trainer.name);
        System.out.println(trainer);

        List<Trainer> trainers = new ArrayList<>(Arrays.asList(
                new Trainer("John Doe"),
                new Trainer("Jack Doe"),
                new Trainer("Jane Doe")
        ));

        Iterator<Trainer> it = trainers.iterator() ;

        while (it.hasNext()) {
            Trainer t = it.next();
            if (t.name.startsWith("Jack")) {
                it.remove();
            }
            System.out.println(t.name);
        }

        System.out.println(trainers);

    }

}
