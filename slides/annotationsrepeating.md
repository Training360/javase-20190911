class: inverse, center, middle

# Ismétlődő annotációk

---

# Repeating annotation 

* Java 8-tól tehető rá ugyanaz az annotáció többször

```java
@ValidatedField(value = "trainer name", validator = NotNullValidator.class)
@ValidatedField(value = "trainer name", validator = NameValidator.class)
private String name;
```

* Előtte workaround

```java
@ValidatedFields({
    @ValidatedField(value = "trainer name", 
        validator = NotNullValidator.class)
    @ValidatedField(value = "trainer name", 
        validator = NameValidator.class)
})
private String name;
```

---

# Repeating annotation definiálása

```java
// ...
@Repeatable(ValidatedFields.class)
public @interface ValidatedField {

    // ...

}
```

```java
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatedFields {

    ValidatedField[] value();
}
```
---

# Repeating annotation reflectionnel

```java
Field[] fields = Trainer.class.getDeclaredFields();
for (Field field: fields) {
    ValidatedFields validatedFields = field.getAnnotation(ValidatedFields.class);
    if (validatedFields != null) {
        for (ValidatedField validatedField : validatedFields.value()) {
            Class<? extends Validator> validatorClass = validatedField.validator();
        }
    }
}
```

