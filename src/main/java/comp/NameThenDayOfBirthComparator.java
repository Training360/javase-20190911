package comp;

import java.util.Comparator;

public class NameThenDayOfBirthComparator implements Comparator<Trainer> {

    @Override
    public int compare(Trainer o1, Trainer o2) {
        if (o1.getName().equals(o2.getName())) {
            return o1.getYearOfBirth() - o2.getYearOfBirth();
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
