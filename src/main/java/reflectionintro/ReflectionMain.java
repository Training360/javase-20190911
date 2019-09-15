package reflectionintro;

import java.lang.reflect.Field;

public class ReflectionMain {

    public static void main(String[] args) throws Exception {
        Address address = new Address();
        address.setZip("1117");
        replaceNulls(address);

        System.out.println(address); // "!!!"
    }

    private static void replaceNulls(Address address) throws Exception {
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName());
            if (field.getType() == String.class) {
                field.setAccessible(true);

                String value = (String) field.get(address);
                System.out.println(field.getName() + " = " + value);

                if (value == null) {
                    field.set(address, "!!!");
                }
            }
        }

    }
}
