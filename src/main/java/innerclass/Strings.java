package innerclass;

public class Strings {

    public static void main(String[] args) {
        String s1 = new String("alma");
        System.out.println(s1);
        String s2 = new String("alma");
        System.out.println(s1 == s2);

        Integer i = 129;
        Integer j = 129;

        System.out.println(i == j);

    }
}
