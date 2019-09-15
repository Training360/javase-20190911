package container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Container {

    public Map<String, Object> readBeans() {
        Map<String, Object> beans = new HashMap<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     Container.class.getResourceAsStream("/beans.txt")))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] field = line.split("=");
                String left = field[0];
                String right = field[1];
                if (!left.contains(".")) {
                    Class clazz = Class.forName(right);
                    Constructor c = clazz.getConstructor();
                    Object o = c.newInstance();
                    beans.put(left, o);
                }
                else {
                    String[] parts = left.split("\\.");
                    String name = parts[0];
                    String attributeName = parts[1];
                    Object o = beans.get(name);
                    Method method = o.getClass().getMethod(
                            "set" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1),
                            String.class);
                    method.invoke(o, right);
                }
            }
        }
        catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return beans;
    }

    public static void main(String[] args) {
        Map<String, Object> beans = new Container().readBeans();
        System.out.println(beans);
    }
}
