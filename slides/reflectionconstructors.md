class: inverse, center, middle

# Konstruktorok kezelése reflectionnel

---

# Konstruktorok

```java
Constructor[] constructors = Trainer.class.getConstructors();
Constructor constructor =
        Trainer.class.getConstructor(String.class, int.class);
Class[] parameterTypes = constructor.getParameterTypes();
```

* Ha nincs: `NoSuchMethodException`

---

# Konstruktorok tulajdonságai

* `String getName()`
* `getDeclaringClass()`
* `getModifiers()`
* `getExceptionTypes()`
* `getParameterCount()`, `getParameterTypes()`
* `isSynthetic()`
* `isVarArgs()`

---

# Példányosítás konstruktorral

```java
Constructor constructor =
        Trainer.class.getConstructor(String.class, int.class);
Trainer trainer = (Trainer) constructor.newInstance("John Doe", 1970);
System.out.println(trainer.getName() + " " + trainer.getYearOfBirth());
```

