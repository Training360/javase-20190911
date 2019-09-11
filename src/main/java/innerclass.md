class: inverse, center, middle



# Belső osztályok

---

# Belső osztályok

* Más osztályon belül definiált osztályok
* Típusai
  * Member inner class - osztályon belül példányhoz tartozó
  * Local inner class - metóduson belül
  * Anonymous inner class - metóduson belül névtelen
  * Static nested class - osztályon belüli statikus
* Használatának előnyei
  * Elrejthető
  * Könnyebben olvasható

---

# Member inner class

* Kollekciók esetében iterátorok ezzel implementáltak

```java
public class Outer {

    public class Inner {
        public String sayHello() {
            return "Hello";
        }
    }

    public String saySomething() {
        return new Inner().sayHello();
    }
}
```

---

# Member inner class használata

```java
Outer outer = new Outer();
assertThat(outer.saySomething(), equalTo("Hello"));
```

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
assertThat(inner.sayHello(), equalTo("Hello"));
```

---

# Member inner class környezete

```java
public class Outer {

    private String message = "Hello";

    public class Inner {
        public String sayHello() {
            return message;
        }
    }

    public String saySomething() {
        return new Inner().sayHello();
    }
}
```

---

# Local inner class

```java
public class Outer {

    public String saySomething() {
        class Inner {
            public String sayHello() {
                return "Hello";
            }
        }
        return new Inner().sayHello();
    }
}
```

---

# Anonymous inner class

* `Comparator` implementációk esetén
* AWT/Swing esetménykezelők esetén

```java
public class Outer {

    private List<String> words;

    public List<String> getListSortedIgnoreCase() {
        List<String> result = new ArrayList<>(words);
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase()
					.compareTo(o2.toLowerCase());
            }
        });
        return result;
    }
}
```

---

# Static nested class

* Legegyszerűbb
* Használjuk, ha a belső osztálynak nem kell hozzáférnie példány tagokhoz

```java
public class Outer {

    public String saySomething() {
        Inner inner = new Inner();
        return inner.sayHello();
    }

    public static class Inner {
        public String sayHello() {
            return "Hello";
        }
    }
}
```

---

# Static nested class használata

```java
Outer outer = new Outer();
assertThat(outer.saySomething(), equalTo("Hello"));
```

```java
Outer.Inner inner = new Outer.Inner();
assertThat(inner.sayHello(), equalTo("Hello"));
```
