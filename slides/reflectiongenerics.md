class: inverse, center, middle

# Generikusok és tömbök használata reflectionnel

---

# Példányosítás

```java
Constructor<ArrayList> c = ArrayList.class.getConstructor();
List<Integer> names = c.newInstance();
```

---

# Generikusok használata attribútumoknál

* Futás időben elveszik a paraméter típus, de reflectionnel a típus paramétert le lehet kérni
* Mivel a `Class` nem tartalmazza, lekérdezésére külön metódus, a `getType()` nem jó

```java
Field field = Trainer.class.getDeclaredField("courses"); 
    // List<String>
Type type = field.getGenericType();
if (type instanceof ParameterizedType){
    ParameterizedType aType = (ParameterizedType) type;
    Type[] fieldArgTypes = aType.getActualTypeArguments();
    for (Type fieldArgType : fieldArgTypes) {
        Class fieldArgClass = (Class) fieldArgType;
        System.out.println("fieldArgClass = " + fieldArgClass);
    }
}
```

---

# Generikusok használata metódus paramétereknél és visszatérési értékeknél

```java
Type returnType = method.getGenericReturnType();

Type[] genericParameterTypes = method.getGenericParameterTypes();
```

---

# Tömbök

* `java.lang.reflect.Array` osztály használatával

```java
int[] intArray = (int[]) Array.newInstance(int.class, 3);
```

```java
Class intArray = Class.forName("[I");
Class stringArrayClass = Class.forName("[Ljava.lang.String;");
```

* `Class` osztály `isArray()` metódusa
* `Class` osztály `getComponentType()` <br /> metódusa adja meg az elemek típusát
