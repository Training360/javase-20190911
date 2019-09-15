class: inverse, center, middle

# Bevezetés a reflection használatába

---

# Reflection célja

* Osztály betöltése futásidőben előálló név (String) alapján
* Osztály példányosítása futásidőben előálló név (String) alapján
* Osztály felépítésének elemzése futásidőben, pl. attribútumok, konstruktorok, metódusok lekérdezése
* Attribútum értekek lekérdezése és beállítása név (String) alapján
* Metódus hívása futásidőben előálló név alapján

---

# Property-k lekérése

* Property-nek nevezzük azon attribútumokat, melyhez getter év/vagy setter metódus van
* Lekérdezzük a metódusokat, és szűrünk a `get` kezdetűekre
* A példa nem foglalkozik a `boolean` típusú attribútumokkal, melyhez a lekérdező metódus `is` prefixszel rendelkezik

---

# Property-k lekérdezése megoldás

```java
Method[] methods = Trainer.class.getDeclaredMethods();
for (Method method: methods) {
    if (method.getName().startsWith("get")) {
        System.out.println(method.getName().substring(3));
    }
}
```

---

# Class osztály

* Reflection belépési pontja
* JVM minden referencia és primitív típushoz létrehoz egy `Class` példányt (neve így kicsit zavaró)
* Lekérdezni a néven `class` operátorral
* Le lehet kérdezni egy példánytól is a `getClass()` metódussal
* Minősített neve lekérdezhető a `getName()` <br /> metódussal

---

# Hozzáférés a Class példányhoz

```java
System.out.println(Trainer.class.getName());
Trainer trainer = new Trainer();
System.out.println(trainer.getClass().getName());
```

---

# Attribútumok, metódusok, konstruktorok lekérdezése

* `Field[] getFields()` attribútumok lekérdezésére
* `Method[] getMethods()` metódusok lekérdezésére (publikus)
    * `getDeclaredMethods()` csak az adott osztály által deklarált <br /> (nincs benne az őstől örökölt metódusok)
* `Constructor[] getConstructors()` <br /> konstruktorok lekérdezésére
* Mindnek `getName()` metódusa
