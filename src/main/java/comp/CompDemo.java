package comp;

import java.text.Collator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class CompDemo {

    public static void main(String[] args) {

        Collator collator = Collator.getInstance(new Locale("hu"));
        Set<String> names = new TreeSet<>(collator);

        names.add("John Doe");
        names.add("Jack Doe");
        names.add("Jane Doe");
        names.add("Álmos Doe");
//      Exception  names.add(null);

        System.out.println(names);

//        Set<Trainer> trainers = new TreeSet<>();
//        trainers.add(new Trainer("John Doe"));
//        trainers.add(new Trainer("Jack Doe"));
//        trainers.add(new Trainer(null));
//        System.out.println(trainers);

        Set<Trainer> trainersByLength = new TreeSet<>(new NameLengthComparator());
        trainersByLength.add(new Trainer("John Doe"));
        trainersByLength.add(new Trainer("J"));
        trainersByLength.add(new Trainer("John"));
        trainersByLength.add(new Trainer("Jack"));
        trainersByLength.add(null);
        System.out.println(trainersByLength);

        Set<Trainer> trainersByNameAndYearOfBirth = new TreeSet<>(
                new NameThenDayOfBirthComparator()
        );

        trainersByNameAndYearOfBirth.add(new Trainer("John Doe", 1970));
        trainersByNameAndYearOfBirth.add(new Trainer("John Doe", 1960));
        trainersByNameAndYearOfBirth.add(new Trainer("Jack Doe", 1980));
        System.out.println(trainersByNameAndYearOfBirth);
    }
}
