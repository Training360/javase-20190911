class: inverse, center, middle



# Generic metódus és megszorítások

---

# Generic metódus

* Típus deklarálása metódus szinten
* Főleg statikus metódusoknál, hiszen ott nem lehet a példány típust elérni
* Csak `Object` metódusok elérhetőek

```java
public static <T> Box<T> ship(T t) {
    Box<T> box = new Box<>();
    box.pack(t);
    return box;
}
```

```java
ship(new Zebra());
```

---

# Bounded type

```java
public interface CanMakeSound {
    String makeSound();
}
```

```java
public static <T extends CanMakeSound> T getFirstWithSound(List<T> list, String sound) {
        for (T item: list) {
            if (item.makeSound().equals(sound)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Not found with sound" + sound);
    }
```

---

# Megszorítások generikusokkal kapcsolatban 1

* Primitív típusok nem használhatóak típus paraméterként
* Típus paraméterrel nem lehet példányosítani
* Típus paraméterrel nem lehet statikus attribútumot létrehozni
* `instanceof` után nem állhat paraméterezett típus
* Típuskényszerítés sem használható mindig

```java
List<String> l = new ArrayList<>();
List<Object> o1 = (List<Object>) l; // NEM FORDUL
List<Object> o2 = (List<Object>)(List)l; // FORDUL
```

---

# Megszorítások generikusokkal kapcsolatban 2

* Paraméterezett típussal nem hozható létre tömb
* Nem lehet létrehozni paraméterezett típust, mely `Throwable` leszármazott
* Nem lehet metódus túlterhelés úgy, hogy a raw type ugyanaz, csak a típusparaméter eltérő
