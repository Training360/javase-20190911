class: inverse, center, middle



# Comparable és Comparator interfészek

---

# `Comparable` és `Comparator` interfészek

* `TreeSet` és `TreeMap` használja a sorrend (order) fogalmát
  * Számok esetén a matematikai rendezettség
  * `String` esetén a Unicode karakterkód (számok, nagybetűk, kisbetűk, spec. nyelvi karakterek)
* `Comparable` és `Comparator` interfészek

---

# `Comparable` interfész

```java
public interface Comparable<T> {
  public int compareTo(T o);
}
```

* "Természetes összehasonlítás" - natural ordering
* Visszaad negatív, nulla vagy pozitív értéket, ha ez az objektum kisebb, egyenlő vagy
nagyobb a paraméterként átadott objektumnál
* Tipikusan delegálás attribútumokhoz
* `equals()` metódussal összhangban

---

# `Comparable` implementálása

```java
public class Trainer implements Comparable<Trainer> {

    private String id;

    private String name;

    @Override
    public int compareTo(Trainer o) {
        return id.compareTo(o.id);
    }

    // Getter metódusok
}
```

---

# `Comparator` interfész

```java
public interface Comparator<T> {
  public int compare(T o1, T o2);
}
```

* Vagy nem implementálja a `Comparable` interfészt
* Különböző szabályok szerint lehet sorba rendezni

---

# `Comparator` interfész implementálása

```java
public NameComparator implements Comparator<Trainer> {

  public int compare(Trainer o1, Trainer o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
```

---

# `Collator` absztrakt osztály

* `String` `compareTo()` metódusa helyett
* Helyesen hasonlítja össze a speciális (ékezetes) karaktereket
* `implements Comparator`
* `Collator.getInstance()` vagy `Collator.getInstance(Locale)`
* Nagy- és kisbetűk megkülönböztetése konfigurálható
