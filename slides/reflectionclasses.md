class: inverse, center, middle

# Osztályokkal kapcsolatos információk lekérdezése reflectionnel

---

# Nevek lekérdezése különböző formátumokban

* `getName()`

```java
System.out.println(String.class.getName());    // java.lang.String 
System.out.println(Map.Entry.class.getName()); // java.util.Map$Entry
System.out.println(String[].class.getName());  // [Ljava.lang.String;
System.out.println(int.class.getName());       // int
System.out.println(Void.TYPE.getName());       // void
``` 

További formátumokban: `getSimpleName()`, <br /> `getCanonicalName()`, `getTypeName()` <br /> metódusok

---

# Csomag lekérdezése

```java
Package aPackage = aClass.getPackage();
```

---

# `Class` által hivatkozott más `Class`-ok

* `Class.getClasses()` publikus belső osztályokat, interfészeket, enumokat (az örökölteket is)
* `Class.getDeclaredClasses()` a privátakat is, de csak amik az adott típuson belül vannak deklarálva (örökölteket nem)
* `Class.getDeclaringClass()` visszaadja a típust, melyben belső típusként szerepel (csak member esetén működik, <br / >tehát ahol tagként szerepel)
* `Class.getEnclosingClass()` (local inner <br /> esetén is,  azaz ha metóduson belül definiált)

---

# Ős és interfészek lekérdezése

* `getSuperclass()` metódus ős lekérdezésére
* `getInterfaces()` implementált interfészek lekérdezésére
    * Csak az osztály által definiált interfészeket adja vissza, rekurzívan végig kell menni az ősökön

---

# Módosítószók lekérdezése

```java
int modifiers = Trainer.class.getModifiers();
```

* `Modifier` osztály
  * Konstansok, pl. `Modifier.ABSTRACT`
  * Milyen módosítószók jöhetnek szóba, pl. `Modifier.classModifiers()`
  * `int` típus feloldása, <br /> pl. `Modifier.isAbstract(int)`
  * Olvashatóan kiírni: <br /> `Modifier.toString(int)`

---

# Egyéb ismérvek

* `isPrimitive()`
* `isLocalClass()`
* `isMemberClass()`
* `isAnonymousClass()`
* `isEnum()`
* `getEnumConstants()`
* `isSynthetic()`

---

# instanceof helyett

* `isAssignableFrom(Class<?> cls)` 
* `isInstance(Object o)`
* Hasonló, mint az `instanceof`, csak nem kell ismerni az osztályt fordítási időben (pl. dinamikusan betöltött)

---

# Csomagok lekérdezése

* Ismert csomagok: `Package.getPackages()` statikus metódus

---

# Implementáló osztályok, leszármazottak

* Standard reflectionnel nem lekérhető
  * Leszármazott osztályok
  * Adott interfészt implementáló osztályok
  * Megírható fájlrendszer vagy jar fájl kezeléssel
* [Reflections](https://github.com/ronmamo/reflections) projekt
  * Classpath scan és indexelés

