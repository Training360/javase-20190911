package comp;

import java.util.Objects;

public class Trainer
//        implements Comparable<Trainer>
{

    private String name;

    private int yearOfBirth;

//    @Override
//    public int compareTo(Trainer o) {
//        if (name == null) {
//            return -1;
//        }
//        return name.compareTo(o.name);
//    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public Trainer(String name) {
        this.name = name;
    }

    public Trainer(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
