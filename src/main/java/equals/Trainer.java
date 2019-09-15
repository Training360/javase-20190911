package equals;

import java.util.Objects;

public class Trainer {

    private String name;

    private int yearOfBirth;

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (!(obj instanceof Trainer)) {
//            return false;
//        }
//        Trainer another = (Trainer) obj;
//        return this.name.equals(another.name);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(name, trainer.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth);
    }

    public static void main(String[] args) {
        Trainer t1 = new Trainer();
        Trainer t2 = new Trainer();

        System.out.println(t1.equals(t2));

        System.out.println(t1.hashCode());
        System.out.println(t1.toString());
    }
}
