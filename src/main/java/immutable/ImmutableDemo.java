package immutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutableDemo {

    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("C#");
        skills.add("Python");
        Trainer trainer = new Trainer("John Doe", skills);

        System.out.println(trainer.getSkills());

        skills.add("JavaScript");

        System.out.println(trainer.getSkills());

//        trainer.getSkills().add("JavaScript");
//        System.out.println(trainer.getSkills());
    }
}
