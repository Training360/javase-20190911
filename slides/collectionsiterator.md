class: inverse, center, middle



# Kollekciók bejárása

---

# Kollekciók bejárása

* `Iterator` interfész, generikussal paraméterezhető
* Hozzáférni a `Collection.iterator()` metódusával
* `next()` és `hasNext()` metódus
* `remove()` metódus
  * Dobhat `UnsupportedOperationException` kivételt
* Bejárás közben módosítás
  * `ConcurrentModificationException`

---

# `Iterator` működése

```java
List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
for(Iterator<Integer> i = values.iterator(); i.hasNext(); ) {
    int value = i.next();
    System.out.print(value + ", ");
    if (value % 2 == 0) {
        i.remove();
    }
}
System.out.println();
System.out.println(values);
```

Eredménye:

```
1, 2, 3, 4, 5,
[1, 3, 5]
```