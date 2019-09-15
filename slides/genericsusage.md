class: inverse, center, middle



# Generikusok használata

---

# Generikusok előtt

* Tipikusan kollekciók használatánál
* Generikusok nélkül `Object` használata, de `instanceof` operátor kell az ellenőrzéshez, vagy `ClassCastException`
* Futás időben derül ki
* Ősosztályok, interfészek használata nem megoldás, mert lehet, hogy amit kezelni akarunk, nem módosítható

```java
List list = new ArrayList();
list.add(Integer.valueOf(5));
System.out.println((String) list.get(0)).toUpperCase()); 
	// ClassCastException
```
---

# Generikusok használata

* Típus paraméter
* Korlátozható kollekciók esetén a befogadható típus
* Fordítási időben
* Diamond operator (`<>`) értékadás jobb oldalán, felesleges a dupla típusjelölés

```java
List<String> list = new ArrayList<>();
```

---

# Használat generics nélkül

* Típus paraméter nélkül használva neve _raw type_
* Fordító figyelmeztetést ad
* `-Xlint:unchecked` paraméterrel hívva a fordítót, pontosan jelzi, hogy hol

```
Main.java uses unchecked or unsafe operations.
Main.java: Recompile with -Xlint:unchecked for details.
```

---

# Generikus és a leszármazás

* `List<Integer>` nem leszármazottja a `List<Number>` típusnak
* Generikusok nem kovariánsak

```java
List<Integer> li = new ArrayList<Integer>();
List<Number> ln = li; // Nem fordul le
```

* `List<String>` leszármazottja a `Collection<String>` típusnak

```java
List<String> l = new ArrayList<>();
Collection<String> c = l;
```