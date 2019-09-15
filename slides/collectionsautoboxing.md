class: inverse, center, middle



# Autoboxing használata kollekcióknál

---

# Autoboxing

* Primitív típus nem adható meg generikus típusként
* Primitív érték is átadható a metódusoknak, autoboxing

```java
List<Integer> l = new ArrayList<>();
l.add(10);
int i = l.get(0);
```

---

# Null értékek használata

* A kollekciók alapesetben beengednek `null` értékeket
* Ez alól kivétel a `TreeSet` és `TreeMap` implementáció
  * Ha nincs `null` értéket figyelembe vevő `Comparator`

---

# `NullPointerException`

```java
List<Integer> l = new ArrayList<>();
l.add(null);
int i = l.get(0);
```
