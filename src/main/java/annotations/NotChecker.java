package annotations;

import java.lang.reflect.Field;
import java.util.Arrays;

public class NotChecker {

    public static void main(String[] args) throws Exception {
        Address address = new Address();
        address.setCountry("HU");

        Field[] fields = Address.class.getDeclaredFields();
        for (Field field: fields) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            if (annotation != null) {
                String message = annotation.value();
                System.out.println(field.getName());

                field.setAccessible(true);
                Object value = field.get(address);

                if (value == null) {
                    System.out.println(message + " - " + Arrays.toString(annotation.submessage()));
                }
            }
        }
    }
}
