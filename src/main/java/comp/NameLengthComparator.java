package comp;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Trainer> {

    @Override
    public int compare(Trainer o1, Trainer o2) {
        if (o1 == null) {
            return -1;
        }
        if (o1.getName().length() == o2.getName().length()) {
            return o1.getName().compareTo(o2.getName());
        }
        return o1.getName().length() - o2.getName().length();
    }
}
