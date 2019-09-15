class: inverse, center, middle

# Attribútumok reflectionnel

---

# Attribútumok lekérdezése

```java
Field[] fields = Trainer.class.getFields();
Field field = Trainer.class.getField("name"); // NoSuchFieldException
```

* Csak a `public` módosítószóval ellátottakat adja vissza
* Ha nincs, vagy nem `public`: `NoSuchFieldException`
* Ősben definiáltat is látja

---

# Hozzáférés privát attribútumokhoz

* `getDeclaredField()` metódus

```java
Field f = Trainer.class.getDeclaredField("name");
```

* Ha nem az adott osztályban van deklarálva, hanem az ősében: `NoSuchFieldException`
    * Rekurzívan meg kell keresni az ősosztályokban

---

# Attribútumok tulajdonságai

* `String getName()`
* `Class<?> getType()`
* `getDeclaringClass()`
* `getModifiers()`
* `isEnumConstant()`
* `isSynthetic()`

---

# Attribútum értékének lekérdezése

```java
Trainer trainer = new Trainer();
Field f = Trainer.class.getField("name");
String name = (String) f.get(trainer); // IllegalAccessException
```

```java
f.setAccessible(true);
String name = (String) f.get(trainer);
```

* Primitívekhez pl. `getBoolean()` metódus
* Statikus esetén objektumként `null` adandó át

---

# Attribútum értékének beállítása

```java
Trainer trainer = new Trainer();
Field f = Trainer.class.getField("name");
f.setAccessible(true);
f.set(trainer, "John Doe");
```

* Primitívekhez pl. `setBoolean()` metódus

---

# Final attribútum módosítása

```java
Field modifiersField = Field.class.getDeclaredField("modifiers");
modifiersField.setAccessible(true);
modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
```

* Nem feltétlen fog minden esetben működni (pl. ahol hivatkozva van, inline-olásra kerülhet)
* `SecurityManager` meghiúsíthatja
