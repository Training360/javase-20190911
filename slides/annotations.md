class: inverse, center, middle

# Bevezetés az annotációk használatába

---
# Annotációk

* Extra információk a programmal kapcsolatban
* Un. metaadat, nem az algoritmus része
* Fordítás és futás közben is felhasználható információ

---

# Java SE beépített annotációk

* `@Override`
* `@Deprecated`
* `@SuppressWarnings`
* `@SafeVarargs`
* `@FunctionalInterface`

---

# Override annotáció metóduson

```java
@Override
public int calculateTax() {
  // ...
}
```

* Itt metóduson, de annotáció szerepelhet osztályon, interfészen, attribútumon, stb.

---

# Annotation type element

* Egy darab, ennek neve `value`

```java
@SuppressWarnings("unchecked")
public int calculateTax() {
  // ...
}
```

---

# Több annotation type element

```java
@Deprecated(since = "2.0.0", forRemoval = true)
public int calculateTax() {
  // ...
}
```

---

# Több annotáció

```java
@Override
@SuppressWarnings("unchecked")
@Deprecated(since = "2.0.0", forRemoval = true)
public int calculateTax() {
  // ...
}
```

---

# Saját annotáció


```java
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

}
```

* `@Documented`: amin van, annak a JavaDoc generálásakor illessze be az annotáció dokumentációját
* `@Target`: hova lehet elhelyezni az annotációt
* `@Inherited`: öröklődik
* `@Retention`: fordítási/futásidőben kiértékelhető


---

# Annotáció használata reflectionnel

```java
Trainer trainer = new Trainer();
Field[] fields = Trainer.class.getDeclaredFields();
for (Field field: fields) {
    field.setAccessible(true);
    Object o = field.get(trainer);
    System.out.println(field + " " + field.getAnnotation(NotNull.class));
    if (field.getAnnotation(NotNull.class) != null && o == null) {
        throw new IllegalStateException("Null value: " + field.getName());
    }
}
```
